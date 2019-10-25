package org.smartregister.chw.malaria.contract;

import com.vijay.jsonwizard.domain.Form;

import org.json.JSONObject;
import org.smartregister.view.contract.BaseRegisterContract;

import java.util.List;

public interface MalariaRegisterContract {

    interface View extends BaseRegisterContract.View {
        Presenter presenter();

        Form getFormConfig();
    }

    interface Presenter extends BaseRegisterContract.Presenter {

        void saveLanguage(String language);

        void startForm(String formName, String entityId, String metadata, String currentLocationId) throws Exception;

        void saveForm(String jsonString);

        void closeFamilyRecord(String jsonString);

    }

    interface Model {

        void registerViewConfigurations(List<String> viewIdentifiers);

        void unregisterViewConfiguration(List<String> viewIdentifiers);

        void saveLanguage(String language);

        String getLocationId(String locationName);

        JSONObject getFormAsJson(String formName, String entityId,
                                 String currentLocationId) throws Exception;

        String getInitials();

    }

    interface Interactor {

        void saveRegistration(String jsonString, final InteractorCallBack callBack);

    }

    interface InteractorCallBack {

        void onRegistrationSaved();

    }
}
