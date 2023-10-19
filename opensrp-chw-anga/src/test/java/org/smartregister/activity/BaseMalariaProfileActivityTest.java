package org.smartregister.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.anga.activity.BaseAngaProfileActivity;
import org.smartregister.chw.anga.contract.AngaProfileContract;
import org.smartregister.domain.AlertStatus;
import org.smartregister.anga.R;

import static org.mockito.Mockito.validateMockitoUsage;

public class BaseAngaProfileActivityTest {
    @Mock
    public BaseAngaProfileActivity baseAngaProfileActivity;

    @Mock
    public AngaProfileContract.Presenter profilePresenter;

    @Mock
    public View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAngaProfileActivity);
    }

    @Test
    public void setOverDueColor() {
        baseAngaProfileActivity.setOverDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

    @Test
    public void formatTime() {
        BaseAngaProfileActivity activity = new BaseAngaProfileActivity();
        try {
            Assert.assertEquals("25 Oct 2019", Whitebox.invokeMethod(activity, "formatTime", "25-10-2019"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkHideView() {
        baseAngaProfileActivity.hideView();
        Mockito.verify(view, Mockito.never()).setVisibility(View.GONE);
    }

    @Test
    public void checkProgressBar() {
        baseAngaProfileActivity.showProgressBar(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void medicalHistoryRefresh() {
        baseAngaProfileActivity.refreshMedicalHistory(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void onClickBackPressed() {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.title_layout);
        Mockito.doNothing().when(baseAngaProfileActivity).onBackPressed();
        baseAngaProfileActivity.onClick(view);
        Mockito.verify(baseAngaProfileActivity).onBackPressed();
    }

    @Test
    public void onClickOpenMedicalHistory() {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlLastVisit);
        Mockito.doNothing().when(baseAngaProfileActivity).openMedicalHistory();
        baseAngaProfileActivity.onClick(view);
        Mockito.verify(baseAngaProfileActivity).openMedicalHistory();
    }

    @Test
    public void onClickOpenUpcomingServices() {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlUpcomingServices);
        Mockito.doNothing().when(baseAngaProfileActivity).openUpcomingService();
        baseAngaProfileActivity.onClick(view);
        Mockito.verify(baseAngaProfileActivity).openUpcomingService();
    }

    @Test
    public void onClickOpenFamlilyServicesDue() {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlFamilyServicesDue);
        Mockito.doNothing().when(baseAngaProfileActivity).openFamilyDueServices();
        baseAngaProfileActivity.onClick(view);
        Mockito.verify(baseAngaProfileActivity).openFamilyDueServices();
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusComplete() throws Exception {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseAngaProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseAngaProfileActivity).showProgressBar(false);
        baseAngaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseAngaProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseAngaProfileActivity).invoke("setFamilyStatus", "Family has nothing due");
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusNormal() throws Exception {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseAngaProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseAngaProfileActivity).showProgressBar(false);
        baseAngaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseAngaProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseAngaProfileActivity).invoke("setFamilyStatus", "Family has services due");
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        baseAngaProfileActivity = Mockito.spy(new BaseAngaProfileActivity());
        Whitebox.invokeMethod(baseAngaProfileActivity, "onActivityResult", 2244, -1, null);
        Mockito.verify(profilePresenter).saveForm(null);
    }

}
