package org.smartregister.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.malaria.contract.MalariaRegisterFragmentContract;
import org.smartregister.chw.malaria.presenter.BaseMalariaRegisterFragmentPresenter;

public class BaseMalariaRegisterFragmentPresenterTest {
    @Mock
    protected MalariaRegisterFragmentContract.View view;
    @Mock
    protected MalariaRegisterFragmentContract.Model model;
    private BaseMalariaRegisterFragmentPresenter baseMalariaRegisterFragmentPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        baseMalariaRegisterFragmentPresenter = new BaseMalariaRegisterFragmentPresenter(view, model, "");
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaRegisterFragmentPresenter);
    }

    @Test
    public void testGetMainCondition() {
        Assert.assertEquals("", baseMalariaRegisterFragmentPresenter.getMainCondition());
    }

}