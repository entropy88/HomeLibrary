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

//fix this
//    @Query("select * from books  WHERE title LIKE 'userQuery' OR author LIKE 'userQuery' OR keywords LIKE 'userQuery' OR year LIKE 'userQuery' ")
//    public List <BookObject> searchBooks(String userQuery);

    @Query ("delete  from books where id ==:thisId")
    void deleteBook(int thisId);

    @Query ("select * from books where id ==:selectedId")
    BookObject selectBook (int selectedId);

    @Query("UPDATE books SET author = :authorStr, title= :titleStr, year= :yearStr, keywords =:keywordsStr WHERE id =:thisId")
    void update(String authorStr, String titleStr, String yearStr, String keywordsStr, int thisId);
}
