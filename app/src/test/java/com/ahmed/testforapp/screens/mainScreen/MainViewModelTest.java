package com.ahmed.testforapp.screens.mainScreen;

import com.ahmed.testforapp.model.ArticleRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import static org.junit.Assert.assertFalse;

public class MainViewModelTest {

    @Mock
   private ArticleRepository articleRepository;
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();


  private   MainViewModel mainViewModel;
    @Mock
  private   MainViewModel mocked;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

         mainViewModel = new MainViewModel(articleRepository);

    }

    @Test
    public void getRepos() {

        mainViewModel.getRepos();


    }

    @Test
    public void getError() {
        mainViewModel.getError();
       assertFalse(mocked.getError().getValue());

    }

    @Test
    public void getLoading() {
        mainViewModel.getLoading();
    }



}