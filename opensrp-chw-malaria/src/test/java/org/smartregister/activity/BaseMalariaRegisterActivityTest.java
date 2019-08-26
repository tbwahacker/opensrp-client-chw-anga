package org.smartregister.activity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.smartregister.chw.malaria.activity.BaseMalariaRegisterActivity;
import org.smartregister.chw.malaria.util.Constants;

public class BaseMalariaRegisterActivityTest {
    @Mock
    private BaseMalariaRegisterActivity baseMalariaRegisterActivity = new BaseMalariaRegisterActivity();

    @Test
    public void testGetLocationID() {
        Assert.assertEquals(BaseMalariaRegisterActivity.class,
                baseMalariaRegisterActivity.getFamilyFormActivity());
    }

    @Test
    public void testGetFormRegistrationEvent() {
        Assert.assertEquals(Constants.EVENT_TYPE.MALARIA_CONFIRMATION,
                baseMalariaRegisterActivity.getFormRegistrationEvent());
    }

}
