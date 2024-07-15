package com.example.demo;

public class Registration {
    public String id;
    public String studentName;
    public String phoneNumber;
    public String course;
    public String bookName;

    public Registration() {
        // Default constructor required for calls to DataSnapshot.getValue(Registration.class)
    }

    public Registration(String id, String studentName, String phoneNumber, String course, String bookName) {
        this.id = id;
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.bookName = bookName;
    }
}
