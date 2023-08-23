package com.example.tourismapp.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.Adapters.PopularAdapter;
import com.example.tourismapp.Domains.PopularDomain;
import com.example.tourismapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        FloatingActionButton addbtn = findViewById(R.id.addNewPlaces);
        addbtn.setOnClickListener(view -> {
            Intent intent = new Intent(PlacesActivity.this, NewPlaceActivity.class);
            startActivity(intent);
        });

        MaterialToolbar back = findViewById(R.id.places_toolbar);
        back.setNavigationOnClickListener(view -> finish());

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain(
                "City Palace","Jaipur, Rajasthan", "ic_jaipur_city_palace", "Historic palace complex with museums, courtyards, and royal artifacts."));
        items.add(new PopularDomain(
                "Hawa Mahal","Jaipur, Rajasthan", "ic_hawa_mahal", "Iconic palace with intricate windows, offering a view of the city"));
        items.add(new PopularDomain(
                "Amber Fort","Jaipur, Rajasthan", "ic_amber_fort", "Majestic hilltop fort with stunning architecture and elephant rides."));
        items.add(new PopularDomain(
                "Jantar Mantar","Jaipur, Rajasthan", "ic_jantar_mantar", "Astronomical observatory with impressive geometric instruments."));
        items.add(new PopularDomain(
                "Lake Palace","Udaipur, Rajasthan", "ic_lake_palace", "Romantic hotel on an island in Lake Pichola, showcasing royal heritage."));
        items.add(new PopularDomain(
                "Fateh Sagar Lake","Udaipur, Rajasthan", "ic_fateh_sagar_lake", "Serene lake for boating and leisurely walks."));
        items.add(new PopularDomain(
                "Mehrangarh Fort","Jodhpur, Rajasthan", "ic_mehrangarh_fort", "Impressive fort offering panoramic views and historical exhibits."));
        items.add(new PopularDomain(
                "Jaswant Thada","Jodhpur, Rajasthan", "ic_jaswant_thada", "White marble memorial with delicate carvings and gardens."));


        recyclerView = findViewById(R.id.view_pop);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapterPopular = new PopularAdapter(items);
        recyclerView.setAdapter(adapterPopular);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}