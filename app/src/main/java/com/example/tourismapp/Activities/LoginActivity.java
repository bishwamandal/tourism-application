package com.example.tourismapp.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tourismapp.R;

public class LoginActivity extends AppCompatActivity {

    EditText n, p;
    Button b, f;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        n = findViewById(R.id.phone);
        p = findViewById(R.id.password);
        b = findViewById(R.id.login);
        f = findViewById(R.id.forget);

        f.setOnClickListener(view -> Toast.makeText(LoginActivity.this, "Work Going On :)", Toast.LENGTH_SHORT).show());

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