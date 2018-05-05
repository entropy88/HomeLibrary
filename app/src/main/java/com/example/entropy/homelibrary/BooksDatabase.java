package com.example.entropy.homelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {BookObject.class},version = 2)
public abstract  class BooksDatabase extends RoomDatabase {
    public abstract BooksDao booksDao();
}
