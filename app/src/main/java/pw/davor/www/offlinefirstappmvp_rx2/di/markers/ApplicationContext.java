package pw.davor.www.offlinefirstappmvp_rx2.di.markers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by studio on 07/03/2018.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {


}
