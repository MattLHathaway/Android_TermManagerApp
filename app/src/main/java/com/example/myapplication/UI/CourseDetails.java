package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.Adapters.CourseAdapter;
import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;
import com.example.myapplication.R;
import com.example.myapplication.Repositories.CourseRepository;
import com.example.myapplication.Repositories.TermRepository;

import java.util.List;

public class CourseDetails extends AppCompatActivity {

    EditText editTextCourseName;
    EditText editTextCourseStartDate;
    EditText editTextCourseEndDate;
    EditText editTextCourseStatus;
    EditText editTextCourseInstructorName;
    EditText editTextCourseInstructorPhone;
    EditText editTextCourseInstructorEmail;
    String courseName;
    String courseStartDate;
    String courseEndDate;
    String courseStatus;
    String instructorName;
    String instructorPhone;
    String instructorEmail;
    int termID;
    int courseID;
    TermRepository termRepo;
    CourseRepository courseRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Grabbing the fields from the activity and placing them in variables
        editTextCourseName = findViewById(R.id.editTextCourseName);
        editTextCourseStartDate = findViewById(R.id.editTextCourseStartDate);
        editTextCourseEndDate = findViewById(R.id.editTextCourseEndDate);
        editTextCourseStatus = findViewById(R.id.editTextCourseStatus);
        editTextCourseInstructorName = findViewById(R.id.editTextCourseInstructorName);
        editTextCourseInstructorPhone = findViewById(R.id.editTextCourseInstructorPhone);
        editTextCourseInstructorEmail = findViewById(R.id.editTextCourseInstructorEmail);

        //Default Value -1 is how we know if it's a new Term.  The names come from the TermsAdapter file
        courseID = getIntent().getIntExtra("courseID", -1);
        courseName = getIntent().getStringExtra("courseName");
        courseStartDate = getIntent().getStringExtra("courseStartDate");
        courseEndDate = getIntent().getStringExtra("courseEndDate");
        courseStatus = getIntent().getStringExtra("courseStatus");
        instructorName = getIntent().getStringExtra("instructorName");
        instructorPhone = getIntent().getStringExtra("instructorPhone");
        instructorEmail = getIntent().getStringExtra("instructorEmail");
        termID = getIntent().getIntExtra("termID", -1);
        //Pulls info from Adapter and sets it into the text fields
        editTextCourseName.setText(courseName);
        editTextCourseStartDate.setText(courseStartDate);
        editTextCourseEndDate.setText(courseEndDate);
        editTextCourseStatus.setText(courseStatus);
        editTextCourseInstructorName.setText(instructorName);
        editTextCourseInstructorPhone.setText(instructorPhone);
        editTextCourseInstructorEmail.setText(instructorEmail);


        //Setting our RecyclerView and grabbing the list of courses
        RecyclerView recyclerView = findViewById(R.id.recViewAssessmentsInCourseDetails);
        CourseRepository courseRepo = new CourseRepository(getApplication());
        //List<Course> courses = courseRepo.getCoursesByTermID(termID);
        List<Course> courses = courseRepo.getAllCourses();

        //Setting the Adapter for the RecyclerView
        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCourses(courses);

        //Making the Repository
//        repo = new Repository(getApplication());
        //courseRepo = new CourseRepository(getApplication());
    }

}
