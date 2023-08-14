package com.example.tourismapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.tourismapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class UserActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        toolbar = findViewById(R.id.user_toolbar);

        toolbar.setNavigationOnClickListener(view -> finish());
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}