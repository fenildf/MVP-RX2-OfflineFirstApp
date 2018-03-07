package pw.davor.www.offlinefirstappmvp_rx2.di.components;

import javax.inject.Singleton;

import dagger.Component;
import pw.davor.www.offlinefirstappmvp_rx2.application.OfflineFirstApp;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.AppDatabaseModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.AppModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.DataSourceModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.RepositoryModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.RetrofitModule;

/**
 * Created by studio on 07/03/2018.
 */
@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class, AppDatabaseModule.class, RetrofitModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(OfflineFirstApp app);

    Repository getRepository();
}
