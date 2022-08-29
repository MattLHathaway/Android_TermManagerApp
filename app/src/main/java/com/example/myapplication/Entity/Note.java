package com.example.myapplication.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes",
        foreignKeys = @ForeignKey(entity = Assessment.class,
                parentColumns = "assessmentID",
                childColumns = "assessmentID", onDelete = ForeignKey.CASCADE))
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int noteID;

    private String noteTitle;
    private String noteText;
    private int assessmentID;

    //Full Constructor
    public Note(int noteID, String noteTitle, String noteText, int assessmentID) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.assessmentID = assessmentID;
    }

    //Constructor without noteID as it is auto generated
    @Ignore
    public Note(String noteTitle, String noteText, int assessmentID) {
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.assessmentID = assessmentID;
    }

    //Getters & Setters

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }
}
