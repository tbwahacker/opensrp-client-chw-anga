package org.smartregister.presenter;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.malaria.contract.MalariaRegisterContract;
import org.smartregister.chw.malaria.presenter.BaseMalariaRegisterPresenter;

@PrepareForTest(BaseMalariaRegisterPresenter.class)
public class BaseMalariaRegisterPresenterTest {
    @Mock
    protected BaseMalariaRegisterPresenter baseMalariaRegisterPresenter;

    @Mock
    protected MalariaRegisterContract.View baseView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void startFormWhenEntityIdIsNull() throws Exception {
        baseMalariaRegisterPresenter.startForm("formName", "", "121212121212", "231231231231");
        Mockito.verify(baseView, Mockito.never()).startFormActivity(null);
    }

    @Test
    public void startFormWithEntityId() throws Exception {
        baseMalariaRegisterPresenter.startForm("formName", "12121212", "121212121212", "231231231231");
        Mockito.verify(baseView, Mockito.never()).startFormActivity(new JSONObject());
    }


    @Test
    public void getViewWhenViewIsNull() throws Exception {
        Assert.assertNull(Whitebox.invokeMethod(baseMalariaRegisterPresenter, "getView"));
    }

}
