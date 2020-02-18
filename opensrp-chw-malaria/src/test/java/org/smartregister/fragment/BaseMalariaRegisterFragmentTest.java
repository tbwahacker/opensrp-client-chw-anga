package org.smartregister.fragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.chw.malaria.fragment.BaseMalariaRegisterFragment;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import static org.mockito.Mockito.times;

public class BaseMalariaRegisterFragmentTest {
    @Mock
    public BaseMalariaRegisterFragment baseMalariaRegisterFragment;

    @Mock
    public CommonPersonObjectClient client;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void openProfile() throws Exception {
        Whitebox.invokeMethod(baseMalariaRegisterFragment, "openProfile", client);
        PowerMockito.mockStatic(BaseMalariaProfileActivity.class);
        BaseMalariaProfileActivity.startProfileActivity(null, null);
        PowerMockito.verifyStatic(times(1));

    }


}
