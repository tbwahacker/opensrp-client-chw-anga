package org.smartregister.presenter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.anga.contract.AngaProfileContract;
import org.smartregister.chw.anga.domain.MemberObject;
import org.smartregister.chw.anga.presenter.BaseAngaProfilePresenter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseAngaProfilePresenterTest {

    @Mock
    private AngaProfileContract.View view = Mockito.mock(AngaProfileContract.View.class);

    @Mock
    private AngaProfileContract.Interactor interactor = Mockito.mock(AngaProfileContract.Interactor.class);

    @Mock
    private MemberObject memberObject = new MemberObject();

    private BaseAngaProfilePresenter profilePresenter = new BaseAngaProfilePresenter(view, interactor, memberObject);


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
    public void angaTestDatePeriodIsLessThanSeven() {
        profilePresenter.recordAngaButton("");
        verify(view).hideView();
    }

    @Test
    public void angaTestDatePeriodGreaterThanTen() {
        profilePresenter.recordAngaButton("OVERDUE");
        verify(view).setOverDueColor();
    }

    @Test
    public void angaTestDatePeriodIsMoreThanFourteen() {
        profilePresenter.recordAngaButton("EXPIRED");
        verify(view).hideView();
    }

    @Test
    public void refreshProfileBottom() {
        profilePresenter.refreshProfileBottom();
        verify(interactor).refreshProfileInfo(memberObject, profilePresenter.getView());
    }

    @Test
    public void saveForm() {
        profilePresenter.saveForm(null);
        verify(interactor).saveRegistration(null, view);
    }
}
