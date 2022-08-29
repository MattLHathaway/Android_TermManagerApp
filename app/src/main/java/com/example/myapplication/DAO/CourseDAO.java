package com.example.myapplication.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;

import java.util.List;

@Dao
public interface CourseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourse(Course course);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCourses(List<Course> courses);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Course course);

    @Delete
    void deleteCourse(Course course);
    
    @Query("SELECT * FROM courses WHERE courseID = :courseID")
    Course getCourseByID(int courseID);

    @Query("SELECT * FROM courses WHERE termID = :termID")
    List<Course> getCoursesByTerm(int termID);

    @Query("SELECT * FROM courses ORDER BY courseStartDate DESC")
    List<Course> getAllCourses();

    @Query("DELETE FROM courses")
    int deleteAllCourses();

    @Query("SELECT COUNT(*) FROM courses")
    int getCourseCount();

}
