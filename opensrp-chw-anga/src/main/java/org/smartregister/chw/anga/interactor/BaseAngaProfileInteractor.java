package org.smartregister.chw.anga.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.anga.contract.AngaProfileContract;
import org.smartregister.chw.anga.domain.MemberObject;
import org.smartregister.chw.anga.util.AppExecutors;
import org.smartregister.chw.anga.util.AngaUtil;
import org.smartregister.domain.AlertStatus;

import java.util.Date;

public class BaseAngaProfileInteractor implements AngaProfileContract.Interactor {
    protected AppExecutors appExecutors;

    @VisibleForTesting
    BaseAngaProfileInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseAngaProfileInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void refreshProfileInfo(MemberObject memberObject, AngaProfileContract.InteractorCallBack callback) {
        Runnable runnable = () -> appExecutors.mainThread().execute(() -> {
            callback.refreshFamilyStatus(AlertStatus.normal);
            callback.refreshMedicalHistory(true);
            callback.refreshUpComingServicesStatus("Anga Visit", AlertStatus.normal, new Date());
        });
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveRegistration(final String jsonString, final AngaProfileContract.InteractorCallBack callback) {

        Runnable runnable = () -> {
            try {
                AngaUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        appExecutors.diskIO().execute(runnable);
    }
}
