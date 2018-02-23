package pw.davor.www.offlinefirstappmvp_rx2.base;

/**
 * Created by bnc on 16.2.2018..
 */

public interface BasePresenter<T extends BaseView> {
    void onBind(T t);
    void onUnbind();
}
