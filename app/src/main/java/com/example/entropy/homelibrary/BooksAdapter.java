package com.example.entropy.homelibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {
    private List<BookObject> data;

    public BooksAdapter(List<BookObject> data) {
        this.data = data;
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout,parent,false);
        BooksViewHolder viewHolder= new BooksViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BooksViewHolder holder, int position) {

        final BookObject item=data.get(position);
        holder.mId.setText(String.valueOf(item.getId()));
        holder.mTitle.setText(item.getTitle());
        holder.mAuthor.setText(item.getAuthor());
        holder.mYear.setText(item.getYear());
        holder.mKeywords.setText(item.getKeywords());

        //delete book. must move it to another screen
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int thisId=item.getId();
                HomeActivity.booksDatabase.booksDao().deleteBook(thisId);


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
