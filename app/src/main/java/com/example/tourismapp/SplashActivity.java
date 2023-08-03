package com.example.tourismapp;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    MaterialCardView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.iconCard);

        new Handler().postDelayed(() -> {
            Intent splash = new Intent(SplashActivity.this, LoginActivity.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(image, "logo_image");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation (
                    SplashActivity.this, pairs);
            startActivity(splash, options.toBundle());
        }, 2000);
    }
}