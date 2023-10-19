package org.smartregister.chw.anga.contract;

import android.content.Context;

public interface BaseAngaCallDialogContract {

    interface View {
        void setPendingCallRequest(Dialer dialer);
        Context getCurrentContext();
    }

    interface Dialer {
        void callMe();
    }
}
