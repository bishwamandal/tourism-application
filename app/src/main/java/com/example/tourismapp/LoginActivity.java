package com.example.tourismapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText n, p;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        n = findViewById(R.id.phone);
        p = findViewById(R.id.password);
        b = findViewById(R.id.loginButton);

        login();
    }

    public void login() {
        b.setOnClickListener(view -> {
            if (n.getText().toString().equals("8822508004") && p.getText().toString().equals("admin")) {
                Intent login = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(login);
            } else {
                Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Deprecated
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}