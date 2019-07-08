package org.smartregister.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;

public class MemberObjectTest {
    @Mock
    CommonPersonObjectClient client = Mockito.mock(CommonPersonObjectClient.class);

    private MemberObject memberObject = new MemberObject(client);

    @Test
    public void testSetFirstName() {
        memberObject.setFirstName("Denis");
        Assert.assertEquals("Denis", memberObject.getFirstName());
    }

    @Test
    public void testIsClosed() {
        memberObject.setIsClosed(false);
        Assert.assertFalse(memberObject.getIsClosed());
    }
}

