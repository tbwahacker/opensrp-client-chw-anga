package org.smartregister.activity;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.anga.activity.BaseAngaRegisterActivity;

public class BaseAngaRegisterActivityTest {
    @Mock
    public Intent data;
    @Mock
    private BaseAngaRegisterActivity baseAngaRegisterActivity = new BaseAngaRegisterActivity();

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAngaRegisterActivity);
    }

    @Test
    public void testFormConfig() {
        Assert.assertNull(baseAngaRegisterActivity.getFormConfig());
    }

    @Test
    public void checkIdentifier() {
        Assert.assertNotNull(baseAngaRegisterActivity.getViewIdentifiers());
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        Whitebox.invokeMethod(baseAngaRegisterActivity, "onActivityResult", 2244, -1, data);
        Mockito.verify(baseAngaRegisterActivity.presenter()).saveForm(null);
    }

}
