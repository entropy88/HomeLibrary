package com.example.entropy.homelibrary;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class AllBooksActivity extends AppCompatActivity {
RecyclerView recyclerView;
ImageButton popupMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        recyclerView=(RecyclerView) findViewById(R.id.rec_allBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllBooksActivity.this));
        List<BookObject> booksList = HomeActivity.booksDatabase.booksDao().getBooks();
        BooksAdapter adapter= new BooksAdapter(booksList);
        recyclerView.setAdapter(adapter);

        popupMenuBtn= (ImageButton) findViewById(R.id.img_btn_pop);
        popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(AllBooksActivity.this, popupMenuBtn);
                //inflating menu from xml resource
                popup.inflate(R.menu.navigation_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.myBooks:
                                Toast.makeText(AllBooksActivity.this, "Ти си тук :P", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.addBook:
                                Intent intentAddBook= new Intent (AllBooksActivity.this,AddBookAcivity.class) ;
                                startActivity(intentAddBook);
                                break;
                            case R.id.searchBook:
                                Intent searchBook= new Intent (AllBooksActivity.this,SearchActivity.class) ;
                                startActivity(searchBook);

                                break;

                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });

    }
}
