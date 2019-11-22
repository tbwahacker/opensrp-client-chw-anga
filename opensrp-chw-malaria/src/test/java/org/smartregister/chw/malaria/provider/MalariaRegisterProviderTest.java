package org.smartregister.chw.malaria.provider;

import android.app.Activity;
import android.view.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;
import org.smartregister.commonregistry.CommonPersonObjectClient;
import java.util.HashMap;
import java.util.Map;

public class MalariaRegisterProviderTest {
    @Mock
    private MalariaRegisterProvider malariaRegisterProvider;

    @Mock
    public CommonPersonObjectClient commonPersonObjectClient;

    @Mock
    View.OnClickListener listener;

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

    @Test
    public void is_anc_closed() throws Exception{
        Activity activity = Mockito.mock(Activity.class);
        MalariaRegisterProvider provider = new MalariaRegisterProvider(activity, listener, listener, null);
        Map<String, String > map = new HashMap<>();
        map.put("is_anc_closed", "0");
        Mockito.when(commonPersonObjectClient.getColumnmaps()).thenReturn(map);
        Assert.assertEquals("ANC", Whitebox.invokeMethod(provider, "updateMemberGender", commonPersonObjectClient));
    }

    @Test
    public void is_pnc_closed() throws Exception{
        Activity activity = Mockito.mock(Activity.class);
        MalariaRegisterProvider provider = new MalariaRegisterProvider(activity, listener, listener, null);
        Map<String, String > map = new HashMap<>();
        map.put("is_pnc_closed", "0");
        Mockito.when(commonPersonObjectClient.getColumnmaps()).thenReturn(map);
        Assert.assertEquals("PNC", Whitebox.invokeMethod(provider, "updateMemberGender", commonPersonObjectClient));
    }

}