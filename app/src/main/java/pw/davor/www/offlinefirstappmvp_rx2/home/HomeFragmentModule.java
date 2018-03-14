package pw.davor.www.offlinefirstappmvp_rx2.home;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.ActivityContext;
import pw.davor.www.offlinefirstappmvp_rx2.di.markers.DataRepo;
import pw.davor.www.offlinefirstappmvp_rx2.di.scopes.PerFragment;

/**
 * Created by studio on 07/03/2018.
 */

@Module
public class HomeFragmentModule {


    @PerFragment
    @Provides
    HomeContract.View provideView(HomeFragment fragment) {
        return fragment;
    }

    @PerFragment
    @Provides
    HomeContract.Presenter providePresenter(HomeContract.View view, @DataRepo Repository repository) {
        return new HomePresenter(view, repository);
    }

    @PerFragment
    @Provides
    @ActivityContext
    Context provideActivityContext(HomeFragment fragment) {
        return fragment.getContext();
    }

    @PerFragment
    @Provides
    RecyclerAdapter provideRecyclerAdapter(@ActivityContext Context context) {
        return new RecyclerAdapter(context);
    }

}
