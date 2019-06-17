package org.smartregister.chw.malaria.presenter;

import android.content.Intent;
import org.smartregister.chw.malaria.contract.MalariaProfileContract;

public class MalariaProfilePresenter implements MalariaProfileContract.Presenter {
    @Override
    public MalariaProfileContract.Presenter presenter() {
        return presenter();
    }

    @Override
    public void startProfileActivity(Intent intent) {
        // get the activity and initiate the profile activity
    }

    @Override
    public void fetchProfileData(Intent intent) {
        //fetch profile data from the intent
    }
}
