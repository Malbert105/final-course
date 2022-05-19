package com.example.finalcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonAllBooks, buttonCurrentlyReading, buttonAlreadyRead ,buttonWishList ,buttonFavBooks ,buttonAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

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