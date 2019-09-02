package org.smartregister.chw.malaria.fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.smartregister.chw.malaria.contract.BaseMalariaCallDialogContract;
import org.smartregister.chw.malaria.listener.BaseMalariaCallWidgetDialogListener;
import org.smartregister.malaria.R;

import static android.view.View.GONE;
import static org.smartregister.util.Utils.getName;

public class BaseMalariaCallDialogFragment extends DialogFragment implements BaseMalariaCallDialogContract.View {

    public static final String DIALOG_TAG = "BaseMalariaCallDialogFragment_DIALOG_TAG";
    private static String malariaClientName;
    private static String malariaClientPhoneNumber;
    private static String malariaFamilyHeadName;
    private static String malariaFamilyHeadPhone;
    private View.OnClickListener listener = null;

    public static BaseMalariaCallDialogFragment launchDialog(Activity activity, String clientName, String malariaClientPhone, String familyHeadName, String familyHeadPhone) {
        BaseMalariaCallDialogFragment dialogFragment = BaseMalariaCallDialogFragment.newInstance();
        FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
        Fragment prev = activity.getFragmentManager().findFragmentByTag(DIALOG_TAG);
        malariaClientPhoneNumber = malariaClientPhone;
        malariaClientName = clientName;
        malariaFamilyHeadName = familyHeadName;
        malariaFamilyHeadPhone = familyHeadPhone;
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        dialogFragment.show(ft, DIALOG_TAG);

        return dialogFragment;
    }

    public static BaseMalariaCallDialogFragment newInstance() {
        return new BaseMalariaCallDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.ChwTheme_Dialog_FullWidth);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup dialogView = (ViewGroup) inflater.inflate(R.layout.malaria_member_call_widget_dialog_fragment, container, false);
        setUpPosition();
        if (listener == null) {
            listener = new BaseMalariaCallWidgetDialogListener(this);
        }

        initUI(dialogView);
        return dialogView;
    }

    private void initUI(ViewGroup rootView) {

        if (StringUtils.isNotBlank(malariaClientPhoneNumber)) {
            TextView malariaClientNameTextView = rootView.findViewById(R.id.call_malaria_client_name);
            malariaClientNameTextView.setText(malariaClientName);

            TextView callMalariaClientPhone = rootView.findViewById(R.id.call_malaria_client_phone);
            callMalariaClientPhone.setTag(malariaClientPhoneNumber);
            callMalariaClientPhone.setText(getName(getCurrentContext().getString(R.string.call), malariaClientPhoneNumber));
            callMalariaClientPhone.setOnClickListener(listener);
        } else {

            rootView.findViewById(R.id.layout_malaria_client).setVisibility(GONE);
        }

        if (StringUtils.isNotBlank(malariaFamilyHeadPhone)) {
            TextView familyHeadName = rootView.findViewById(R.id.malaria_call_head_name);
            familyHeadName.setText(malariaFamilyHeadName);

            TextView clientCallHeadPhone = rootView.findViewById(R.id.malaria_call_head_phone);
            clientCallHeadPhone.setTag(malariaFamilyHeadPhone);
            clientCallHeadPhone.setText(getName(getCurrentContext().getString(R.string.call), malariaFamilyHeadPhone));
            clientCallHeadPhone.setOnClickListener(listener);

        } else {

            rootView.findViewById(R.id.malaria_layout_family_head).setVisibility(GONE);
        }

        rootView.findViewById(R.id.malaria_call_close).setOnClickListener(listener);

    }

    private void setUpPosition() {
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        WindowManager.LayoutParams p = getDialog().getWindow().getAttributes();
        p.width = ViewGroup.LayoutParams.MATCH_PARENT;
        p.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
        p.y = 20;
        getDialog().getWindow().setAttributes(p);
    }

    @Override
    public Context getCurrentContext() {
        return getActivity();
    }

    @Override
    public BaseMalariaCallDialogContract.Dialer getPendingCallRequest() {
        return null;
    }

    @Override
    public void setPendingCallRequest(BaseMalariaCallDialogContract.Dialer dialer) {
//        Implement pending call request
//        BaseAncWomanCallDialogContract.Dialer mDialer = dialer;
    }
}
