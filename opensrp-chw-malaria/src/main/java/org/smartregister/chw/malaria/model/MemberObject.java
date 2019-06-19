package org.smartregister.chw.malaria.model;

import org.smartregister.commonregistry.CommonPersonObjectClient;

public class MemberObject {
    public static CommonPersonObjectClient client;
    public MemberObject(CommonPersonObjectClient client) {
        MemberObject.client = client;
    }

    public static CommonPersonObjectClient getClient() {
        return client;
    }
}
