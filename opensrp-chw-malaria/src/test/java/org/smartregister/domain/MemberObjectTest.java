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
    public void getMalariaTestDate() {
        memberObject.setMalariaTestDate("2019-10-05");
        Assert.assertEquals("2019-10-05", memberObject.getMalariaTestDate());
    }

    @Test
    public void getFamilyHead() {
        memberObject.setFamilyHead("Lidya Erick");
        Assert.assertEquals("Lidya Erick", memberObject.getFamilyHead());
    }

    @Test
    public void getPrimaryCareGiver() {
        memberObject.setPrimaryCareGiver("Denis Rwelamila");
        Assert.assertEquals("Denis Rwelamila", memberObject.getPrimaryCareGiver());
    }

    @Test
    public void testIsClosed() {
        memberObject.setIsClosed(false);
        Assert.assertFalse(memberObject.getIsClosed());
    }
}

