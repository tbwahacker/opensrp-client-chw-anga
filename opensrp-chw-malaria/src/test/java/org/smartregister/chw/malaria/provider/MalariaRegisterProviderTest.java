package org.smartregister.chw.malaria.provider;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;

public class MalariaRegisterProviderTest {
    @Mock
    private MalariaRegisterProvider malariaRegisterProvider;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateClients() {
        Assert.assertNull(malariaRegisterProvider.updateClients(null, null, null, null));
    }

    @Test
    public void newFormLauncher() {
        Assert.assertNull(malariaRegisterProvider.newFormLauncher(null, null, null));
    }

    @Test
    public void checkInflater() {
        Assert.assertNull(malariaRegisterProvider.inflater());
    }

    @Test
    public void checkFooter() {
        Assert.assertNotNull(malariaRegisterProvider.isFooterViewHolder(null));
    }

    @Test
    public void checkFooterCreation() {
        Assert.assertNull(malariaRegisterProvider.createFooterHolder(null));
    }

    @Test
    public void checkHolderCreation() {
        Assert.assertNull(malariaRegisterProvider.createViewHolder(null));
    }

}