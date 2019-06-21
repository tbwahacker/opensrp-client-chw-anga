package org.smartregister.chw.malaria.presenter;

import android.content.Context;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;

import java.lang.ref.WeakReference;

public class BaseMalariaProfilePresenter implements MalariaProfileContract.Presenter, MalariaProfileContract.View {
    protected WeakReference<MalariaProfileContract.View> view;
    protected MemberObject memberObject;

    public BaseMalariaProfilePresenter(MalariaProfileContract.View contractView, MemberObject memberObject) {
        this.view = new WeakReference<>(contractView);
        this.memberObject = memberObject;

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public MalariaProfileContract.View getView() {
        if(view != null) {
            return  view.get();
        }
        return null;
    }

    @Override
    public MalariaProfileContract.Presenter presenter() {
        return null;
    }


    @Override
    public void onDestroy(boolean b) {
        //destroy
    }
}
