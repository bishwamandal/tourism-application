package com.example.tourismapp.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.Adapters.PopularAdapter;
import com.example.tourismapp.Domains.PopularDomain;
import com.example.tourismapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar topAppBar;
    TextView seeAll;
    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        seeAll = findViewById(R.id.textView2);
        seeAll.setOnClickListener(view -> {
            Intent allplaces = new Intent(MainActivity.this, PlacesActivity.class);
            startActivity(allplaces);
        });

        topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.toolbar_userprofile) {
                accountProfile();
                return true;
            } else {
                return false;
            }
        });

        initRecyclerView();

    }

    private void accountProfile() {
        Intent account = new Intent(MainActivity.this, UserActivity.class);
        startActivity(account);
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheet_layout);

        LinearLayout home = dialog.findViewById(R.id.LayoutHome);
        LinearLayout places = dialog.findViewById(R.id.LayoutAllPlaces);
        LinearLayout profile = dialog.findViewById(R.id.LayoutProfile);
        LinearLayout logout = dialog.findViewById(R.id.LayoutLogout);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allplaces = new Intent(MainActivity.this, PlacesActivity.class);
                startActivity(allplaces);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userprofile = new Intent(MainActivity.this, UserActivity.class);
                startActivity(userprofile);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogout();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void userLogout() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Do you want to logout?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finishActivity())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }

    private void finishActivity() {
        Intent log_out = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(log_out);
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
        new MaterialAlertDialogBuilder(this)
                .setTitle("Exit App")
                .setMessage("Do you want to exit the app?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finishAffinity())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss())
                .show();
    }
}