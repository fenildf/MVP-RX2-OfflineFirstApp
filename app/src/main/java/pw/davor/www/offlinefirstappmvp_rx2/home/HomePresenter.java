package pw.davor.www.offlinefirstappmvp_rx2.home;

import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.DisposableSubscriber;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.data.dataModels.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private Repository repository;
    private CompositeDisposable eventStream = new CompositeDisposable();

    public HomePresenter(HomeContract.View mView, Repository repository) {
        this.mView = mView;
        this.repository = repository;
    }

    @Override
    public void onBind(HomeContract.View view) {
        mView = view;
        getItemFromRepo();

    }

    @Override
    public void onUnbind() {
        mView = null;
        eventStream.clear();

    }

    @Override
    public void getItemFromRepo() {
        eventStream.add(repository.getPojo()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {
                        mView.infoSnack("Fetching new data!");

                    }
                })
                .subscribeWith(new DisposableSubscriber<DatePojo>() {
                    @Override
                    public void onNext(DatePojo datePojo) {
                        mView.updateRecycler(datePojo);

                    }

                    @Override
                    public void onError(Throwable t) {
                        mView.errorSnack("Error while fetching new data. Are you offline?");
                        Log.d("TAGG","Err:"+t);

                    }

                    @Override
                    public void onComplete() {
                        //nothing to see here
                        mView.showToast("Fresh data loaded");

                    }
                })
        );
    }
}
