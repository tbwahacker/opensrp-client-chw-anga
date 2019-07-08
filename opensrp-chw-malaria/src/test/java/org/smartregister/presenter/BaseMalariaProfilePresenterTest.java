package org.smartregister.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.malaria.R;

import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BaseMalariaProfilePresenterTest {
    @Mock
    TextView androidView;

    @Mock
    TextView androidView2;

    @Mock
    CommonPersonObjectClient commonPersonObjectClient = Mockito.mock(CommonPersonObjectClient.class);

    @Mock
    MalariaProfileContract.View view = Mockito.mock(MalariaProfileContract.View.class);

    @Mock
    Context context = Mockito.mock(Context.class);

    @Mock
    MemberObject memberObject = new MemberObject(commonPersonObjectClient);

    private BaseMalariaProfilePresenter profilePresenter = new BaseMalariaProfilePresenter(view,
            memberObject);

    @Test
    public void testAttachView() {
        profilePresenter.attachView(view);
        Assert.assertNotNull(this.view);
    }

    @Test
    public void fillProfileDataCallsSetProfileViewWithDataWhenPassedMemberObject() {
        profilePresenter.fillProfileData(memberObject);
        verify(view).setProfileViewWithData();
    }

    @Test
    public void fillProfileDataDoesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(null);
        verify(view, never()).setProfileViewWithData();
    }

    @Test
    public void malariaTestDatePeriodIsNotBetweenSevenAndTenAndNotGreaterThanTen() {
        profilePresenter.recordMalariaButton(4, androidView, androidView2,  context);
        verify(profilePresenter, never()).changeViewColor(androidView, context,
                R.color.due_profile_blue);
    }
}
