package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ViewBookActivity extends AppCompatActivity {

    private Button buttonViewBook1, buttonViewBook2;
    private ImageView imageView;
    private FirebaseAuth mAuth;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        buttonViewBook1 = findViewById(R.id.buttonViewBook1);
        buttonViewBook2 = findViewById(R.id.buttonViewBook2);
        imageView = findViewById(R.id.pdfView);
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();

        buttonViewBook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewBook("");
            }
        });

        buttonViewBook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    // Assuming the user should not have access to the second book
                    Toast.makeText(ViewBookActivity.this, "You do not have access to this book", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewBook(String bookName) {
        StorageReference storageRef = storage.getReference().child(bookName);
        storageRef.getBytes(Long.MAX_VALUE).addOnSuccessListener(bytes -> {

        }).addOnFailureListener(exception -> {
            Toast.makeText(ViewBookActivity.this, "Failed to load book", Toast.LENGTH_SHORT).show();
        });
    }
}