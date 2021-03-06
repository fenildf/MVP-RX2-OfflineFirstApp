package pw.davor.www.offlinefirstappmvp_rx2.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pw.davor.www.offlinefirstappmvp_rx2.R;
import pw.davor.www.offlinefirstappmvp_rx2.application.OfflineFirstApp;
import pw.davor.www.offlinefirstappmvp_rx2.base.BaseFragment;
import pw.davor.www.offlinefirstappmvp_rx2.data.Repository;
import pw.davor.www.offlinefirstappmvp_rx2.data.models.dataModels.DatePojoDataModel;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    private RecyclerView mRecycler;
    private RecyclerAdapter mAdapter;
    private HomeContract.Presenter mPresenter;
    private Repository repository;

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new RecyclerAdapter(getContext());



        if (getActivity() != null && getActivity().getApplication() != null) {
            repository = ((OfflineFirstApp) (getActivity().getApplication())).getRepository();
            mPresenter = new HomePresenter(this, repository);

        } else {
            showErrorSnack("App is null :\\");
        }
        // Just some precauison.. this mess can be sorted out with DI.

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycler = view.findViewById(R.id.home_recycler);

        if (mRecycler.getLayoutManager() == null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
            layoutManager.setSmoothScrollbarEnabled(true);

            mRecycler.setLayoutManager(layoutManager);
        }


        if (mRecycler.getAdapter() == null) {
            mRecycler.setAdapter(mAdapter);
        }


    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onBind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onUnbind();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void infoSnack(String message) {
        showInfoSnack(message);
    }

    @Override
    public void confirmSnack(String message) {
        showConfirmationSnack(message);
    }

    @Override
    public void errorSnack(String message) {
        showErrorSnack(message);
    }

    @Override
    public void updateRecycler(DatePojoDataModel datePojo) {
        mAdapter.update(datePojo);
        mAdapter.notifyItemInserted(mAdapter.getItemCount());
        mRecycler.smoothScrollToPosition(mAdapter.getItemCount()-1);

    }
}
