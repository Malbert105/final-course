package com.example.finalcourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAllBooks, buttonCurrentlyReading, buttonAlreadyRead ,buttonWishList ,buttonFavBooks ,buttonAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
        buttonAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent (MainActivity.this, AlreadyReadBookActivity.class);
            startActivity(intent);
            }
        });
        buttonCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, CurrentlyReadingBooksActivity.class);
                startActivity(intent);
            }
        });
        buttonWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, WantToReadBooksActivity.class);
                startActivity(intent);
            }
        });
        buttonFavBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, FavoriteBooksActivity.class);
                startActivity(intent);
            }
        });


        Utils.getInstance();
    }

    private void initViews(){

        buttonAllBooks = findViewById(R.id.buttonAllBooks);
        buttonCurrentlyReading = findViewById(R.id.buttonCurrentlyReading);
        buttonAlreadyRead = findViewById(R.id.buttonAlreadyRead);
        buttonWishList = findViewById(R.id.buttonWishList);
        buttonFavBooks = findViewById(R.id.buttonFavBooks);
        buttonAbout = findViewById(R.id.buttonAbout);

    }

}