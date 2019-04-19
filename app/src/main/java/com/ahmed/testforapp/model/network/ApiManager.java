package com.ahmed.testforapp.model.network;

import com.ahmed.testforapp.model.entity.ArticleServerResponse;
import com.ahmed.testforapp.util.KeyUtil;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ApiManager {

    private final ApiInterface apiService;

    @Inject
    public ApiManager(ApiInterface apiService) {
        this.apiService = apiService;
    }


    public Observable<ArticleServerResponse> getArticles() {

        return apiService.getArticle(7,  KeyUtil.API_VALUE);
    }

}
