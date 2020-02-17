package org.smartregister.activity;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.activity.BaseMalariaRegisterActivity;

public class BaseMalariaRegisterActivityTest {
    @Mock
    private BaseMalariaRegisterActivity baseMalariaRegisterActivity = new BaseMalariaRegisterActivity();

    @Mock
    public Intent data;

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaRegisterActivity);
    }

    @Test
    public void testFormConfig() {
        Assert.assertNull(baseMalariaRegisterActivity.getFormConfig());
    }

    @Test
    public void checkIdentifier() {
        Assert.assertNotNull(baseMalariaRegisterActivity.getViewIdentifiers());
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        Whitebox.invokeMethod(baseMalariaRegisterActivity, "onActivityResult", 2244, -1, data);
        Mockito.verify(baseMalariaRegisterActivity.presenter()).saveForm(null);
    }

}
