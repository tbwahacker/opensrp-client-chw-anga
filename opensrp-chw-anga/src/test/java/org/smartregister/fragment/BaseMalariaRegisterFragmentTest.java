package org.smartregister.fragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.anga.activity.BaseAngaProfileActivity;
import org.smartregister.chw.anga.fragment.BaseAngaRegisterFragment;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import static org.mockito.Mockito.times;

public class BaseAngaRegisterFragmentTest {
    @Mock
    public BaseAngaRegisterFragment baseAngaRegisterFragment;

    @Mock
    public CommonPersonObjectClient client;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void openProfile() throws Exception {
        Whitebox.invokeMethod(baseAngaRegisterFragment, "openProfile", client);
        PowerMockito.mockStatic(BaseAngaProfileActivity.class);
        BaseAngaProfileActivity.startProfileActivity(null, null);
        PowerMockito.verifyStatic(times(1));

    }
}
