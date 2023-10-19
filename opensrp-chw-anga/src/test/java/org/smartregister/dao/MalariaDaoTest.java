package org.smartregister.dao;

import net.sqlcipher.database.SQLiteDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.smartregister.chw.anga.dao.AngaDao;
import org.smartregister.repository.Repository;

@RunWith(MockitoJUnitRunner.class)
public class AngaDaoTest extends AngaDao {

    @Mock
    private Repository repository;

    @Mock
    private SQLiteDatabase database;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setRepository(repository);
    }

    @Test
    public void testGetAngaTestDate() {
        Mockito.doReturn(database).when(repository).getReadableDatabase();
        AngaDao.getAngaTestDate("123456");
        Mockito.verify(database).rawQuery(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void testIsRegisteredForAnga() {
        Mockito.doReturn(database).when(repository).getReadableDatabase();
        boolean registered = AngaDao.isRegisteredForAnga("12345");
        Mockito.verify(database).rawQuery(Mockito.anyString(), Mockito.any());
        Assert.assertFalse(registered);
    }
}

