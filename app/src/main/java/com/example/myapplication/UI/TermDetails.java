package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.Adapters.CourseAdapter;
import com.example.myapplication.Adapters.TermAdapter;
import com.example.myapplication.DAO.TermDAO;
import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Term;
import com.example.myapplication.R;
import com.example.myapplication.Repositories.CourseRepository;
import com.example.myapplication.Repositories.TermRepository;

import java.util.List;

public class TermDetails extends AppCompatActivity {

    EditText editTextTermTitle;
    EditText editTextStartDate;
    EditText editTextEndDate;
    String termName;
    String termStartDate;
    String termEndDate;
    int termID;
    TermRepository termRepo;
    CourseRepository courseRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Grabbing the fields from the activity and placing them in variables
        editTextTermTitle = findViewById(R.id.editTextTermTitle);
        editTextStartDate = findViewById(R.id.editTextStartDate);
        editTextEndDate = findViewById(R.id.editTextEndDate);
        //Default Value -1 is how we know if it's a new Term.  The names come from the TermsAdapter file
        termID = getIntent().getIntExtra("id", -1);
        termName = getIntent().getStringExtra("name");
        termStartDate = getIntent().getStringExtra("startDate");
        termEndDate = getIntent().getStringExtra("endDate");
        //Pulls info from Adapter and sets it into the text fields
        editTextTermTitle.setText(termName);
        editTextStartDate.setText(termStartDate);
        editTextEndDate.setText(termEndDate);

        //Setting our RecyclerView and grabbing the list of courses
        RecyclerView recyclerView = findViewById(R.id.recViewCoursesInTermDetails);
        CourseRepository courseRepo = new CourseRepository(getApplication());
        //List<Course> courses = courseRepo.getCoursesByTermID(termID);
        List<Course> courses = courseRepo.getAllCourses();
        System.out.println("courses=");
        System.out.println(courses);

        //Setting the Adapter for the RecyclerView
        final CourseAdapter adapter = new CourseAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCourses(courses);

        //Making the Repository
//        repo = new Repository(getApplication());
        //courseRepo = new CourseRepository(getApplication());
    }

    //SAVES MODIFIED TERM TO DB, OR ADDS NEW ONE IF THE ID IS -1!
    public void saveButton(View view) {
        Term term;
        termRepo = new TermRepository(getApplication());
        if (termID == -1) {
            int newID = termRepo.getANewTermID();
            term = new Term(newID, editTextTermTitle.getText().toString(), editTextStartDate.getText().toString(), editTextEndDate.getText().toString());
            termRepo.insert(term);
        } else {
            term = new Term(termID, editTextTermTitle.getText().toString(), editTextStartDate.getText().toString(), editTextEndDate.getText().toString());
            termRepo.update(term);
        }
        startActivity(new Intent(TermDetails.this, MainActivity.class));
//         this.finish();
    }

    public void deleteButton(View view) {
        termRepo = new TermRepository(getApplication());
        Term termToDelete;
        if (termID == -1) {
            editTextTermTitle.setText("");
            editTextStartDate.setText("");
            editTextEndDate.setText("");
        } else {
            termToDelete = new Term(termID, editTextTermTitle.getText().toString(), editTextStartDate.getText().toString(), editTextEndDate.getText().toString());
            termRepo.delete(termToDelete);
        }
        startActivity(new Intent(TermDetails.this, MainActivity.class));
//        this.finish();
    }


}