package com.ahmed.testforapp.di.module;

import android.app.Application;
import android.content.res.Resources;

import com.ahmed.testforapp.R;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RetrofitClassTest {


    @Mock
    private Application mContext;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setupContext();
    }

    @Test
    public void getClient() {
        assertTrue(RetrofitClass.getClient().baseUrl().isHttps());
    }

    @Test
    public void provideDatabase() {
        assertNotNull(RetrofitClass.provideDatabase(mContext));
    }

    @Test
    public void provideArticleDao() {
    }

    @Test
    public void provideRetrofitService() {
    }

    private void setupContext() {
        when(mContext.getApplicationContext()).thenReturn(mContext);
        when(mContext.getString(R.string.ny_times))
                .thenReturn("Ny Times Most Popular");
        when(mContext.getString(R.string.error))
                .thenReturn("Error in Loading");

        when(mContext.getResources()).thenReturn(mock(Resources.class));
    }
}