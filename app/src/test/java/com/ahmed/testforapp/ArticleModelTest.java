package com.ahmed.testforapp;

import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.model.entity.ArticleServer;
import com.ahmed.testforapp.model.entity.Medium;

import java.util.ArrayList;
import java.util.List;

public class ArticleModelTest {

    public static Article createArticle(){
        Article article = new Article();
        article.setId(123);
        article.setGeoFacet("");
        article.setMedia(new Medium());
        return article;
    }
    public static ArticleServer createArticleServer(){
        ArticleServer article = new ArticleServer();
        article.setId(123);
        List<String> geoFact = new ArrayList<>();
        geoFact.add("");
        article.setGeoFacet(geoFact);
        List<Medium> mediumList = new ArrayList<>();
        mediumList.add(new Medium());
        article.setMedia(mediumList);
        return article;
    }
}
