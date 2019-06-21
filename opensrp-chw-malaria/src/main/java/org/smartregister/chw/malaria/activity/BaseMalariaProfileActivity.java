package org.smartregister.chw.malaria.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;
import org.smartregister.chw.malaria.util.Constants;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.helper.ImageRenderHelper;
import org.smartregister.malaria.R;
import org.smartregister.view.activity.BaseProfileActivity;

import java.lang.ref.WeakReference;

public class BaseMalariaProfileActivity extends BaseProfileActivity implements MalariaProfileContract.View, MalariaProfileContract.Presenter {
    private final String TAG = getClass().getSimpleName();
    private Context context;
    private static CommonPersonObjectClient client;
    protected MemberObject MEMBER_OBJECT;
    private WeakReference<MalariaProfileContract.View> view;

    public static void startProfileActivity(Activity activity, MemberObject memberObject) {
        Intent intent = new Intent(activity, BaseMalariaProfileActivity.class);
        intent.putExtra(Constants.MALARIA_MEMBER_OBJECT.MEMBER_OBJECT, memberObject);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreation() {
        setContentView(R.layout.activity_malaria_profile);
        Toolbar toolbar = findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);

        MEMBER_OBJECT = (MemberObject) getIntent().getSerializableExtra(Constants.MALARIA_MEMBER_OBJECT.MEMBER_OBJECT);

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
        appBarLayout = (AppBarLayout)this.findViewById(R.id.collapsing_toolbar_appbarlayout);
        if (Build.VERSION.SDK_INT >= 21) {
            appBarLayout.setOutlineProvider((ViewOutlineProvider)null);
        }

        imageRenderHelper = new ImageRenderHelper(this);
        setupViews();
    }

    @Override
    protected void setupViews() {
        int age = new Period(new DateTime(MEMBER_OBJECT.getAge()), new DateTime()).getYears();

        TextView textViewName = findViewById(R.id.textview_name);
        textViewName.setText(String.format("%s %s %s, %d", MEMBER_OBJECT.getFirst_name(), MEMBER_OBJECT.getMiddle_name(), MEMBER_OBJECT.getLast_name(), age));

        TextView textViewGender = findViewById(R.id.textview_gender);
        textViewGender.setText(MEMBER_OBJECT.getGender());

        TextView textViewLocation = findViewById(R.id.textview_address);
        textViewLocation.setText(MEMBER_OBJECT.getAddress());

        TextView textViewUniqueID = findViewById(R.id.textview_id);
        textViewUniqueID.setText(MEMBER_OBJECT.getUnique_id());
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
    public MalariaProfileContract.Presenter presenter() {
        return (MalariaProfileContract.Presenter) presenter;
    }


    @Override
    protected void initializePresenter() {
        presenter = new BaseMalariaProfilePresenter(this, MEMBER_OBJECT);
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
        if(view.getId() == R.id.title_layout) {
            onBackPressed();
        }
    }

    @Override
    public void onDestroy(boolean b) {
        //
    }
}
