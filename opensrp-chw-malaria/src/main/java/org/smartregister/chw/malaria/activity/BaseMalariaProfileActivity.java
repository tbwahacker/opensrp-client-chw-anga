package org.smartregister.chw.malaria.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.commonregistry.CommonPersonObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.malaria.R;
import org.smartregister.view.activity.BaseProfileActivity;

import java.lang.ref.WeakReference;

public class BaseMalariaProfileActivity extends BaseProfileActivity implements MalariaProfileContract.View, MalariaProfileContract.Presenter {
    private Context context;
    private CommonPersonObjectClient client;
    private WeakReference<MalariaProfileContract.View> view;

    @Override
    protected void onCreation() {
        super.onCreation();
        setContentView(R.layout.activity_malaria_profile);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public MalariaProfileContract.View getView() {
        if(view != null) {
            return view.get();
        } else {
            return null;
        }
    }

    @Override
    public void getProfileData(CommonPersonObjectClient client) {
        //feed the view with the processed data
    }

    @Override
    public MalariaProfileContract.Presenter presenter() {
        return null;
    }

    @Override
    public void startProfileActivity(Intent intent) {
        //process the intent and get the person object
    }

    @Override
    public void fetchProfileData(Intent intent) {
        //process profile data from the intent
        this.client = (CommonPersonObjectClient) intent.getSerializableExtra("client");
        getProfileData(this.client);
    }


    @Override
    protected void initializePresenter() {
        //initialize presenter
    }

    @Override
    protected ViewPager setupViewPager(ViewPager viewPager) {
        return null;
    }

    @Override
    protected void fetchProfileData() {

    }
}
