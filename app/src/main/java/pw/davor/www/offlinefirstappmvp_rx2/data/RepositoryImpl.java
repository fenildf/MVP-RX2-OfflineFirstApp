package pw.davor.www.offlinefirstappmvp_rx2.data;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pw.davor.www.offlinefirstappmvp_rx2.data.dataModels.DatePojo;
import pw.davor.www.offlinefirstappmvp_rx2.data.local.AppDatabase;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.ApiService;

/**
 * Created by bnc on 16.2.2018..
 */

public class RepositoryImpl implements Repository {

    private static Repository repository;
    private final AppDatabase mLocal;
    private final ApiService mRemote;

    public RepositoryImpl(AppDatabase mLocal, ApiService mRemote) {
        this.mLocal = mLocal;
        this.mRemote = mRemote;
    }

    public static Repository getInstance(AppDatabase local, ApiService remote) {

        repository = new RepositoryImpl(local, remote);
        return repository;
    }

    @Override
    public Flowable<DatePojo> getPojo() {

        return Flowable.concat(getPojoWithTimeout(1), mRemote.getDate().subscribeOn(Schedulers.io()).doOnNext(new Consumer<DatePojo>() {
            @Override
            public void accept(DatePojo datePojo) throws Exception {
                mLocal.datePojoDao().insert(datePojo);
            }
        }).delay(2, TimeUnit.SECONDS));

        //This is where things get tricky. We use concat operator to merge two observables into one. However, second observable won't start if first observable isn't completed.
        //As soon as first observable completes, we ask for data from second observables and their value is saved to local database inside doOnNext operator
        //delay() operator is here to simulate network latency (the main server is well optimized lol)

    }

    private Flowable<DatePojo> getPojoWithTimeout(int seconds) {
        return mLocal.datePojoDao().getAllPojos().subscribeOn(Schedulers.computation()).flatMapIterable(new Function<List<DatePojo>, Iterable<DatePojo>>() {
            @Override
            public Iterable<DatePojo> apply(List<DatePojo> datePojos) throws Exception {
                return datePojos;
            }
        }).timeout(seconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io()).onErrorResumeNext(new Function<Throwable, Publisher<? extends DatePojo>>() {
                    @Override
                    public Publisher<? extends DatePojo> apply(Throwable throwable) throws Exception {
                        return Flowable.empty();
                    }
                });

        //Disclaimer:
        //We use flatMapIterable to map from Flowable<List<DatePojo>> to Flowable<DatePojo>
        //We are using timeout to fire onComplete after N seconds if for some reason we can't retrive data (in this case, database is empty). If database is empty, it will fire
        //onError which breaks the eventStream, so we user onErrorResumeNext to return empty Flowable which leads to onComplete

        //https://stackoverflow.com/questions/44945285/how-to-handel-no-results-with-android-room-and-rxjava-2

    }
}
