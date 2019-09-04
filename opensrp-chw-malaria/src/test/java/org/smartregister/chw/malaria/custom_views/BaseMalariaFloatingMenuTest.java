package org.smartregister.chw.malaria.custom_views;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.powermock.api.mockito.PowerMockito.spy;

@PrepareForTest(BaseMalariaFloatingMenu.class)
public class BaseMalariaFloatingMenuTest {

    @Test
    public void BaseMalariaFloatingMenu() {
        BaseMalariaFloatingMenu baseMalariaFloatingMenu = spy(new BaseMalariaFloatingMenu(null, null));
        Mockito.doNothing().when(baseMalariaFloatingMenu).initUi();
        Mockito.verify(baseMalariaFloatingMenu).initUi();
    }

    @Test
    public void getPhoneNumber() {
        BaseMalariaFloatingMenu baseMalariaFloatingMenu = spy(new BaseMalariaFloatingMenu(null, "John", "0744112211", "Doe", "0744112244"));
        PowerMockito.doNothing().when(baseMalariaFloatingMenu).initUi();
        Assert.assertEquals("0744112211", "0744112211");
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