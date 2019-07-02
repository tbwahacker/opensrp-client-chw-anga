package org.smartregister.chw.malaria.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;
import org.smartregister.chw.malaria.util.Constants;
import org.smartregister.malaria.R;
import org.smartregister.view.activity.BaseProfileActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class BaseMalariaProfileActivity extends BaseProfileActivity implements MalariaProfileContract.View {
    protected MemberObject MEMBER_OBJECT;
    private BaseMalariaProfilePresenter profilePresenter;
    private TextView textViewName, textViewGender, textViewLocation, textViewUniqueID, textViewRecordMalaria;
//    private View recordMalariaView;

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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.text_blue), PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BaseMalariaProfileActivity.this.finish();
            }
        });
        appBarLayout = this.findViewById(R.id.collapsing_toolbar_appbarlayout);
        if (Build.VERSION.SDK_INT >= 21) {
            appBarLayout.setOutlineProvider(null);
        }

        textViewName = findViewById(R.id.textview_name);
        textViewGender = findViewById(R.id.textview_gender);
        textViewLocation = findViewById(R.id.textview_address);
        textViewUniqueID = findViewById(R.id.textview_id);
        textViewRecordMalaria = findViewById(R.id.textview_record_malaria);
//        recordMalariaView = findViewById(R.id.record_visit_malaria);

        MEMBER_OBJECT = (MemberObject) getIntent().getSerializableExtra(Constants.MALARIA_MEMBER_OBJECT.MEMBER_OBJECT);

        initializePresenter();

        profilePresenter.attachView(this);

        profilePresenter.fillProfileData(MEMBER_OBJECT);

    }

    @Override
    public void setProfileViewWithData() {
        int age = new Period(new DateTime(MEMBER_OBJECT.getAge()), new DateTime()).getYears();
        textViewName.setText(String.format("%s %s %s, %d", MEMBER_OBJECT.getFirstName(), MEMBER_OBJECT.getMiddleName(), MEMBER_OBJECT.getLastName(), age));
        textViewGender.setText(MEMBER_OBJECT.getGender());
        textViewLocation.setText(MEMBER_OBJECT.getAddress());
        textViewUniqueID.setText(MEMBER_OBJECT.getUniqueId());

        if (MEMBER_OBJECT.getMalariaTestDate() != null) {
            try {
                Date date =
                        new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse((MEMBER_OBJECT.getMalariaTestDate()));
                int malaria_test_date_processed = new Period(new DateTime(date), new DateTime()).getDays();
                profilePresenter.recordMalariaButton(malaria_test_date_processed, textViewRecordMalaria, this);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void initializePresenter() {
        profilePresenter = new BaseMalariaProfilePresenter(this, MEMBER_OBJECT);
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
        int id = view.getId();
        if (id == R.id.title_layout) {
            onBackPressed();
        } else if (id == R.id.textview_record_malaria) {
            profilePresenter.recordMalariaFollowUp(this);
        }
    }

    @Override
    protected void onDestroy() {
        profilePresenter.detachView();
        super.onDestroy();

    }
}
