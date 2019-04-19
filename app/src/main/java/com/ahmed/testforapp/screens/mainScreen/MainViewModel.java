package com.ahmed.testforapp.screens.mainScreen;


import com.ahmed.testforapp.model.ArticleRepository;
import com.ahmed.testforapp.model.entity.Article;
import com.ahmed.testforapp.model.local.ArticleDao;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {

    private CompositeDisposable disposable;
    private final ArticleRepository dataManager;
    private final MutableLiveData<List<Article>> newsModelMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    @Inject
    public ArticleDao articleDao;

    @Inject
    public MainViewModel(ArticleRepository dataManager) {
        this.dataManager = dataManager;
        disposable = new CompositeDisposable();

    }

    public LiveData<List<Article>> getRepos() {
        return newsModelMutableLiveData;
    }

    public LiveData<Boolean> getError() {
        return repoLoadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }


    void getData() {
        disposable.add(dataManager.loadArticle().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<Article>>() {
                    @Override
                    public void onSuccess(List<Article> value) {
                        repoLoadError.setValue(false);
                        newsModelMutableLiveData.setValue(value);
                        loading.setValue(false);

                    //    articleDao.insertAll(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
