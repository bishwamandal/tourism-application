package com.example.tourismapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.tourismapp.R;

public class ProfileActivity extends AppCompatActivity {

    EditText fullname, email, phonenumber, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullname = findViewById(R.id.profile_fullname);
        phonenumber = findViewById(R.id.profile_phone);
        email = findViewById(R.id.profile_email);
        password = findViewById(R.id.profile_pass);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}