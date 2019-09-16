package org.smartregister.chw.malaria.contract;

import android.content.Context;

public interface BaseMalariaCallDialogContract {

    interface View {
        Dialer getPendingCallRequest();

        void setPendingCallRequest(Dialer dialer);

        Context getCurrentContext();
    }

    interface Model {
        String getName();

        void setName(String name);
    }

    interface Dialer {
        void callMe();
    }

}
