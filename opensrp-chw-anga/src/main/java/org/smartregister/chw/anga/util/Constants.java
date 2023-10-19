package org.smartregister.chw.anga.util;

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
        String ANGA_CONFIRMATION = "Anga Confirmation";
        String ANGA_FOLLOW_UP_VISIT = "Anga Follow-up Visit";
    }

    interface FORMS {
        String ANGA_REGISTRATION = "anga_confirmation";
        String ANGA_FOLLOW_UP_VISIT = "anga_followup_visit";
    }

    interface TABLES {
        String ANGA_CONFIRMATION = "ec_anga_confirmation";
        String ANGA_FOLLOW_UP = "ec_anga_follow_up_visit";
    }

    interface ACTIVITY_PAYLOAD {
        String BASE_ENTITY_ID = "BASE_ENTITY_ID";
        String FAMILY_BASE_ENTITY_ID = "FAMILY_BASE_ENTITY_ID";
        String ACTION = "ACTION";
        String ANGA_FORM_NAME = "ANGA_FORM_NAME";

    }

    interface ACTIVITY_PAYLOAD_TYPE {
        String REGISTRATION = "REGISTRATION";
        String FOLLOW_UP_VISIT = "FOLLOW_UP_VISIT";
    }

    interface CONFIGURATION {
        String ANGA_CONFIRMATION = "anga_confirmation";
    }

    interface ANGA_MEMBER_OBJECT {
        String MEMBER_OBJECT = "memberObject";
    }

}