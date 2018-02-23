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

        //delay() operator is here to simulate network latency

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

    }
}
