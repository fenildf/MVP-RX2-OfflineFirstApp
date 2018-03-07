package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.local.AppDatabase;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ApplicationContext;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.DatabaseInfo;

/**
 * Created by studio on 07/03/2018.
 */
@Module
public class AppDatabaseModule {

    @Singleton
    @Provides
    AppDatabase providesAppDatabase(@ApplicationContext Context context, @DatabaseInfo String databaseName){
        return Room.databaseBuilder(context, AppDatabase.class, databaseName).build();

    }
}
