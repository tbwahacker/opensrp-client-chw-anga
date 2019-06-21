package org.smartregister.chw.malaria.domain;

import org.smartregister.chw.malaria.util.DBConstants;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import java.io.Serializable;

public class MemberObject implements Serializable {
    protected String first_name;
    protected String middle_name;
    protected String last_name;
    protected String address;
    protected String gender;
    protected String unique_id;
    protected String age;

    public MemberObject(CommonPersonObjectClient client) {
        first_name = client.getColumnmaps().get(DBConstants.KEY.FIRST_NAME);
        middle_name = client.getColumnmaps().get(DBConstants.KEY.MIDDLE_NAME);
        last_name = client.getColumnmaps().get(DBConstants.KEY.LAST_NAME);
        address = client.getColumnmaps().get(DBConstants.KEY.VILLAGE_TOWN);
        gender = client.getColumnmaps().get(DBConstants.KEY.GENDER);
        unique_id = client.getColumnmaps().get(DBConstants.KEY.UNIQUE_ID);
        age = client.getColumnmaps().get(DBConstants.KEY.DOB);
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }



}
