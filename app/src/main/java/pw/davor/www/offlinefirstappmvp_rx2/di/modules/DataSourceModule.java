package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.DatabaseInfo;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.RetrofitInfo;

/**
 * Created by studio on 07/03/2018.
 */
@Module
public class DataSourceModule {

    @Singleton
    @Provides
    @DatabaseInfo
    String providesDatabaseName() {
        return "offline-first-app-db";
    }

    @Singleton
    @Provides
    @RetrofitInfo
    String providesRetrofitBaseUrl() {
        return "http://date.jsontest.com/";
    }
}
