package pw.davor.www.offlinefirstappmvp_rx2.di.components;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import pw.davor.www.offlinefirstappmvp_rx2.application.OfflineFirstApp;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.AppModule;

/**
 * Created by studio on 07/03/2018.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent extends AndroidInjector<OfflineFirstApp> {


    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<OfflineFirstApp> {
    }

}
