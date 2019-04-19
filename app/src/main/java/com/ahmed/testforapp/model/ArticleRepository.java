package com.ahmed.testforapp.model;

import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.model.entity.ArticleMapper;
import com.ahmed.testforapp.model.entity.ArticleServerResponse;
import com.ahmed.testforapp.model.local.ArticleDao;
import com.ahmed.testforapp.model.network.ApiManager;
import com.ahmed.testforapp.util.CheckInternet;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ArticleRepository {
   private ArticleDao articleDao;
   private ApiManager dataManager;
    private  CheckInternet checkInternet;
    private  ArticleMapper articleMapper;


    @Inject
    public ArticleRepository(ArticleDao articleDao, ApiManager dataManager,ArticleMapper articleMapper,CheckInternet checkInternet) {
        this.articleDao = articleDao;
        this.dataManager = dataManager;
        this.checkInternet = checkInternet;
        this.articleMapper = articleMapper;
    }



    public Single<List<Article>> loadArticle() {
        Single<List<Article>> article;
        if(checkInternet.isConnectingToInternet()) {
            article = dataManager.getArticles().flatMapIterable(ArticleServerResponse::getArticleServerServers)
                    .map(item -> articleMapper.transFrom(item))
                    .toList();
        }else {
            article = articleDao.getArticleList();
        }
        return article;
    }


}
