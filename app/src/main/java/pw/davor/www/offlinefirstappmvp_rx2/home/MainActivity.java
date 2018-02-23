package pw.davor.www.offlinefirstappmvp_rx2.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import pw.davor.www.offlinefirstappmvp_rx2.R;
import pw.davor.www.offlinefirstappmvp_rx2.base.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("HOME_FRAGMENT");
        if (fragment == null) fragment = HomeFragment.newInstance();

        addFragmentToActivity(fragmentManager, fragment, R.id.main_activity_frame, "HOME_FRAGMENT");
    }
}
