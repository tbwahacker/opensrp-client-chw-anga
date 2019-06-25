package org.smartregister.chw.malaria.domain;

import org.smartregister.chw.malaria.util.DBConstants;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import java.io.Serializable;

public class MemberObject implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String gender;
    private String uniqueId;
    private String age;
    private String baseEntityId;
    private String relationalId;
    private String primaryCareGiver;
    private String familyHead;
    private String familyBaseEntityId;

    public MemberObject(CommonPersonObjectClient client) {
        firstName = client.getColumnmaps().get(DBConstants.KEY.FIRST_NAME) != null ? client.getColumnmaps().get(DBConstants.KEY.FIRST_NAME) : "";
        middleName = client.getColumnmaps().get(DBConstants.KEY.MIDDLE_NAME) != null ? client.getColumnmaps().get(DBConstants.KEY.MIDDLE_NAME) : "";
        lastName = client.getColumnmaps().get(DBConstants.KEY.LAST_NAME) != null ? client.getColumnmaps().get(DBConstants.KEY.LAST_NAME) : "";
        address = client.getColumnmaps().get(DBConstants.KEY.VILLAGE_TOWN) != null ? client.getColumnmaps().get(DBConstants.KEY.VILLAGE_TOWN) : "";
        gender = client.getColumnmaps().get(DBConstants.KEY.GENDER) != null ? client.getColumnmaps().get(DBConstants.KEY.GENDER) : "";
        age = client.getColumnmaps().get(DBConstants.KEY.DOB) != null ? client.getColumnmaps().get(DBConstants.KEY.DOB) : "";
        uniqueId = client.getColumnmaps().get(DBConstants.KEY.UNIQUE_ID);
        baseEntityId = client.getColumnmaps().get(DBConstants.KEY.BASE_ENTITY_ID);
        relationalId = client.getColumnmaps().get(DBConstants.KEY.RELATIONAL_ID);
        primaryCareGiver = client.getColumnmaps().get(DBConstants.KEY.PRIMARY_CARE_GIVER);
        familyHead = client.getColumnmaps().get(DBConstants.KEY.FAMILY_HEAD);
        familyBaseEntityId = client.getColumnmaps().get(DBConstants.KEY.FAMILY_BASE_ENTITY_ID);
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

    public String getBaseEntityId() {
        return baseEntityId;
    }

    public void setBaseEntityId(String baseEntityId) {
        this.baseEntityId = baseEntityId;
    }

    public String getRelationalId() {
        return relationalId;
    }

    public void setRelationalId(String relationalId) {
        this.relationalId = relationalId;
    }

    public String getFamilyBaseEntityId() {
        return familyBaseEntityId;
    }

    public void setFamilyBaseEntityId(String familyBaseEntityId) {
        this.familyBaseEntityId = familyBaseEntityId;
    }

    public String getPrimaryCareGiver() {
        return primaryCareGiver;
    }

    public void setPrimaryCareGiver(String primaryCareGiver) {
        this.primaryCareGiver = primaryCareGiver;
    }

    public String getFamilyHead() {
        return familyHead;
    }

    public void setFamilyHead(String familyHead) {
        this.familyHead = familyHead;
    }



}
