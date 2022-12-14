package com.example.myapplication.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;
import com.example.myapplication.Repositories.CourseRepository;
import com.example.myapplication.Repositories.TermRepository;

import java.util.List;

public class CourseListViewModel extends AndroidViewModel {

    private CourseRepository repo;
    private List<Course> allCourses;

    public CourseListViewModel(@NonNull Application application) {
        super(application);
        repo = new CourseRepository(application);
        allCourses = repo.getAllCourses();
    }
}
