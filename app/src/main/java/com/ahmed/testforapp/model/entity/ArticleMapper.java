package com.ahmed.testforapp.model.entity;

import javax.inject.Inject;

public class ArticleMapper {
    @Inject
    public ArticleMapper() {
    }
    public Article transFrom(ArticleServer articleServer){
        Article article = new Article();
        article.setAbstract(articleServer.getAbstract());
        article.setAdxKeywords(articleServer.getAdxKeywords());
        article.setByline(articleServer.getByline());
        article.setGeoFacet(articleServer.getGeoFacet().get(0));
        article.setId(articleServer.getId());
        article.setMedia(articleServer.getMedia().get(0));
        article.setPublishedDate(articleServer.getPublishedDate());
        article.setSection(articleServer.getSection());
        article.setSource(articleServer.getSource());
        article.setTitle(articleServer.getTitle());
        return article;

    }
}
