package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.support.AndroidSupportInjectionModule;
import pw.davor.www.offlinefirstappmvp_rx2.application.OfflineFirstApp;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ApplicationContext;

/**
 * Created by studio on 07/03/2018.
 */
@Module(includes = {AndroidSupportInjectionModule.class, DatabaseModule.class, BindingModule.class})
public class AppModule {

    @Singleton
    @Provides
    @ApplicationContext
    Context providesApplicationContext(OfflineFirstApp application) {
        return application.getApplicationContext();
    }



}
