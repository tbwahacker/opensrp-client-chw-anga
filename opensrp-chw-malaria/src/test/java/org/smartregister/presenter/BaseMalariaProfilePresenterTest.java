package org.smartregister.presenter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import org.robolectric.RuntimeEnvironment;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;
import org.smartregister.malaria.R;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseMalariaProfilePresenterTest {
    @Mock
    private MalariaProfileContract.View view = Mockito.mock(MalariaProfileContract.View.class);
    @Mock
    private View androidView = Mockito.mock(View.class);
    @Mock
    BaseMalariaProfilePresenter profilePresenter = Mockito.mock(BaseMalariaProfilePresenter.class);

    @Mock
    MemberObject memberObject = Mockito.mock(MemberObject.class);

    @Mock
    private Context context = Mockito.mock(Context.class);

    @Test
    public void fillProfileData_doesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(memberObject);
        verify(view, never()).setProfileViewWithData();
    }

    @Test
    public void malariaTestDatePeriodIsBetweenSevenAndTenSevenInclusive_recordMalariaButtonHasDueColor() {
        profilePresenter.recordMalariaButton(7, androidView, context);
        Drawable recordMalariaButton = Mockito.spy(new TextView(RuntimeEnvironment.application)).getBackground();
        ColorDrawable recordMalariaButtonColor = (ColorDrawable) recordMalariaButton;
        assertEquals(R.color.due_profile_blue, recordMalariaButtonColor.getColor());
    }

    @Test
    public void malariaTestDatePeriodIsTenOrGreater_recordMalariaButtonHasOverDueColor() {
        profilePresenter.recordMalariaButton(10, androidView, context);
        Drawable recordMalariaButton = Mockito.spy(new TextView(RuntimeEnvironment.application)).getBackground();
        ColorDrawable recordMalariaButtonColor = (ColorDrawable) recordMalariaButton;
        assertEquals(R.color.visit_status_over_due, recordMalariaButtonColor.getColor());
    }
}
