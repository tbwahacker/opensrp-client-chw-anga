package org.smartregister.presenter;

import android.content.Context;
import android.widget.TextView;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
    private TextView androidView = Mockito.mock(TextView.class);
    private TextView androidView2 = Mockito.mock(TextView.class);

    @Mock
    private BaseMalariaProfilePresenter profilePresenter = Mockito.mock(BaseMalariaProfilePresenter.class);

    @Mock
    private MemberObject memberObject = Mockito.mock(MemberObject.class);

    @Mock
    private Context context = Mockito.mock(Context.class);

    @Test
    public void fillProfileDataDoesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(memberObject);
        verify(view, never()).setProfileViewWithData();
    }

    @Test
    public void malariaTestDatePeriodIsNotBetweenSevenAndTenAndNotGreaterThanTen() {
        profilePresenter.recordMalariaButton(7, androidView, androidView2,  context);
        verify(profilePresenter, never()).changeViewColor(androidView, context,
                R.color.due_profile_blue);
    }

}
