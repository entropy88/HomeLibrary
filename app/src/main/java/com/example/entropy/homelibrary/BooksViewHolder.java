package com.example.entropy.homelibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

class BooksViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;
    TextView mAuthor;
    TextView mYear;
    TextView mKeywords;
    Button moreButton;

    public BooksViewHolder(View itemView) {
        super(itemView);

        mTitle= (TextView)itemView.findViewById(R.id.tv_title);
        mAuthor= (TextView) itemView.findViewById(R.id.tv_author);
        mYear=(TextView) itemView.findViewById(R.id.tv_year);
        mKeywords= (TextView)itemView.findViewById(R.id.tv_keywords);
       moreButton=(Button)itemView.findViewById(R.id.more_button);

    }
}
