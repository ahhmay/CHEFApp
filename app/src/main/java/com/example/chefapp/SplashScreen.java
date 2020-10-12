package com.example.chefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final int SPLASH_SCREEN_DISPLAY_LENGTH=2000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent mainIntent=new Intent(SplashScreen.this, RegisterActivity.class);
                startActivity(mainIntent);
                finish();
            }
        },SPLASH_SCREEN_DISPLAY_LENGTH);
    }
}