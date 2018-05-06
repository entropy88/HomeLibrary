package com.example.entropy.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddBookAcivity extends AppCompatActivity {
    EditText edtAuthor;
    EditText edtTitle;
    EditText edtYear;
    EditText edtKeywords;
    Button addBook;
    ImageButton popupMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_acivity);

        popupMenuBtn = (ImageButton) findViewById(R.id.img_btn_pop);
        popupMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(AddBookAcivity.this, popupMenuBtn);
                //inflating menu from xml resource
                popup.inflate(R.menu.navigation_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.myBooks:
                                Intent allBooks = new Intent(AddBookAcivity.this, AllBooksActivity.class);
                                startActivity(allBooks);
                                break;

                            case R.id.addBook:
                                Toast.makeText(AddBookAcivity.this, "Ти си тук :P", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.searchBook:
                                Intent searchBook = new Intent(AddBookAcivity.this, SearchActivity.class);
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


        edtAuthor = (EditText) findViewById(R.id.edt_author);
        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtYear = (EditText) findViewById(R.id.edt_year);
        edtKeywords = (EditText) findViewById(R.id.edt_keywords);
        addBook = (Button) findViewById(R.id.btn_addBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = edtAuthor.getText().toString();
                String title = edtTitle.getText().toString();
                String year = edtYear.getText().toString();
                String keywords = edtKeywords.getText().toString();

                BookObject book = new BookObject();
                book.setAuthor(author);
                book.setTitle(title);
                book.setYear(year);
                book.setKeywords(keywords);
                book.setId(0);



                HomeActivity.booksDatabase.booksDao().addBook(book);
                Toast.makeText(AddBookAcivity.this, book.getTitle() + " беше добавена към библиотеката", Toast.LENGTH_LONG).show();
                edtAuthor.setText("");
                edtTitle.setText("");
                edtKeywords.setText("");
                edtYear.setText("");
            }
        });
    }

}
