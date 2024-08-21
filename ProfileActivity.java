package com.example.qrstaff;


// ProfileActivity.java

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvUserName, tvUserId, tvDesignation, tvPhoneNumber;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




    }
}
