package pw.davor.www.offlinefirstappmvp_rx2.application;

import com.facebook.stetho.Stetho;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import pw.davor.www.offlinefirstappmvp_rx2.di.components.DaggerApplicationComponent;

/**
 * Created by bnc on 16.2.2018..
 */

public class OfflineFirstApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //Stetho -> So we can View our database via Google Chrome

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}
