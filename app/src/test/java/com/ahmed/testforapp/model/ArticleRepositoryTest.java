package com.ahmed.testforapp.model;

import android.content.Context;

import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.model.entity.ArticleMapper;
import com.ahmed.testforapp.model.local.ArticleDao;
import com.ahmed.testforapp.model.network.ApiManager;
import com.ahmed.testforapp.util.CheckInternet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArticleRepositoryTest {
    @Mock
    private ApiManager mockApiManager;
    @Mock private ArticleDao mockArticleDao;
    private ArticleRepository articleRepository;

    @Mock
    private CheckInternet checkInternet;
    @Mock
    private ArticleMapper articleMapper;

    @Before
    public void setUp() {

        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
         MockitoAnnotations.initMocks(this);
        Context context = mock(Context.class);
         checkInternet = new CheckInternet(context);
        articleRepository = new ArticleRepository(mockArticleDao,mockApiManager,articleMapper,checkInternet);
    }

    @Test
    public void loadArticleDataBase() {
        articleRepository.loadArticle();
        verify(mockArticleDao).getArticleList();
    }
    @Test
    public void loadArticle() throws InterruptedException {
        List<Article> list = new ArrayList<>();
        list.add(new Article());
        Single<List<Article>> articleList = Single.just(list);
        when(articleRepository.loadArticle()).thenReturn(articleList);
    }

}