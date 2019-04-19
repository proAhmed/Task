package com.ahmed.testforapp.model.local;


import com.ahmed.testforapp.model.entity.Article;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Article.class}, version = 2, exportSchema = false)
 abstract public class NewsDb extends RoomDatabase {
    public abstract ArticleDao articleDao();

}
