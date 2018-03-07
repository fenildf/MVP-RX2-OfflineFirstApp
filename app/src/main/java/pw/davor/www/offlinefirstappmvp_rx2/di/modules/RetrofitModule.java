package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.remote.ApiService;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.RetrofitInfo;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by studio on 07/03/2018.
 */
@Module
public class RetrofitModule {

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
