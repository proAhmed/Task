package com.ahmed.testforapp.model.local;

import com.ahmed.testforapp.model.entity.Article;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import dagger.Module;
import io.reactivex.Single;

@Module
@Dao
public interface ArticleDao {
     @Query("SELECT * FROM  Article WHERE id = :id")
    Single<Article> getSelectedArticle(String id);

     @Query("SELECT * FROM  Article ")
    Single<List<Article>> getArticleList();

     @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Article article);

     @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Article> articleList);

     @Delete
    void delete(Article article);

     @Update
    void update(Article article);
}
