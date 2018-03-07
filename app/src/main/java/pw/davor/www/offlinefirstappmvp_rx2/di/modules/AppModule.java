package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.application.OfflineFirstApp;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ApplicationContext;

/**
 * Created by studio on 07/03/2018.
 */
@Module
public class AppModule {

    private OfflineFirstApp mApplication;

    public AppModule(OfflineFirstApp mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    @ApplicationContext
    Context providesApplicationContext(){
        return mApplication;
    }

    @Singleton
    @Provides
    OfflineFirstApp providesApplication(){
        return mApplication;
    }

}
