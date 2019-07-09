package org.smartregister.chw.malaria.contract;

public interface MalariaProfileContract {
    interface View {
        void setProfileViewWithData();

        void hideView();

        void setDueColor();

        void setOverDueColor();
    }
}