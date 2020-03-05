package org.smartregister.chw.malaria.listener;


import android.view.View;

import org.smartregister.chw.malaria.fragment.BaseMalariaCallDialogFragment;
import org.smartregister.chw.malaria.util.MalariaUtil;
import org.smartregister.malaria.R;

import timber.log.Timber;

public class BaseMalariaCallWidgetDialogListener implements View.OnClickListener {

    private BaseMalariaCallDialogFragment callDialogFragment;

    public BaseMalariaCallWidgetDialogListener(BaseMalariaCallDialogFragment dialogFragment) {
        callDialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.malaria_call_close) {
            callDialogFragment.dismiss();
        } else if (i == R.id.malaria_call_head_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                MalariaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        } else if (i == R.id.call_malaria_client_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                MalariaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }
}
