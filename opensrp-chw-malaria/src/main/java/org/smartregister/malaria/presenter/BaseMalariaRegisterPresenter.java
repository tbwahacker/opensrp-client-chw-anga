package org.smartregister.malaria.presenter;

import org.apache.commons.lang3.tuple.Triple;
import org.smartregister.malaria.contract.MalariaRegisterContract;
import org.smartregister.malaria.interactor.BaseMalariaRegisterInteractor;

import java.lang.ref.WeakReference;
import java.util.List;

public class BaseMalariaRegisterPresenter implements MalariaRegisterContract.Presenter, MalariaRegisterContract.InteractorCallBack  {

    public static final String TAG = BaseMalariaRegisterPresenter.class.getName();

    protected WeakReference<MalariaRegisterContract.View> viewReference;
    protected MalariaRegisterContract.Interactor interactor;
    protected MalariaRegisterContract.Model model;

    public BaseMalariaRegisterPresenter(MalariaRegisterContract.View view, MalariaRegisterContract.Model model) {
        viewReference = new WeakReference<>(view);
        interactor = new BaseMalariaRegisterInteractor();
        this.model = model;
    }

    @Override
    public void saveLanguage(String language) {

    }

    @Override
    public void startForm(String formName, String entityId, String metadata, String currentLocationId) throws Exception {

    }

    @Override
    public void saveForm(String jsonString, boolean isEditMode) {

    }

    @Override
    public void closeFamilyRecord(String jsonString) {

    }

    @Override
    public void onUniqueIdFetched(Triple<String, String, String> triple, String entityId) {

    }

    @Override
    public void onNoUniqueId() {

    }

    @Override
    public void onRegistrationSaved(boolean isEdit) {

    }

    @Override
    public void registerViewConfigurations(List<String> list) {

    }

    @Override
    public void unregisterViewConfiguration(List<String> list) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public void updateInitials() {

    }
}
