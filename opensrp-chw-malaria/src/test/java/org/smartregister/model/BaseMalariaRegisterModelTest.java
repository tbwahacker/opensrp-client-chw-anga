package org.smartregister.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.malaria.model.BaseMalariaRegisterModel;

public class BaseMalariaRegisterModelTest {

    @Mock
    private BaseMalariaRegisterModel baseMalariaRegisterModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkJSon() {
        try {
            Assert.assertNull(baseMalariaRegisterModel.getFormAsJson(null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
