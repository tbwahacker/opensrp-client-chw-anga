package org.smartregister.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import org.smartregister.chw.anga.activity.BaseAngaProfileActivity;
import org.smartregister.chw.anga.util.Constants;



public class AngaMemberProfileActivity extends BaseAngaProfileActivity {
    public static void startMe(Activity activity, String baseEntityID) {
        Intent intent = new Intent(activity, AngaMemberProfileActivity.class);
        intent.putExtra(Constants.ACTIVITY_PAYLOAD.BASE_ENTITY_ID, baseEntityID);
        activity.startActivity(intent);
    }
}