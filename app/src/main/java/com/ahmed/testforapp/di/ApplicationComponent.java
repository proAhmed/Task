package com.ahmed.testforapp.di;

import android.app.Application;

import com.ahmed.testforapp.base.BaseApplication;
import com.ahmed.testforapp.di.module.ActivityBindingModule;
import com.ahmed.testforapp.di.module.ContextModule;
import com.ahmed.testforapp.di.module.RetrofitClass;
import com.ahmed.testforapp.model.local.ArticleDao;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Component(modules = {ContextModule.class, RetrofitClass.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class,ArticleDao.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {
    void inject(BaseApplication baseApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }


}
