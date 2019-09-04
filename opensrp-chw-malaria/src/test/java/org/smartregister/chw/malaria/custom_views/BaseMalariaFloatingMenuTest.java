package org.smartregister.chw.malaria.custom_views;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest(BaseMalariaFloatingMenu.class)
public class BaseMalariaFloatingMenuTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void BaseMalariaFloatingMenu() {
        BaseMalariaFloatingMenu baseMalariaFloatingMenu = Mockito.spy(new BaseMalariaFloatingMenu(null, null));

        // do your actual tests here
        Mockito.verify(baseMalariaFloatingMenu).initUi();
    }

    @Test
    public void getPhoneNumber() {
        BaseMalariaFloatingMenu baseMalariaFloatingMenu = Mockito.spy(new BaseMalariaFloatingMenu(null, "John", "0744112211", "Doe", "0744112244"));

        Assert.assertEquals("0744112211", baseMalariaFloatingMenu.getPhoneNumber());
    }

    @Test
    public void getFamilyHeadName() {
    }

    @Test
    public void getFamilyHeadPhone() {
    }

    @Test
    public void getClientName() {
    }
}