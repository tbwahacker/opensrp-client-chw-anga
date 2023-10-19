package org.smartregister.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.anga.contract.AngaRegisterFragmentContract;
import org.smartregister.chw.anga.presenter.BaseAngaRegisterFragmentPresenter;
import org.smartregister.chw.anga.util.Constants;
import org.smartregister.chw.anga.util.DBConstants;
import org.smartregister.configurableviews.model.View;

import java.util.Set;
import java.util.TreeSet;

public class BaseAngaRegisterFragmentPresenterTest {
    @Mock
    protected AngaRegisterFragmentContract.View view;

    @Mock
    protected AngaRegisterFragmentContract.Model model;

    private BaseAngaRegisterFragmentPresenter baseAngaRegisterFragmentPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        baseAngaRegisterFragmentPresenter = new BaseAngaRegisterFragmentPresenter(view, model, "");
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAngaRegisterFragmentPresenter);
    }

    @Test
    public void getMainCondition() {
        Assert.assertEquals("", baseAngaRegisterFragmentPresenter.getMainCondition());
    }

    @Test
    public void getDueFilterCondition() {
        Assert.assertEquals(" (cast( julianday(STRFTIME('%Y-%m-%d', datetime('now'))) -  julianday(IFNULL(SUBSTR(anga_test_date,7,4)|| '-' || SUBSTR(anga_test_date,4,2) || '-' || SUBSTR(anga_test_date,1,2),'')) as integer) between 7 and 14) ", baseAngaRegisterFragmentPresenter.getDueFilterCondition());
    }

    @Test
    public void getDefaultSortQuery() {
        Assert.assertEquals(Constants.TABLES.ANGA_CONFIRMATION + "." + DBConstants.KEY.LAST_INTERACTED_WITH + " DESC ", baseAngaRegisterFragmentPresenter.getDefaultSortQuery());
    }

    @Test
    public void getMainTable() {
        Assert.assertEquals(Constants.TABLES.ANGA_CONFIRMATION, baseAngaRegisterFragmentPresenter.getMainTable());
    }

    @Test
    public void initializeQueries() {
        Set<View> visibleColumns = new TreeSet<>();
        baseAngaRegisterFragmentPresenter.initializeQueries(null);
        Mockito.doNothing().when(view).initializeQueryParams("ec_anga_confirmation", null, null);
        Mockito.verify(view).initializeQueryParams("ec_anga_confirmation", null, null);
        Mockito.verify(view).initializeAdapter(visibleColumns);
        Mockito.verify(view).countExecute();
        Mockito.verify(view).filterandSortInInitializeQueries();
    }

}