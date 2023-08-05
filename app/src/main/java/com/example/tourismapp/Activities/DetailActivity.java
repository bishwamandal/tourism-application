package com.example.tourismapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tourismapp.Domains.PopularDomain;
import com.example.tourismapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class DetailActivity extends AppCompatActivity {

    private TextView placeTxt, locationTxt, favTxt, descriptionTxt;
    private PopularDomain item;
    private ImageView placeImage;
    private MaterialToolbar backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        placeTxt.setText(item.getTitle());
        locationTxt.setText(item.getLocation());
        descriptionTxt.setText(item.getDescription());

        int drawableResId = getResources().getIdentifier(item.getPic(),
                "drawable", getPackageName());

        Glide.with(this)
                .load(drawableResId)
                .into(placeImage);
    }

    private void initView() {

        placeTxt = findViewById(R.id.detailed_placename);
        locationTxt = findViewById(R.id.detailed_location);
        favTxt = findViewById(R.id.detailed_fav);
        descriptionTxt = findViewById(R.id.placeDescription);
        placeImage = findViewById(R.id.detailed_placeImage);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}