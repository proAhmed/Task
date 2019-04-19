package com.ahmed.testforapp.model.entity;

import com.ahmed.testforapp.ArticleModelTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleMapperTest {

   private ArticleMapper articleMapper;

    @Before
    public void setUp() throws Exception {
        articleMapper = new ArticleMapper();
    }

    @Test
    public void transFrom() {
        Article article = ArticleModelTest.createArticle();
        ArticleServer articleServer = ArticleModelTest.createArticleServer();
        Article articleMapped =   articleMapper.transFrom(articleServer);
        assertEquals(123,articleMapped.getId(), article.getId());


    }
}