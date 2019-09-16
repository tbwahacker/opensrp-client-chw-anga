package org.smartregister.activity;

import android.graphics.Color;
import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;

public class BaseMalariaProfileActivityTest {
    @Mock
    protected BaseMalariaProfileActivity baseMalariaProfileActivity;

    @Spy
    protected BaseMalariaProfileActivity spy;

    @Mock
    protected View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaProfileActivity);
    }

}
