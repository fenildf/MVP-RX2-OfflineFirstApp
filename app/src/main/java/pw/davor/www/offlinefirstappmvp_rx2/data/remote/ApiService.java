package pw.davor.www.offlinefirstappmvp_rx2.data.remote;

import io.reactivex.Flowable;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.DatePojo;
import retrofit2.http.GET;

/**
 * Created by bnc on 16.2.2018..
 */

public interface ApiService {
    @GET("/")
    Flowable<DatePojo> getDate();
}
