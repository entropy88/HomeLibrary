package com.example.entropy.homelibrary;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class AllBooksActivity extends AppCompatActivity {
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        recyclerView=(RecyclerView) findViewById(R.id.rec_allBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllBooksActivity.this));
        List<BookObject> booksList = HomeActivity.booksDatabase.booksDao().getBooks();
        BooksAdapter adapter= new BooksAdapter(booksList);
        recyclerView.setAdapter(adapter);

    }
}
