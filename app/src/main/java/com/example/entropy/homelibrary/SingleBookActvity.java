package com.example.entropy.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SingleBookActvity extends AppCompatActivity {
    TextView tvBookinfo;
    Button btnDelete;
    Button btnBackToAllBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_book_actvity);
        tvBookinfo=(TextView) findViewById(R.id.tv_book_info);
        btnDelete=(Button) findViewById(R.id.btn_delete);
        btnBackToAllBooks=(Button) findViewById(R.id.btn_backToAllBooks);
        Intent intent= getIntent();
        final int bookId= (intent.getIntExtra("id", 0)) ;
        final BookObject bookSelected= HomeActivity.booksDatabase.booksDao().selectBook(bookId);
        tvBookinfo.setText(bookSelected.getTitle()
                +"\n"+bookSelected.getAuthor()+"\n"+bookSelected.getYear()+"\n"+ bookSelected.getKeywords());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.booksDatabase.booksDao().deleteBook(bookId);
                tvBookinfo.setText(bookSelected.getTitle()+" беше изтрита");
                btnDelete.setClickable(false);
            }
        });
        btnBackToAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack= new Intent (SingleBookActvity.this, AllBooksActivity.class);
                startActivity(intentBack);
            }
        });
    }
}
