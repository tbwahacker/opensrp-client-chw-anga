package org.smartregister.chw.malaria.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.v4.app.Fragment;

import com.vijay.jsonwizard.constants.JsonFormConstants;
import com.vijay.jsonwizard.domain.Form;

import org.json.JSONException;
import org.json.JSONObject;
import org.smartregister.AllConstants;
import org.smartregister.Context;
import org.smartregister.chw.malaria.contract.MalariaRegisterContract;
import org.smartregister.chw.malaria.fragment.BaseMalariaRegisterFragment;
import org.smartregister.chw.malaria.interactor.BaseMalariaRegisterInteractor;
import org.smartregister.chw.malaria.listener.MalariaBottomNavigationListener;
import org.smartregister.chw.malaria.model.BaseMalariaRegisterModel;
import org.smartregister.chw.malaria.presenter.BaseMalariaRegisterPresenter;
import org.smartregister.chw.malaria.util.Constants;
import org.smartregister.helper.BottomNavigationHelper;
import org.smartregister.listener.BottomNavigationListener;
import org.smartregister.malaria.R;
import org.smartregister.view.activity.BaseRegisterActivity;
import org.smartregister.view.fragment.BaseRegisterFragment;

import java.util.Arrays;
import java.util.List;

import timber.log.Timber;

public class BaseMalariaRegisterActivity extends BaseRegisterActivity implements MalariaRegisterContract.View {
    public static final String TAG = BaseMalariaRegisterActivity.class.getCanonicalName();

    protected String BASE_ENTITY_ID;
    protected String ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BASE_ENTITY_ID = getIntent().getStringExtra(Constants.ACTIVITY_PAYLOAD.BASE_ENTITY_ID);
        ACTION = getIntent().getStringExtra(Constants.ACTIVITY_PAYLOAD.ACTION);
        onStartActivityWithAction();
    }

    /**
     * Process a payload when an activity is started with an action
     */
    protected void onStartActivityWithAction() {
        if (ACTION != null && ACTION.equals(Constants.ACTIVITY_PAYLOAD_TYPE.REGISTRATION)) {
            startFormActivity(getRegistrationForm(), BASE_ENTITY_ID, null);
        }
    }

    @Override
    public void startRegistration() {
        startFormActivity(getRegistrationForm(), null, null);
    }

    public String getRegistrationForm() {
        return Constants.FORMS.MALARIA_REGISTRATION;
    }

    @Override
    public void startFormActivity(String formName, String entityId, String metaData) {
        try {
            if (mBaseFragment instanceof BaseMalariaRegisterFragment) {
                presenter().startForm(formName, entityId, metaData, getLocationID());
            }
        } catch (Exception e) {
            Timber.e(e);
            displayToast(getString(R.string.error_unable_to_start_form));
        }
    }

    protected String getLocationID() {
        return Context.getInstance().allSharedPreferences().getPreference(AllConstants.CURRENT_LOCATION_ID);
    }

    @Override
    public void startFormActivity(JSONObject jsonForm) {
        Intent intent = new Intent(this, getFamilyFormActivity());
        intent.putExtra(Constants.JSON_FORM_EXTRA.JSON, jsonForm.toString());

        if (getFormConfig() != null) {
            intent.putExtra(JsonFormConstants.JSON_FORM_KEY.FORM, getFormConfig());
        }

        startActivityForResult(intent, Constants.REQUEST_CODE_GET_JSON);
    }

    @Override
    public Form getFormConfig() {
        return null;
    }

    public Class getFamilyFormActivity() {
        return BaseMalariaRegisterActivity.class;
    }

    public String getFormRegistrationEvent() {
        return Constants.EVENT_TYPE.MALARIA_CONFIRMATION;
    }

    public String getFormEditRegistrationEvent() {
        return Constants.EVENT_TYPE.MALARIA_CONFIRMATION;
    }

    @Override
    protected void onActivityResultExtended(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            try {
                String jsonString = data.getStringExtra(Constants.JSON_FORM_EXTRA.JSON);
                JSONObject form = new JSONObject(jsonString);
                if (form.getString(Constants.ENCOUNTER_TYPE).equals(getRegisterEventType())) {
                    presenter().saveForm(jsonString, false);
                }
            } catch (JSONException e) {
                Timber.e(e);
            }
        }
    }

    @Override
    public List<String> getViewIdentifiers() {
        return Arrays.asList(Constants.CONFIGURATION.MALARIA_CONFIRMATION);
    }

    public String getRegisterEventType() {
        return Constants.EVENT_TYPE.MALARIA_CONFIRMATION;
    }

    /**
     * Override this to subscribe to bottom navigation
     */
    @Override
    protected void registerBottomNavigation() {
        bottomNavigationHelper = new BottomNavigationHelper();
        bottomNavigationView = findViewById(org.smartregister.R.id.bottom_navigation);

        if (bottomNavigationView != null) {
            bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
            bottomNavigationView.getMenu().removeItem(org.smartregister.R.id.action_clients);
            bottomNavigationView.getMenu().removeItem(R.id.action_register);
            bottomNavigationView.getMenu().removeItem(org.smartregister.R.id.action_search);
            bottomNavigationView.getMenu().removeItem(org.smartregister.R.id.action_library);

            bottomNavigationView.inflateMenu(getMenuResource());
            bottomNavigationHelper.disableShiftMode(bottomNavigationView);

            BottomNavigationListener familyBottomNavigationListener = getBottomNavigation(this);
            bottomNavigationView.setOnNavigationItemSelectedListener(familyBottomNavigationListener);

        }
    }

    @MenuRes
    public int getMenuResource() {
        return R.menu.bottom_nav_family_menu;
    }

    public BottomNavigationListener getBottomNavigation(Activity activity) {
        return new MalariaBottomNavigationListener(activity);
    }

    @Override
    protected void initializePresenter() {
        presenter = new BaseMalariaRegisterPresenter(this, new BaseMalariaRegisterModel(), new BaseMalariaRegisterInteractor());
    }

    @Override
    protected BaseRegisterFragment getRegisterFragment() {
        return new BaseMalariaRegisterFragment();
    }

    @Override
    protected Fragment[] getOtherFragments() {
        return new Fragment[0];
    }

    @Override
    public MalariaRegisterContract.Presenter presenter() {
        return (MalariaRegisterContract.Presenter) presenter;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == Constants.REQUEST_CODE_GET_JSON) {

            try {
                String jsonString = data.getStringExtra(Constants.JSON_FORM_EXTRA.JSON);

                JSONObject form = new JSONObject(jsonString);
                String encounter_type = form.getString(Constants.JSON_FORM_EXTRA.ENCOUNTER_TYPE);
//                process malaria form
                if (encounter_type.equalsIgnoreCase(getFormRegistrationEvent())) {
                    presenter().saveForm(form.toString(), false);
                } else if (encounter_type.equalsIgnoreCase(getFormEditRegistrationEvent())) {
                    presenter().saveForm(form.toString(), true);
                }
            } catch (JSONException e) {
                Timber.e(e);
                displayToast(getString(R.string.error_unable_to_save_form));
            }
        }
    }
}
