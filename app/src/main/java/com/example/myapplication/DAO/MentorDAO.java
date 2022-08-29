package com.example.myapplication.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.Entity.Mentor;

import java.util.List;

@Dao
public interface MentorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMentor(Mentor mentor);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllMentors(List<Mentor> mentors);

    @Delete
    void deleteMentor(Mentor mentor);

    @Query("SELECT * FROM mentors WHERE mentorID= :mentorID")
    Mentor getMentorByID(int mentorID);

    @Query("SELECT * FROM mentors WHERE courseID = :courseID")
    LiveData<List<Mentor>> getMentorByCourse(int courseID);

    @Query("SELECT * FROM mentors ORDER BY mentorName DESC")
    LiveData<List<Mentor>> getAllMentors();

    @Query("SELECT COUNT(*) FROM mentors")
    int getMentorCount();

    @Query("DELETE FROM mentors")
    int deleteAllMentors();

    @Query("SELECT COUNT(*) FROM mentors WHERE courseID = :courseID")
    int getMentorCountByCourse(int courseID);

    @Query("SELECT COUNT(*) FROM mentors WHERE courseID IS NOT NULL")
    int getMentorCountByAnyCourse();
}
