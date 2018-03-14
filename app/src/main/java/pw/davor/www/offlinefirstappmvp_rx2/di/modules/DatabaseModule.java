package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.data.RepositoryImpl;
import pw.davor.www.offlinefirstappmvp_rx2.data.local.AppDatabase;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.ApiService;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ApplicationContext;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.DataRepo;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.DatabaseInfo;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.RetrofitInfo;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio on 10/03/2018.
 */
@Module
public class DatabaseModule {

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

    @Singleton
    @Provides
    AppDatabase providesAppDatabase(@ApplicationContext Context context, @DatabaseInfo String databaseName){
        return Room.databaseBuilder(context, AppDatabase.class, databaseName).build();

    }

    @Singleton
    @Provides
    @DataRepo
    Repository providesRepository(AppDatabase appDatabase, ApiService apiService){
        return new RepositoryImpl(appDatabase, apiService);
    }

    @Singleton
    @Provides
    ApiService providesApiService(@RetrofitInfo String baseUrl) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build().create(ApiService.class);
    }


}
