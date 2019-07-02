package org.smartregister.presenter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseMalariaProfilePresenterTest {
    @Mock
    MalariaProfileContract.View view = Mockito.mock(MalariaProfileContract.View.class);

    @Mock
    BaseMalariaProfilePresenter profilePresenter = Mockito.mock(BaseMalariaProfilePresenter.class);

    @Mock
    MemberObject memberObject = Mockito.mock(MemberObject.class);

    @Test
    public void fillProfileDataDoesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(memberObject);
        verify(view, never()).setProfileViewWithData();
    }
}
