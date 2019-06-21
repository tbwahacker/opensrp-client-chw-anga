package org.smartregister.chw.malaria.contract;

import android.content.Context;
import org.smartregister.view.contract.BaseProfileContract;

public interface MalariaProfileContract {
    interface View {
        Context getContext();

        MalariaProfileContract.View getView();

        MalariaProfileContract.Presenter presenter();

    }

    interface Presenter extends BaseProfileContract.Presenter {
    }
}