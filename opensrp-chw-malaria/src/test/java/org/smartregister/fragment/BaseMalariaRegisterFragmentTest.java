package org.smartregister.fragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.chw.malaria.fragment.BaseMalariaRegisterFragment;

import static org.mockito.Mockito.times;

public class BaseMalariaRegisterFragmentTest {
    @Mock
    public BaseMalariaRegisterFragment baseMalariaRegisterFragment;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void openProfile() throws Exception {
        Whitebox.invokeMethod(baseMalariaRegisterFragment, "openProfile", null);
        PowerMockito.mockStatic(BaseMalariaProfileActivity.class);
        BaseMalariaProfileActivity.startProfileActivity(null, null);
        PowerMockito.verifyStatic(times(1));

    }


}
