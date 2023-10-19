package org.smartregister.chw.anga.model;

import org.json.JSONObject;
import org.smartregister.chw.anga.contract.AngaRegisterContract;
import org.smartregister.chw.anga.util.AngaJsonFormUtils;

public class BaseAngaRegisterModel implements AngaRegisterContract.Model {

    @Override
    public JSONObject getFormAsJson(String formName, String entityId, String currentLocationId) throws Exception {
        JSONObject jsonObject = AngaJsonFormUtils.getFormAsJson(formName);
        AngaJsonFormUtils.getRegistrationForm(jsonObject, entityId, currentLocationId);

        return jsonObject;
    }

}
