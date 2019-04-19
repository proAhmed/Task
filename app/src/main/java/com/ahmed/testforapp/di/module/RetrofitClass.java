package com.ahmed.testforapp.di.module;


import android.app.Application;

import com.ahmed.testforapp.model.local.ArticleDao;
import com.ahmed.testforapp.model.local.NewsDb;
import com.ahmed.testforapp.model.network.ApiInterface;
import com.ahmed.testforapp.util.KeyUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module(includes = ViewModelModule.class)
public class RetrofitClass {

   @Provides
  public static Retrofit getClient() {
             OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(120, TimeUnit.SECONDS)
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build();
        return  new Retrofit.Builder()
                    .baseUrl(KeyUtil.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
     }

    @Provides
   public static NewsDb provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), NewsDb.class, "NewTimes.db").allowMainThreadQueries().build();
    }

    @Provides
    public static ArticleDao provideArticleDao(NewsDb newsDb) {
        return newsDb.articleDao();
    }
    @Provides
  public static ApiInterface provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

}
