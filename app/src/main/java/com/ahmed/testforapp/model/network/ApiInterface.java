package com.ahmed.testforapp.model.network;

import com.ahmed.testforapp.model.entity.ArticleServerResponse;
import com.ahmed.testforapp.util.KeyUtil;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("{days}.json")
    Observable<ArticleServerResponse> getArticle(@Path ("days")int day, @Query(KeyUtil.API_KEY) String keyAPi);

}
