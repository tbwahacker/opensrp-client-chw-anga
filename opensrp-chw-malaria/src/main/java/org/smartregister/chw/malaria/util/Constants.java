package org.smartregister.chw.malaria.util;

public interface Constants {

    int REQUEST_CODE_GET_JSON = 2244;
    String ENCOUNTER_TYPE = "encounter_type";
    String STEP_ONE = "step1";
    String STEP_TWO = "step2";

    interface JSON_FORM_EXTRA {
        String JSON = "json";
        String ENCOUNTER_TYPE = "encounter_type";
    }

    interface EVENT_TYPE {
        String MALARIA_CONFIRMATION = "Malaria Confirmation";
    }

    interface FORMS {
        String MALARIA_REGISTRATION = "malaria_registration";
    }

    interface TABLES {
        String MALARIA_CONFIRMATION = "ec_malaria_confirmation";
    }

    interface ACTIVITY_PAYLOAD {
        String BASE_ENTITY_ID = "BASE_ENTITY_ID";
        String ACTION = "ACTION";
    }

    interface ACTIVITY_PAYLOAD_TYPE {
        String REGISTRATION = "REGISTRATION";
    }

    interface CONFIGURATION {
        String MALARIA_CONFIRMATION = "malaria_confirmation";
    }

}
