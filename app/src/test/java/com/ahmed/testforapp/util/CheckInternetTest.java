package com.ahmed.testforapp.util;

import android.content.Context;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class CheckInternetTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
     @Mock
    Context context;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
           context = mock(Context.class);
      }

    @Test
    public void isConnectingToInternet() {
        context = mock(Context.class);
          CheckInternet checkInternet = new CheckInternet(context);
         assertFalse(checkInternet.isConnectingToInternet());
    }
}