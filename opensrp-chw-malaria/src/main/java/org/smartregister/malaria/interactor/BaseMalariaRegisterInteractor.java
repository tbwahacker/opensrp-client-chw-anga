package org.smartregister.malaria.interactor;

import org.apache.commons.lang3.tuple.Triple;
import org.smartregister.malaria.contract.MalariaRegisterContract;

public class BaseMalariaRegisterInteractor implements MalariaRegisterContract.Interactor {
    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }

    @Override
    public void getNextUniqueId(Triple<String, String, String> triple, MalariaRegisterContract.InteractorCallBack callBack) {

    }

    @Override
    public void saveRegistration(MalariaRegisterContract.InteractorCallBack callBack) {

    }

    @Override
    public void removeFamilyFromRegister(String closeFormJsonString, String providerId) {

    }
}
