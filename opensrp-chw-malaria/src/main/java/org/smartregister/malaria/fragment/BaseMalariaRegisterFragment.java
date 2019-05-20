package org.smartregister.malaria.fragment;

import org.smartregister.configurableviews.model.View;
import org.smartregister.malaria.contract.MalariaRegisterFragmentContract;
import org.smartregister.view.fragment.BaseRegisterFragment;

import java.util.HashMap;
import java.util.Set;

public class BaseMalariaRegisterFragment extends BaseRegisterFragment implements MalariaRegisterFragmentContract.View {
    @Override
    public void initializeAdapter(Set<View> visibleColumns) {

    }

    @Override
    public MalariaRegisterFragmentContract.Presenter presenter() {
        return null;
    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    public void setUniqueID(String s) {

    }

    @Override
    public void setAdvancedSearchFormData(HashMap<String, String> hashMap) {

    }

    @Override
    protected String getMainCondition() {
        return null;
    }

    @Override
    protected String getDefaultSortQuery() {
        return null;
    }

    @Override
    protected void startRegistration() {

    }

    @Override
    protected void onViewClicked(android.view.View view) {

    }

    @Override
    public void showNotFoundPopup(String s) {

    }
}
