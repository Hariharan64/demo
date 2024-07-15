package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    private EditText editTextStudentName, editTextPhoneNumber, editTextCourse, editTextBookName;
    private Button buttonSubmit;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextStudentName = findViewById(R.id.editTextStudentName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextCourse = findViewById(R.id.editTextCourse);
        editTextBookName = findViewById(R.id.editTextBookName);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        mDatabase = FirebaseDatabase.getInstance().getReference("registrations");

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String studentName = editTextStudentName.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String course = editTextCourse.getText().toString().trim();
        String bookName = editTextBookName.getText().toString().trim();

        if (studentName.isEmpty() || phoneNumber.isEmpty() || course.isEmpty() || bookName.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String id = mDatabase.push().getKey();
        Registration registration = new Registration(id, studentName, phoneNumber, course, bookName);
        mDatabase.child(id).setValue(registration);

        Intent intent = new Intent(RegisterActivity.this, ViewBookActivity.class);
        intent.putExtra("bookName", bookName);
        startActivity(intent);
    }
    }

