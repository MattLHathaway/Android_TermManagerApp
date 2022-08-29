package com.example.myapplication.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import com.example.myapplication.DAO.CourseDAO;
import com.example.myapplication.DAO.TermDAO;
import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourseRepository {
    private CourseDAO courseDAO;
    private List<Course> allCourses;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public CourseRepository(Application application) {
        AppDatabase AppDB = AppDatabase.getDatabaseInstance(application);
        courseDAO = AppDB.courseDAO();
        allCourses = courseDAO.getAllCourses();
    }


    public List<Course>getAllCourses(){
        databaseExecutor.execute(()->{
            allCourses = courseDAO.getAllCourses();
        });
        //Delay allows time for it to grab stuff from database
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allCourses;
    }

    public void insert(Course course) {

        databaseExecutor.execute(()->{
            courseDAO.insertCourse(course);
        });
        //Cause a delay or else function fails before DB is changed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Course course) {

        databaseExecutor.execute(()->{
            courseDAO.update(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Course course) {
        databaseExecutor.execute(()->{
            courseDAO.deleteCourse(course);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
