package pw.davor.www.offlinefirstappmvp_rx2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import pw.davor.www.offlinefirstappmvp_rx2.R;

/**
 * Created by bnc on 16.2.2018..
 */

public class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
    }

    protected void showInfoSnack(String message) {
        if (getContext() != null && getView() != null) {
            final Snackbar snackbar;
            snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
            snackBarView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGrey));
            snackbar.show();
        }
    }


    protected void showConfirmationSnack(String message) {
        if (getContext() != null && getView() != null) {
            final Snackbar snackbar;
            snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
            snackBarView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGreen));
            snackbar.show();
        }

    }


    protected void showErrorSnack(String message) {
        if (getContext() != null && getView() != null) {
            final Snackbar snackbar;
            snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            TextView textView = snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
            snackBarView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorRed));
            snackbar.show();
        }

    }
}
