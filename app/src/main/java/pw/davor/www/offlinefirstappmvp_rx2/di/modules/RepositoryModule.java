package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.data.RepositoryImpl;
import pw.davor.www.offlinefirstappmvp_rx2.data.local.AppDatabase;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.ApiService;

/**
 * Created by studio on 07/03/2018.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    Repository providesRepository(AppDatabase appDatabase, ApiService apiService){
        return new RepositoryImpl(appDatabase, apiService);
    }
}
