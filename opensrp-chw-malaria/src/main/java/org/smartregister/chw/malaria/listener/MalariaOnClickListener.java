package org.smartregister.chw.malaria.listener;

import android.content.Intent;
import android.view.View;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import org.smartregister.malaria.R;

public class MalariaOnClickListener implements View.OnClickListener {
    protected CommonPersonObjectClient client;

    public MalariaOnClickListener(CommonPersonObjectClient client) {
        this.client = client;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.due_button) {
            Intent intent = new Intent();
            intent.putExtra("client", client);
            BaseMalariaProfileActivity.startProfileActivity(intent);
        }

    }
}
