package com.example.finalcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView textBookNameIs, textAuthorIs, textPageNumbers, textLongDescription;
    private Button buttonAddToReading, buttonAddToWishList, buttonAddToAlreadyRead, buttonAddtoFav;
    private ImageView bookImageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();


        Intent intent = getIntent();

        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);

            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookByID(bookId);

                if (null != incomingBook) {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToRead(incomingBook);
                    handleCurrentlyReading(incomingBook);
                    handleFavorite(incomingBook);
                }
            }
        }

    }

    private void handleFavorite(final Book book) {
        ArrayList<Book> favoritesBooks = Utils.getInstance().getFavoriteBooks();

        boolean existingFavoriteBooks = false;

        for (Book b : favoritesBooks) {
            if (b.getId() == book.getId()) {
                existingFavoriteBooks = true;
            }
        }
        if (existingFavoriteBooks) {
            buttonAddtoFav.setEnabled(false);
        } else {
            buttonAddtoFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavoriteBooks(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong.. Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReading(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadBooks();

        boolean existingCurrentlyReadingBooks = false;

        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existingCurrentlyReadingBooks = true;
            }
        }
        if (existingCurrentlyReadingBooks) {
            buttonAddToReading.setEnabled(false);
        } else {
            buttonAddToReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong.. Please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

        private void handleWantToRead ( final Book book){
            ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

            boolean existingWantToReadBooks = false;

            for (Book b : wantToReadBooks) {
                if (b.getId() == book.getId()) {
                    existingWantToReadBooks = true;
                }
            }
            if (existingWantToReadBooks) {
                buttonAddToWishList.setEnabled(false);
            } else {
                buttonAddToWishList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Utils.getInstance().addToWantToRead(book)) {
                            Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(BookActivity.this, WantToReadBooksActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(BookActivity.this, "Something went wrong.. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }


        }


        private void handleAlreadyRead (Book book){
            ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

            boolean existingAlreadyReadBooks = false;

            for (Book b : alreadyReadBooks) {
                if (b.getId() == book.getId()) {
                    existingAlreadyReadBooks = true;
                }
            }
            if (existingAlreadyReadBooks) {
                buttonAddToAlreadyRead.setEnabled(false);
            } else {
                buttonAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Utils.getInstance().addToAlreadyRead(book)) {
                            Toast.makeText(BookActivity.this, "Book Added ", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(BookActivity.this, "Something went wrong.. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }

        private void setData (Book book){

            textBookNameIs.setText(book.getName());
            textAuthorIs.setText(book.getAuthor());
            textPageNumbers.setText(String.valueOf(book.getPages()));
            textLongDescription.setText(book.getLongDescription());

            Glide.with(this).asBitmap().load(book.getImageUrl())
                    .into(bookImageLogo);

        }

        private void initView () {
            //textboxes in book activity
            textBookNameIs = findViewById(R.id.textBookNameIs);
            textAuthorIs = findViewById(R.id.textAuthorIs);
            textPageNumbers = findViewById(R.id.textPageNumbers);
            textLongDescription = findViewById(R.id.textLongDescription);
            //button in my book activity
            buttonAddToReading = findViewById(R.id.buttonAddToReading);
            buttonAddToWishList = findViewById(R.id.buttonAddToWishList);
            buttonAddToAlreadyRead = findViewById(R.id.buttonAddToAlreadyRead);
            buttonAddtoFav = findViewById(R.id.buttonAddtoFav);
            //image logo cover
            bookImageLogo = findViewById(R.id.bookImageLogo);


        }

    }
