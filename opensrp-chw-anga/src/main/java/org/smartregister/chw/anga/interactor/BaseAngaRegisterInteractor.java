package org.smartregister.chw.anga.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.anga.contract.AngaRegisterContract;
import org.smartregister.chw.anga.util.AppExecutors;
import org.smartregister.chw.anga.util.AngaUtil;

public class BaseAngaRegisterInteractor implements AngaRegisterContract.Interactor {

    private AppExecutors appExecutors;

    @VisibleForTesting
    BaseAngaRegisterInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseAngaRegisterInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void saveRegistration(final String jsonString, final AngaRegisterContract.InteractorCallBack callBack) {

        Runnable runnable = () -> {
            try {
                AngaUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            appExecutors.mainThread().execute(() -> callBack.onRegistrationSaved());
        };
        appExecutors.diskIO().execute(runnable);
    }
}
