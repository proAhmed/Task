package com.ahmed.testforapp.screens.detailScreen;

import android.os.Bundle;

import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.util.KeyUtil;

import java.util.Objects;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {

      private final MutableLiveData<Article> newsModelMutableLiveData = new MutableLiveData<>();
    @Inject
    public DetailViewModel() {
    }

    public LiveData<Article> getSelectedRepo() {
        return newsModelMutableLiveData;
    }
    public void setSelectedArticle(Article repo) {
        newsModelMutableLiveData.setValue(repo);
    }

    public void saveToBundle(Bundle outState) {
        if(newsModelMutableLiveData.getValue() != null) {
            outState.putParcelable(KeyUtil.ARTICLE_KEY,outState.getParcelable(""));

        }
    }

    public void restoreFromBundle(Bundle savedInstanceState) {
        if(newsModelMutableLiveData.getValue() == null) {
            if(savedInstanceState != null && savedInstanceState.containsKey(KeyUtil.ARTICLE_KEY)) {
                newsModelMutableLiveData.setValue(Objects.requireNonNull(savedInstanceState.getParcelable("repo_details")));
            }
        }
    }





    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
