package org.smartregister.chw.malaria.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.helper.ImageRenderHelper;
import org.smartregister.malaria.R;
import org.smartregister.view.activity.BaseProfileActivity;
import timber.log.Timber;

import java.lang.ref.WeakReference;

public class BaseMalariaProfileActivity extends BaseProfileActivity implements MalariaProfileContract.View, MalariaProfileContract.Presenter {
    private final String TAG = getClass().getCanonicalName();
    private Context context;
    private static CommonPersonObjectClient client;
    private WeakReference<MalariaProfileContract.View> view;

    public static void startProfileActivity(Intent intent) {
        client = (CommonPersonObjectClient) intent.getSerializableExtra("client");
    }

    @Override
    protected void onCreation() {
        this.setContentView(R.layout.activity_malaria_profile);
        Toolbar toolbar = findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.text_blue), PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(android.view.View v) {
                BaseMalariaProfileActivity.this.finish();
            }
        });
        this.appBarLayout = (AppBarLayout)this.findViewById(R.id.collapsing_toolbar_appbarlayout);
        if (Build.VERSION.SDK_INT >= 21) {
            this.appBarLayout.setOutlineProvider((ViewOutlineProvider)null);
        }

        this.imageRenderHelper = new ImageRenderHelper(this);
        setContentView(R.layout.activity_malaria_profile);
    }

    @Override
    protected void setupViews() {
        super.setupViews();
        Timber.e(client + "");
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
        Log.v(TAG, client + "");
    }

    @Override
    public MalariaProfileContract.Presenter presenter() {
        return null;
    }

    @Override
    public void fetchProfileData(Intent intent) {
        //process profile data from the intent
        CommonPersonObjectClient client = (CommonPersonObjectClient) intent.getSerializableExtra("client");
        getProfileData(client);
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
        //fetch profile data
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == android.R.id.home) {
            onBackPressed();
        }
    }
}
