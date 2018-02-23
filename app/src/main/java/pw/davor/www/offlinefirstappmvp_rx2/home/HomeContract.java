package pw.davor.www.offlinefirstappmvp_rx2.home;

import pw.davor.www.offlinefirstappmvp_rx2.base.BasePresenter;
import pw.davor.www.offlinefirstappmvp_rx2.base.BaseView;
import pw.davor.www.offlinefirstappmvp_rx2.data.dataModels.DatePojo;

/**
 * Created by bnc on 16.2.2018..
 */

public interface HomeContract {
    interface View extends BaseView{
        void showToast(String message);
        void infoSnack(String message);
        void confirmSnack(String message);
        void errorSnack(String message);
        void updateRecycler(DatePojo datePojo);
    }
    interface Presenter extends BasePresenter<View>{
        void getItemFromRepo();
    }
}
