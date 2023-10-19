package org.smartregister.chw.anga.listener;


import android.view.View;

import org.smartregister.chw.anga.fragment.BaseAngaCallDialogFragment;
import org.smartregister.chw.anga.util.AngaUtil;
import org.smartregister.anga.R;

import timber.log.Timber;

public class BaseAngaCallWidgetDialogListener implements View.OnClickListener {

    private BaseAngaCallDialogFragment callDialogFragment;

    public BaseAngaCallWidgetDialogListener(BaseAngaCallDialogFragment dialogFragment) {
        callDialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.anga_call_close) {
            callDialogFragment.dismiss();
        } else if (i == R.id.anga_call_head_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                AngaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        } else if (i == R.id.call_anga_client_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                AngaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }
}
