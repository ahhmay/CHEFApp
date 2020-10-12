package com.example.chefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        final int SPLASH_SCREEN_DISPLAY_LENGTH=7000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent mainIntent=new Intent(LoadingScreen.this, SetupComplete.class);
                startActivity(mainIntent);
                finish();
            }
        },SPLASH_SCREEN_DISPLAY_LENGTH);
    }
}