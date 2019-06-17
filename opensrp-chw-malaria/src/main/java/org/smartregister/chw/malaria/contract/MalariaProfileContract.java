package org.smartregister.chw.malaria.contract;

import android.content.Context;
import android.content.Intent;
import org.smartregister.commonregistry.CommonPersonObjectClient;

public interface MalariaProfileContract {
    interface View {
        Context getContext();
        MalariaProfileContract.View getView();
        void getProfileData(CommonPersonObjectClient client);

    }

    interface Presenter {
        MalariaProfileContract.Presenter presenter();

        void startProfileActivity(Intent intent);

        void fetchProfileData(Intent intent);
    }
}