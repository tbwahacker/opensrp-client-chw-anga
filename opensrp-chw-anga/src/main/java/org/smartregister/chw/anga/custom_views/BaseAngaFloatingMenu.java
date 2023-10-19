package org.smartregister.chw.anga.custom_views;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;

import org.smartregister.chw.anga.domain.MemberObject;
import org.smartregister.chw.anga.fragment.BaseAngaCallDialogFragment;
import org.smartregister.anga.R;

public class BaseAngaFloatingMenu extends LinearLayout implements View.OnClickListener {
    private MemberObject MEMBER_OBJECT;

    public BaseAngaFloatingMenu(Context context, MemberObject MEMBER_OBJECT) {
        super(context);
        initUi();
        this.MEMBER_OBJECT = MEMBER_OBJECT;
    }

    protected void initUi() {
        inflate(getContext(), R.layout.view_anga_floating_menu, this);
        FloatingActionButton fab = findViewById(R.id.anga_fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.anga_fab) {
            Activity activity = (Activity) getContext();
            BaseAngaCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }  else if (view.getId() == R.id.refer_to_facility_layout) {
            Activity activity = (Activity) getContext();
            BaseAngaCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }
    }
}