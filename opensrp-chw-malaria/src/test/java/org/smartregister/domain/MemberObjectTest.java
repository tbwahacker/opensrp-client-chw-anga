package org.smartregister.domain;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.malaria.domain.MemberObject;
import org.smartregister.commonregistry.CommonPersonObjectClient;

public class MemberObjectTest {
    @Mock
    private CommonPersonObjectClient client = Mockito.mock(CommonPersonObjectClient.class);

    private MemberObject memberObject = new MemberObject(client);

    @Test
    public void getFirstName() {
        memberObject.setFirstName("Denis");
        Assert.assertEquals("Denis", memberObject.getFirstName());
    }


    @Test
    public void getMiddleName() {
        memberObject.setMiddleName("Talemwa");
        Assert.assertEquals("Talemwa", memberObject.getMiddleName());
    }

    @Test
    public void getLastName() {
        memberObject.setLastName("Rwelamila");
        Assert.assertEquals("Rwelamila", memberObject.getLastName());
    }

    @Test
    public void getAddress() {
        memberObject.setAddress("123 Rd");
        Assert.assertEquals("123 Rd", memberObject.getAddress());
    }

    @Test
    public void getGender() {
        memberObject.setGender("Male");
        Assert.assertEquals("Male", memberObject.getGender());
    }

    @Test
    public void getAge() {
        memberObject.setAge("123");
        Assert.assertEquals("123", memberObject.getAge());
    }

    @Test
    public void testIsClosed() {
        memberObject.setIsClosed(false);
        Assert.assertFalse(memberObject.getIsClosed());
    }

    @Test
    public void getUniqueId() {
        memberObject.setUniqueId("#1223");
        Assert.assertEquals("#1223", memberObject.getUniqueId());
    }

    @Test
    public void getRelationalid() {
        memberObject.setRelationalId("#1223");
        Assert.assertEquals("#1223", memberObject.getRelationalid());
    }

    @Test
    public void getDetails() {
        memberObject.setDetails("#1223");
        Assert.assertEquals("#1223", memberObject.getDetails());
    }
}

