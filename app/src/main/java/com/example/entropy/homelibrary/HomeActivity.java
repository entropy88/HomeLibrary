package com.example.entropy.homelibrary;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    public static BooksDatabase booksDatabase;
    Button allScreen;
    Button searchScreen;
    Button addScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        allScreen=(Button)findViewById(R.id.btn_screen_all);
        searchScreen=(Button) findViewById(R.id.btn_screen_search);
        addScreen= (Button) findViewById(R.id.btn_screen_add);

        booksDatabase = Room.databaseBuilder
                (HomeActivity.this,BooksDatabase.class, "books")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        allScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allBooks= new Intent(HomeActivity.this, AllBooksActivity.class);
                startActivity(allBooks);
            }
        });
        addScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addBook= new Intent (HomeActivity.this, AddBookAcivity.class);
                startActivity(addBook);
            }
        });
        searchScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchBook= new Intent (HomeActivity.this, SearchActivity.class);
                startActivity(searchBook);
            }
        });
    }
}
