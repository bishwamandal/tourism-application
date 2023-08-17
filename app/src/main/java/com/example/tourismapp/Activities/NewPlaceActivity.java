package com.example.tourismapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tourismapp.Class.NewPlaces;
import com.example.tourismapp.R;
import com.example.tourismapp.databinding.ActivityMainBinding;
import com.example.tourismapp.databinding.ActivityNewPlaceBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewPlaceActivity extends AppCompatActivity {

    ActivityNewPlaceBinding binding;
    String destination_name, location, description;
    FirebaseDatabase db;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.newplacesToolbar.setNavigationOnClickListener(view -> finish());

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destination_name = binding.newDestination.getText().toString();
                location = binding.newLocation.getText().toString();
                description = binding.newDescription.getText().toString();

                if (!destination_name.isEmpty() && !location.isEmpty() && !description.isEmpty()) {
                    NewPlaces places = new NewPlaces(destination_name, location, description);
                    db = FirebaseDatabase.getInstance();
                    reference = db.getReference("NewPlaces");
                    reference.child(destination_name).setValue(places).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.newDestination.setText("");
                            binding.newLocation.setText("");
                            binding.newDescription.setText("");

                            Toast.makeText(NewPlaceActivity.this, "Successfully Added!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}