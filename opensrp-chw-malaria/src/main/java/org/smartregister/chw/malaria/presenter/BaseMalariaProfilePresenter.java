package org.smartregister.chw.malaria.presenter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import org.smartregister.chw.malaria.contract.MalariaProfileContract;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.malaria.R;


public class BaseMalariaProfilePresenter {
    protected MalariaProfileContract.View view;
    protected MemberObject memberObject;
    protected Context context;


    public BaseMalariaProfilePresenter(MalariaProfileContract.View view, MemberObject memberObject) {
        this.view = view;
        this.memberObject = memberObject;

    }

    public void attachView(MalariaProfileContract.View view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public void fillProfileData(MemberObject memberObject) {
        if (memberObject != null) {
            view.setProfileViewWithData();
        }
    }

    public void recordMalariaButton(int days_from_malaria_test_date, View view, Context context) {
        if(days_from_malaria_test_date >= 7 && days_from_malaria_test_date < 10)  {
            changeViewColor(view, context, R.color.due_profile_blue);
        } else if (days_from_malaria_test_date >= 10){
            changeViewColor(view, context, R.color.visit_status_over_due);
        }
    }


    public void recordMalariaFollowUp(Context context) {
        //call the form from this function
        Toast.makeText(context, "Record Malaria", Toast.LENGTH_SHORT).show();
    }

    public void changeViewColor(View view, Context context, int color) {
        view.setBackgroundColor(ContextCompat.getColor(context,
                color));

    }

}
