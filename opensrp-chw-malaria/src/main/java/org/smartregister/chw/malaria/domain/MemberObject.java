package org.smartregister.chw.malaria.domain;

import org.smartregister.chw.malaria.util.DBConstants;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import java.io.Serializable;

public class MemberObject implements Serializable {
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String address;
    protected String gender;
    protected String uniqueId;
    protected String age;

    public MemberObject(CommonPersonObjectClient client) {
        firstName = client.getColumnmaps().get(DBConstants.KEY.FIRST_NAME);
        middleName = client.getColumnmaps().get(DBConstants.KEY.MIDDLE_NAME);
        lastName = client.getColumnmaps().get(DBConstants.KEY.LAST_NAME);
        address = client.getColumnmaps().get(DBConstants.KEY.VILLAGE_TOWN);
        gender = client.getColumnmaps().get(DBConstants.KEY.GENDER);
        uniqueId = client.getColumnmaps().get(DBConstants.KEY.UNIQUE_ID);
        age = client.getColumnmaps().get(DBConstants.KEY.DOB);
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }



}
