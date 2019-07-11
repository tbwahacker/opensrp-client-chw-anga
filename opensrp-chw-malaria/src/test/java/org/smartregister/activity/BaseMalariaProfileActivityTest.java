package org.smartregister.activity;

//import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.smartregister.malaria.BuildConfig;

//import org.robolectric.Robolectric;
//import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class BaseMalariaProfileActivityTest {
    //    public BaseMalariaProfileActivity baseMalariaProfileActivity;
    @Before
    public void setUp() {
//        baseMalariaProfileActivity = Robolectric.setupActivity(BaseMalariaProfileActivity.class);
    }


    @Test
    public void shouldNotBeNull() throws Exception {
//        Assert.assertNotNull(baseMalariaProfileActivity);
    }

    @Test
    public void startProfileActivity() {
    }

    @Test
    public void onCreation() {
    }

    @Test
    public void setProfileViewWithData() {
    }

    @Test
    public void hideView() {
    }

    @Test
    public void setDueColor() {
    }

    @Test
    public void setOverDueColor() {
    }

    @Test
    public void initializePresenter() {
    }

    @Test
    public void setupViewPager() {
    }

    @Test
    public void fetchProfileData() {
    }

    @Test
    public void onClick() {
    }

    @Test
    public void onDestroy() {
    }
}