package org.smartregister.presenter;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.smartregister.chw.malaria.contract.MalariaRegisterContract;
import org.smartregister.chw.malaria.presenter.BaseMalariaRegisterPresenter;


@PrepareForTest(BaseMalariaRegisterPresenter.class)
public class BaseMalariaRegisterPresenterTest {
    @Mock
    protected BaseMalariaRegisterPresenter baseMalariaRegisterPresenter;


    @Mock
    protected MalariaRegisterContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void startForm() throws Exception {
        baseMalariaRegisterPresenter.startForm("formName", "", "121212121212", "231231231231");
        Mockito.verify(view, Mockito.never()).startFormActivity(null);
    }

    @Test
    public void startFormWithEntityId() throws Exception {
        baseMalariaRegisterPresenter.startForm("formName", "12121212", "121212121212", "231231231231");
        Mockito.verify(view, Mockito.never()).startFormActivity(new JSONObject());
    }

    @Test
    public void saveForm() {
        baseMalariaRegisterPresenter.saveForm("{}");
        Mockito.verify(view, Mockito.never()).showProgressDialog(1);
    }

}
