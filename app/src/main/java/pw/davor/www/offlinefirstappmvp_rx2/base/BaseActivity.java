package pw.davor.www.offlinefirstappmvp_rx2.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bnc on 16.2.2018..
 */

public class BaseActivity extends AppCompatActivity {

    protected void addFragmentToActivity(FragmentManager fragmentManager, Fragment fragment, int resId, String tag) {
        fragmentManager.beginTransaction()
                .replace(resId, fragment, tag)
                .commit();
    }
}
