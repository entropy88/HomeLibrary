package com.example.entropy.homelibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BooksDao {
    @Insert
    public void addBook(BookObject bookObject);

    @Query("select * from books")
    public List<BookObject> getBooks();

    @Query("select* from books where author==:userQuery OR title==:userQuery")
    BookObject findBookByTitleOrAuthor(String userQuery);

}
