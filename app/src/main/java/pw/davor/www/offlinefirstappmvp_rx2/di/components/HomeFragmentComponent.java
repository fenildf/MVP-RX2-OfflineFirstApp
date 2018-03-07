package pw.davor.www.offlinefirstappmvp_rx2.di.components;

import dagger.Component;
import pw.davor.www.offlinefirstappmvp_rx2.di.modules.HomeFragmentModule;
import pw.davor.www.offlinefirstappmvp_rx2.di.scopes.FragmentScope;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomeFragment;

/**
 * Created by studio on 07/03/2018.
 */
@FragmentScope
@Component(dependencies = {ApplicationComponent.class}, modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment fragment);
}
