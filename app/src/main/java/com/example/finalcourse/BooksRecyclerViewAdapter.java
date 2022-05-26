package com.example.finalcourse;

import static com.example.finalcourse.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecyclerViewAdapter  extends  RecyclerView.Adapter<BooksRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "BookRecyclerView";

    private ArrayList <Book> books = new ArrayList<>();
    private Context mcontext ;


    public BooksRecyclerViewAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG,"onBindViewHolder: Called ");
        holder.textBookName.setText(books.get(position).getName());
        Glide.with(mcontext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imageBook);


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
                mcontext.startActivity(intent);
            }
        });
            holder.textAuthorName.setText(books.get(position).getAuthor());
            holder.textDescription.setText(books.get(position).getShortDescription());

        if (books.get(position).getExpanded()) {

            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelativeLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else
        {
            TransitionManager.beginDelayedTransition(holder.parent);

            holder.expandedRelativeLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public int getItemCount() {
        return books.size();

    }


    public void setBooks(ArrayList<Book> books) {
        this.books = books;

        notifyDataSetChanged();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
            private CardView parent ;
            private ImageView imageBook, downArrow,upArrow;
            private TextView textBookName,authorText,textDescription,textAuthorName;
            private RelativeLayout expandedRelativeLayout;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        parent = itemView.findViewById(R.id.parent);
        imageBook = itemView.findViewById(R.id.imageBook);
        textBookName = itemView.findViewById(R.id.textBookName);
        authorText = itemView.findViewById(R.id.authorText);
        textAuthorName = itemView.findViewById(R.id.textAuthorName);
        textDescription = itemView.findViewById(R.id.textDescription);
        downArrow = itemView.findViewById(R.id.buttonDownArrow);
        upArrow = itemView.findViewById(R.id.buttonUpArrow);
        expandedRelativeLayout= itemView.findViewById(R.id.expandedRelativeLayout);


        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = books.get(getAdapterPosition());
                book.setExpanded(!book.getExpanded());
                notifyItemChanged(getAdapterPosition());
            }
        });

        upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = books.get(getAdapterPosition());
                book.setExpanded(!book.getExpanded());
                notifyItemChanged(getAdapterPosition());

            }
        });
    }
}

}
