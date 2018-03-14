package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import pw.davor.www.offlinefirstappmvp_rx2.di.scopes.PerFragment;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomeFragment;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomeFragmentModule;

/**
 * Created by studio on 14/03/2018.
 */
@Module
public abstract class BindingModule {

    @PerFragment
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment bindHomeFragment();
}
