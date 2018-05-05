package com.example.entropy.homelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookAcivity extends AppCompatActivity {
    EditText edtAuthor;
    EditText edtTitle;
    EditText edtYear;
    EditText edtKeywords;
    Button addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_acivity);

        edtAuthor=(EditText) findViewById(R.id.edt_author);
        edtTitle=(EditText) findViewById(R.id.edt_title);
        edtYear=(EditText) findViewById(R.id.edt_year);
        edtKeywords= (EditText) findViewById(R.id.edt_keywords);
        addBook= (Button) findViewById(R.id.btn_addBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author= edtAuthor.getText().toString();
                String title= edtTitle.getText().toString();
                String year=edtYear.getText().toString() ;
                String keywords= edtKeywords.getText().toString();

                BookObject book= new BookObject();
                book.setAuthor(author);
                book.setTitle(title);
                book.setYear(year);
                book.setKeywords(keywords);

               HomeActivity.booksDatabase.booksDao().addBook(book);
                Toast.makeText(AddBookAcivity.this, book.getTitle()+" беше добавена към библиотеката", Toast.LENGTH_LONG).show();

            }
        });
    }

}
