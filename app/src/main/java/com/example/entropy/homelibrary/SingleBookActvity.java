package com.example.entropy.homelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SingleBookActvity extends AppCompatActivity {
    ImageButton backArrow;
    TextView tvBookAuth;
    TextView tvBookTitle;
    TextView tvBookYear;
    TextView tvBookKeywords;

    TextView authorLabel;
    TextView titleLabel;
    TextView yearLabel;
    TextView keywordsLabel;


    Button btnDelete;
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
        tvBookAuth = (TextView) findViewById(R.id.tv_book_auth);
        backArrow = (ImageButton) findViewById(R.id.btn_back);
        tvBookTitle = (TextView) findViewById(R.id.tv_book_title);
        tvBookYear = (TextView) findViewById(R.id.tv_book_year);
        tvBookKeywords = (TextView) findViewById(R.id.tv_book_keywords);

        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnEnableUpdating = (Button) findViewById(R.id.btn_enableUpdating);
        btnUpdate = (Button) findViewById(R.id.btn_updateRecord);


        authorLabel = (TextView) findViewById(R.id.author_label);
        titleLabel = (TextView) findViewById(R.id.title_label);
        keywordsLabel = (TextView) findViewById(R.id.keywords_label);
        yearLabel = (TextView) findViewById(R.id.year_label);

        edtAuthor = (EditText) findViewById(R.id.edt_author);
        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtYear = (EditText) findViewById(R.id.edt_year);
        edtKeywords = (EditText) findViewById(R.id.edt_keywords);


        Intent intent = getIntent();
        final int bookId = (intent.getIntExtra("id", 0));
        final BookObject bookSelected = HomeActivity.booksDatabase.booksDao().selectBook(bookId);

        tvBookAuth.setText(bookSelected.getAuthor());
        tvBookTitle.setText(bookSelected.getTitle());
        tvBookYear.setText(bookSelected.getYear());
        tvBookKeywords.setText(bookSelected.getKeywords());


        edtAuthor.setText(bookSelected.getAuthor());
        edtTitle.setText(bookSelected.getTitle());
        edtKeywords.setText(bookSelected.getKeywords());
        edtYear.setText(bookSelected.getYear());

        btnEnableUpdating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authorLabel.setVisibility(View.VISIBLE);
                titleLabel.setVisibility(View.VISIBLE);
                keywordsLabel.setVisibility(View.VISIBLE);
                yearLabel.setVisibility(View.VISIBLE);


                edtAuthor.setEnabled(true);
                edtAuthor.setVisibility(View.VISIBLE);
                edtTitle.setEnabled(true);
                edtTitle.setVisibility(View.VISIBLE);
                edtKeywords.setEnabled(true);
                edtKeywords.setVisibility(View.VISIBLE);
                edtYear.setEnabled(true);
                edtYear.setVisibility(View.VISIBLE);
                btnUpdate.setEnabled(true);
                btnUpdate.setVisibility(View.VISIBLE);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //adjust ui here, make labels etc invisible
                HomeActivity.booksDatabase.booksDao().deleteBook(bookId);
                btnEnableUpdating.setVisibility(View.INVISIBLE);
                btnDelete.setClickable(false);
                btnDelete.setVisibility(View.INVISIBLE);
                authorLabel.setVisibility(View.INVISIBLE);
                titleLabel.setVisibility(View.INVISIBLE);
                keywordsLabel.setVisibility(View.INVISIBLE);
                yearLabel.setVisibility(View.INVISIBLE);
                edtAuthor.setVisibility(View.INVISIBLE);
                edtTitle.setVisibility(View.INVISIBLE);
                edtKeywords.setVisibility(View.INVISIBLE);
                edtYear.setVisibility(View.INVISIBLE);
                btnUpdate.setVisibility(View.INVISIBLE);
                tvBookAuth.setText(bookSelected.getTitle() + " беше изтрита!");
                tvBookTitle.setText("");
                tvBookYear.setText("");
                tvBookKeywords.setText("");
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(SingleBookActvity.this, AllBooksActivity.class);
                startActivity(back);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String authorStr = edtAuthor.getText().toString();
                String titleStr = edtTitle.getText().toString();
                String keywordsStr = edtKeywords.getText().toString();
                String yearStr = edtYear.getText().toString();
                HomeActivity.booksDatabase.booksDao().update(authorStr, titleStr, keywordsStr, yearStr, bookId);
                tvBookAuth.setText(bookSelected.getAuthor());
                tvBookTitle.setText(bookSelected.getTitle());
                tvBookYear.setText(bookSelected.getYear());
                tvBookKeywords.setText(bookSelected.getKeywords());

                Toast.makeText(SingleBookActvity.this, bookSelected.getTitle() + " беше редактирана",
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
