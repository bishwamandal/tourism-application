package com.example.tourismapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tourismapp.Class.NewPlaces;
import com.example.tourismapp.R;
import com.example.tourismapp.databinding.ActivityMainBinding;
import com.example.tourismapp.databinding.ActivityNewPlaceBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewPlaceActivity extends AppCompatActivity {

    ActivityNewPlaceBinding binding;
    Uri imageUri;
    String destination_name, location, description;
    FirebaseDatabase db;
    DatabaseReference reference;
    StorageReference storageReference;
    ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewPlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.newplacesToolbar.setNavigationOnClickListener(view -> finish());

        binding.selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destination_name = binding.newDestination.getText().toString();
                location = binding.newLocation.getText().toString();
                description = binding.newDescription.getText().toString();
                uploadImage();

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

    private void uploadImage() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading File ... ");
        progressDialog.show();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String filename = formatter.format(now);

        storageReference = FirebaseStorage.getInstance().getReference("images/"+filename);
        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                binding.uploadImage.setImageURI(null);
                Toast.makeText(NewPlaceActivity.this, "Successfully Uploaded", Toast.LENGTH_SHORT).show();

                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewPlaceActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                    }
                });
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data != null && data.getData() != null) {
            imageUri = data.getData();
            binding.uploadImage.setImageURI(imageUri);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}