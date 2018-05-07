package com.example.entropy.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SingleBookActvity extends AppCompatActivity {
    TextView tvBookAuth;
    TextView tvBookTitle;
    TextView tvBookYear;
    TextView tvBookKeywords;

    Button btnDelete;
    Button btnBackToAllBooks;
    Button btnEnableUpdating;
    Button btnUpdate;

    EditText edtAuthor;
    EditText edtTitle;
    EditText edtYear;
    EditText edtKeywords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_book_actvity);
        tvBookAuth=(TextView) findViewById(R.id.tv_book_auth);
        tvBookTitle=(TextView) findViewById(R.id.tv_book_title);
        tvBookYear=(TextView) findViewById(R.id.tv_book_year);
        tvBookKeywords=(TextView) findViewById(R.id.tv_book_keywords);

        btnDelete=(Button) findViewById(R.id.btn_delete);
        btnBackToAllBooks=(Button) findViewById(R.id.btn_backToAllBooks);
        btnEnableUpdating=(Button) findViewById(R.id.btn_enableUpdating);
        btnUpdate=(Button) findViewById(R.id.btn_updateRecord) ;

        edtAuthor = (EditText) findViewById(R.id.edt_author);
        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtYear = (EditText) findViewById(R.id.edt_year);
        edtKeywords = (EditText) findViewById(R.id.edt_keywords);


        Intent intent= getIntent();
        final int bookId= (intent.getIntExtra("id", 0)) ;
        final BookObject bookSelected= HomeActivity.booksDatabase.booksDao().selectBook(bookId);

        tvBookAuth.setText( bookSelected.getAuthor());
        tvBookTitle.setText( bookSelected.getTitle());
        tvBookYear.setText( bookSelected.getYear());
        tvBookKeywords.setText( bookSelected.getKeywords());


        edtAuthor.setText(bookSelected.getAuthor());
        edtTitle.setText(bookSelected.getTitle());
        edtKeywords.setText(bookSelected.getKeywords());
        edtYear.setText(bookSelected.getYear());

        btnEnableUpdating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               edtAuthor.setEnabled(true);
               edtTitle.setEnabled(true);
               edtKeywords.setEnabled(true);
               edtYear.setEnabled(true);
               btnUpdate.setEnabled(true);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //adjust ui here, make labels etc invisible
                HomeActivity.booksDatabase.booksDao().deleteBook(bookId);
                btnDelete.setClickable(false);
                edtAuthor.setVisibility(View.INVISIBLE);
                edtTitle.setVisibility(View.INVISIBLE);
                edtKeywords.setVisibility(View.INVISIBLE);
                edtYear.setVisibility(View.INVISIBLE);
                btnUpdate.setVisibility(View.INVISIBLE);
                Toast.makeText(SingleBookActvity.this, bookSelected.getTitle()+" беше изтрита",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnBackToAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack= new Intent (SingleBookActvity.this, AllBooksActivity.class);
                startActivity(intentBack);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String authorStr=edtAuthor.getText().toString();
                String titleStr=edtTitle.getText().toString();
                String keywordsStr=edtKeywords.getText().toString();
                String yearStr= edtYear.getText().toString();
                HomeActivity.booksDatabase.booksDao().update(authorStr,titleStr,keywordsStr,yearStr, bookId);
                tvBookAuth.setText( bookSelected.getAuthor());
                tvBookTitle.setText( bookSelected.getTitle());
                tvBookYear.setText( bookSelected.getYear());
                tvBookKeywords.setText( bookSelected.getKeywords());

                Toast.makeText(SingleBookActvity.this, bookSelected.getTitle()+" беше редактирана",
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
