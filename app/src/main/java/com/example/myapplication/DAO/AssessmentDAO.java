package com.example.myapplication.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.Entity.Assessment;

import java.util.List;

@Dao
public interface AssessmentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAssessment(Assessment assessment);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllAssessments(List<Assessment> assessments);

    @Delete
    void deleteAssessment(Assessment assessment);

    @Query("SELECT COUNT(*) FROM assessments")
    int getAssessmentCount();

    @Query("SELECT * FROM assessments WHERE assessmentID = :assessmentID")
    Assessment getAssessmentByID(int assessmentID);

    @Query("SELECT * FROM assessments WHERE courseID = :courseID")
    LiveData<List<Assessment>> getAssessmentByCourse(int courseID);

    @Query("DELETE FROM assessments")
    int deleteAllAssessments();

    @Query("SELECT COUNT(*) FROM assessments WHERE courseID = :courseID")
    int getAssessmentCountByCourse(int courseID);

    @Query("SELECT COUNT(*) FROM assessments WHERE courseID IS NOT NULL")
    int getAssessmentCountByAnyCourse();

}
