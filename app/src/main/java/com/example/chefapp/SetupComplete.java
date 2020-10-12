package com.example.chefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.widget.TextView;

public class SetupComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_complete);

        final int SPLASH_SCREEN_DISPLAY_LENGTH=4000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent mainIntent=new Intent(SetupComplete.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        },SPLASH_SCREEN_DISPLAY_LENGTH);
    }
}