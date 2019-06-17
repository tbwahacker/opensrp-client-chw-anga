package org.smartregister.chw.malaria.contract;

import android.content.Context;
import android.content.Intent;
import org.smartregister.commonregistry.CommonPersonObject;

public interface MalariaProfileContract {
    interface View {
        Context getContext();
        MalariaProfileContract.View getView();
        void getProfileData(CommonPersonObject client);

    }

    interface Presenter {
        MalariaProfileContract.Presenter presenter();

        void startProfileActivity(Intent intent);

        void fetchProfileData(Intent intent);
    }
}