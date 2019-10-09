package org.smartregister.activity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;
import org.smartregister.chw.malaria.presenter.BaseMalariaProfilePresenter;

public class BaseMalariaProfileActivityTest {
    @Mock
    protected BaseMalariaProfileActivity baseMalariaProfileActivity;

    @Mock
    protected BaseMalariaProfilePresenter presenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaProfileActivity);
    }

    @Test
    public void setProfileViewWithData() {
        baseMalariaProfileActivity.setProfileViewWithData();
        Mockito.verify(presenter).recordMalariaButton(12);
    }
}
