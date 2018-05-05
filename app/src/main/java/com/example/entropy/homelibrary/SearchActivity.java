package com.example.entropy.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    ImageButton popupMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        popupMenuBtn= (ImageButton) findViewById(R.id.img_btn_pop);
        popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(SearchActivity.this, popupMenuBtn);
                //inflating menu from xml resource
                popup.inflate(R.menu.navigation_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.myBooks:
                                Intent intentAllBooks = new Intent(SearchActivity.this, AllBooksActivity.class);
                                startActivity(intentAllBooks);
                                break;
                            case R.id.addBook:
                                Intent intentAddBook= new Intent (SearchActivity.this,AddBookAcivity.class) ;
                                startActivity(intentAddBook);
                                break;
                            case R.id.searchBook:
                             Toast.makeText(SearchActivity.this, "Ти си тук :P", Toast.LENGTH_SHORT).show();
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
