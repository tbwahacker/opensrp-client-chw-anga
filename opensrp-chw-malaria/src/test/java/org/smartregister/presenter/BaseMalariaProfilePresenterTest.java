package org.smartregister.presenter;

import android.content.Context;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.malaria.R;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseMalariaProfilePresenterTest {
    @Mock
    private TextView androidView = Mockito.mock(TextView.class);

    @Mock
    private CommonPersonObjectClient commonPersonObjectClient = Mockito.mock(CommonPersonObjectClient.class);

    @Mock
    private MalariaProfileContract.View view = Mockito.mock(MalariaProfileContract.View.class);

    @Mock
    private Context context = Mockito.mock(Context.class);

    @Mock
    private MemberObject memberObject = new MemberObject(commonPersonObjectClient);

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
        BaseMalariaProfilePresenter  baseMalariaProfilePresenter =
                Mockito.mock(BaseMalariaProfilePresenter.class);
        profilePresenter.recordMalariaButton(4, androidView, context);
        verify(baseMalariaProfilePresenter, never()).changeViewColor(androidView, context,
                R.color.due_profile_blue);
    }
}
