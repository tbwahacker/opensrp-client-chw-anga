package org.smartregister.chw.malaria.presenter;

import android.content.Context;

import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;


public class BaseMalariaProfilePresenter {
    protected MalariaProfileContract.View view;
    private MemberObject memberObject;
    protected Context context;


    public BaseMalariaProfilePresenter(MalariaProfileContract.View view, MemberObject memberObject) {
        this.view = view;
        this.memberObject = memberObject;

    }

    public void attachView(MalariaProfileContract.View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public void fillProfileData(MemberObject memberObject) {
        if (memberObject != null) {
            view.setProfileViewWithData();
        }
    }
}
