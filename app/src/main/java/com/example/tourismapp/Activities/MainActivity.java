package com.example.tourismapp.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.Adapters.PopularAdapter;
import com.example.tourismapp.Domains.PopularDomain;
import com.example.tourismapp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Place Name","Full Location Address", "pic1"));
        items.add(new PopularDomain("Place Name","Full Location Address", "pic2"));
        items.add(new PopularDomain("Place Name","Full Location Address", "pic3"));
        items.add(new PopularDomain("Place Name","Full Location Address", "pic4"));

        recyclerView = findViewById(R.id.view_pop);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterPopular = new PopularAdapter(items);
        recyclerView.setAdapter(adapterPopular);
    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Exit App")
                .setMessage("Do you want to exit the app?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finishAffinity())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }
}