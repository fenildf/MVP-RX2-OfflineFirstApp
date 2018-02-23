package pw.davor.www.offlinefirstappmvp_rx2.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.data.RepositoryImpl;
import pw.davor.www.offlinefirstappmvp_rx2.data.local.AppDatabase;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.ApiService;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.RetrofitClient;
import pw.davor.www.offlinefirstappmvp_rx2.helpers.Helpers;

/**
 * Created by bnc on 16.2.2018..
 */

public class OfflineFirstApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //Stetho -> So we can View our database via Google Chrome
    }

    public Repository getRepository() {
        return RepositoryImpl.getInstance(getLocalDatabase(), getRemoteService());
    }

    private AppDatabase getLocalDatabase() {
        return AppDatabase.getInstance(getApplicationContext());
    }

    private ApiService getRemoteService() {
        return RetrofitClient.getInstance(Helpers.BASE_URL).create(ApiService.class);
    }
}
