package pw.davor.www.offlinefirstappmvp_rx2.application;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.di.components.ApplicationComponent;
import pw.davor.www.offlinefirstappmvp_rx2.di.components.DaggerApplicationComponent;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.AppDatabaseModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.AppModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.DataSourceModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.RepositoryModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.RetrofitModule;

/**
 * Created by bnc on 16.2.2018..
 */

public class OfflineFirstApp extends Application {

    @Inject
    Repository repository;

    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //Stetho -> So we can View our database via Google Chrome

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .appDatabaseModule(new AppDatabaseModule())
                .dataSourceModule(new DataSourceModule())
                .retrofitModule(new RetrofitModule())
                .repositoryModule(new RepositoryModule())
                .build();

        applicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static OfflineFirstApp get(Context context){
        return (OfflineFirstApp) context.getApplicationContext();
    }
}
