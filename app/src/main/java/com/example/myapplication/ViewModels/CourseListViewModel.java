package com.example.myapplication.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Course;

import java.util.List;

public class CourseListViewModel extends AndroidViewModel {

    public CourseListViewModel(@NonNull Application application) {
        super(application);
    }
}
