package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;
import com.example.myapplication.R;
import com.example.myapplication.Repositories.CourseRepository;
import com.example.myapplication.Repositories.TermRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void termButtonClicked(View view) {
        startActivity(new Intent(MainActivity.this, TermList.class));

        //addDummyData();
    }

    public void addDummyData() {
        //Inserting 2 Terms
        TermRepository termRepo = new TermRepository(getApplication());
        Term term = new Term(1, "Term 1", "11/01/2022", "11/11/2022");
        Term term2 = new Term(2, "Term 2", "22/01/2024", "22/01/2024");
        termRepo.insert(term);
        termRepo.insert(term2);
        //Inserting a course
        CourseRepository courseRepo = new CourseRepository(getApplication());
        Course course1 = new Course(1,
                "Course 1",
                "11/01/2022",
                "11/10/2022",
                "In-Progress", // In-Progress, Completed, Dropped, Plan-To-Take
                "John Smith",
                "817-456-7890",
                "johnsmith@mail.com",
                1);
        courseRepo.insert(course1);

    }

    public void assessmentButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AssessmentList.class);
        startActivity(intent);
    }

    public void courseButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, CourseList.class);
        startActivity(intent);
    }
}