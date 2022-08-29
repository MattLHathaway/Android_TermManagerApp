package com.example.myapplication.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentors",
        foreignKeys = @ForeignKey(entity = Course.class,
                parentColumns = "courseID",
                childColumns = "courseID", onDelete = ForeignKey.CASCADE))
public class Mentor {

    @PrimaryKey(autoGenerate = true)
    private int mentorID;

    private String mentorName;
    private String mentorPhone;
    private String mentorEmail;
    private int courseID;

    //Full Constructor
    public Mentor(int mentorID, String mentorName, String mentorPhone, String mentorEmail, int courseID) {
        this.mentorID = mentorID;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
        this.courseID = courseID;
    }

    //Constructor without mentorID because it is Auto Generated
    @Ignore
    public Mentor(String mentorName, String mentorPhone, String mentorEmail, int courseID) {
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
        this.courseID = courseID;
    }

    //Getters & Setters

    public int getMentorID() {
        return mentorID;
    }

    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorPhone() {
        return mentorPhone;
    }

    public void setMentorPhone(String mentorPhone) {
        this.mentorPhone = mentorPhone;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
