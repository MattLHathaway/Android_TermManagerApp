package com.example.myapplication.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.Entity.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllNotes(List<Note> notes);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM notes WHERE noteID = :noteID")
    Note getNoteByID(int noteID);

    @Query("SELECT * FROM notes ORDER BY noteTitle DESC")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT * FROM notes WHERE assessmentID = :assessmentID")
    LiveData<List<Note>> getNoteByAssessment(int assessmentID);

    @Query("DELETE FROM notes")
    int deleteAllNotes();

    @Query("SELECT COUNT(*) FROM notes WHERE assessmentID = :assessmentID")
    int getNoteCountByAssessment(int assessmentID);

    @Query("SELECT COUNT(*) FROM notes")
    int getNoteCount();

    @Query("SELECT COUNT(*) FROM notes WHERE assessmentID IS NOT NULL")
    int getNoteCountByAnyAssessment();
}
