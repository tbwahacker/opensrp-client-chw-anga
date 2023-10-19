package org.smartregister.chw.anga.presenter;

import android.content.Context;
import android.support.annotation.Nullable;

import org.smartregister.chw.anga.contract.AngaProfileContract;
import org.smartregister.chw.anga.domain.MemberObject;

import java.lang.ref.WeakReference;

import timber.log.Timber;


public class BaseAngaProfilePresenter implements AngaProfileContract.Presenter {
    protected WeakReference<AngaProfileContract.View> view;
    protected MemberObject memberObject;
    protected AngaProfileContract.Interactor interactor;
    protected Context context;

    public BaseAngaProfilePresenter(AngaProfileContract.View view, AngaProfileContract.Interactor interactor, MemberObject memberObject) {
        this.view = new WeakReference<>(view);
        this.memberObject = memberObject;
        this.interactor = interactor;
    }

    @Override
    public void fillProfileData(MemberObject memberObject) {
        if (memberObject != null && getView() != null) {
            getView().setProfileViewWithData();
        }
    }

    @Override
    public void recordAngaButton(@Nullable String visitState) {
        if (getView() == null) {
            return;
        }

        if (("OVERDUE").equals(visitState) || ("DUE").equals(visitState)) {
            if (("OVERDUE").equals(visitState)) {
                getView().setOverDueColor();
            }
        } else {
            getView().hideView();
        }
    }

    @Override
    @Nullable
    public AngaProfileContract.View getView() {
        if (view != null && view.get() != null)
            return view.get();

        return null;
    }

    @Override
    public void refreshProfileBottom() {
        interactor.refreshProfileInfo(memberObject, getView());
    }

    @Override
    public void saveForm(String jsonString) {
        try {
            interactor.saveRegistration(jsonString, getView());
        } catch (Exception e) {
            Timber.e(e);
        }
    }
}
