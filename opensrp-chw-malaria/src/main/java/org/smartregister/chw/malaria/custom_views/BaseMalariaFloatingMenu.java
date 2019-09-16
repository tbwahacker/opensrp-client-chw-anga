package org.smartregister.chw.malaria.custom_views;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import org.smartregister.chw.malaria.fragment.BaseMalariaCallDialogFragment;
import org.smartregister.malaria.R;

public class BaseMalariaFloatingMenu extends LinearLayout implements View.OnClickListener {
    private String phoneNumber;
    private String familyHeadName;
    private String familyHeadPhone;
    private String clientName;

    public BaseMalariaFloatingMenu(Context context, String malariaClientName, String malariaClientPhone, String clientFamilyHeadName, String clientFamilyHeadPhone) {
        super(context);
        initUi();
        clientName = malariaClientName;
        phoneNumber = malariaClientPhone;
        familyHeadName = clientFamilyHeadName;
        familyHeadPhone = clientFamilyHeadPhone;
    }

    public BaseMalariaFloatingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public BaseMalariaFloatingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initUi();
    }

    protected void initUi() {
        inflate(getContext(), R.layout.view_malaria_call_floating_menu, this);
        FloatingActionButton fab = findViewById(R.id.malaria_fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.malaria_fab) {
            Activity activity = (Activity) getContext();
            BaseMalariaCallDialogFragment.launchDialog(activity, clientName, phoneNumber, familyHeadName, familyHeadPhone);
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFamilyHeadName() {
        return familyHeadName;
    }

    public String getFamilyHeadPhone() {
        return familyHeadPhone;
    }

    public String getClientName() {
        return clientName;
    }
}