package pw.davor.www.offlinefirstappmvp_rx2.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ActivityContext;
import pw.davor.www.offlinefirstappmvp_rx2.di.scopes.FragmentScope;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomeContract;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomeFragment;
import pw.davor.www.offlinefirstappmvp_rx2.home.HomePresenter;
import pw.davor.www.offlinefirstappmvp_rx2.home.RecyclerAdapter;

/**
 * Created by studio on 07/03/2018.
 */

@Module
public class HomeFragmentModule {

    private HomeFragment fragment;

    public HomeFragmentModule(HomeFragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    HomeContract.View provideView() {
        return fragment;
    }

    @FragmentScope
    @Provides
    HomeContract.Presenter providePresenter(HomeContract.View view, Repository repository) {
        return new HomePresenter(view, repository);
    }

    @FragmentScope
    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return fragment.getContext();
    }

    @FragmentScope
    @Provides
    RecyclerAdapter provideRecyclerAdapter(@ActivityContext Context context) {
        return new RecyclerAdapter(context);
    }

}
