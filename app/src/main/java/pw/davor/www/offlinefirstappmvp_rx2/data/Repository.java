package pw.davor.www.offlinefirstappmvp_rx2.data;

import io.reactivex.Flowable;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.dataModels.DatePojoDataModel;

/**
 * Created by bnc on 16.2.2018..
 */

public interface Repository {

    Flowable<DatePojoDataModel> getPojo();
}
