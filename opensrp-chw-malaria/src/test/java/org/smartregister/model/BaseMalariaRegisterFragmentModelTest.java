package org.smartregister.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.malaria.model.BaseMalariaRegisterFragmentModel;

public class BaseMalariaRegisterFragmentModelTest {

    @Mock
    private BaseMalariaRegisterFragmentModel baseMalariaRegisterFragmentModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkDefaultConfig() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.defaultRegisterConfiguration());
    }

    @Test
    public void checkViewConfig() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.getViewConfiguration(null));
    }

    @Test
    public void checkRegisterActiveColumnsReturnNotNull() {
        Assert.assertNotNull(baseMalariaRegisterFragmentModel.getRegisterActiveColumns(null));
    }

    @Test
    public void checkCountSelect() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.countSelect(null, null));
    }

    @Test
    public void checkMainSelect() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.mainSelect(null, null));
    }

    @Test
    public void checkGetFilterText() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.getFilterText(null, null));
    }

    @Test
    public void checkGetSortText() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.getSortText(null));
    }

    @Test
    public void checkJsonArray() {
        Assert.assertNull(baseMalariaRegisterFragmentModel.getJsonArray(null));
    }
}
