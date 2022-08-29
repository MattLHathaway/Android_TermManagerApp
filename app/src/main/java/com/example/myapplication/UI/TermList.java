package com.example.myapplication.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Adapters.TermAdapter;
import com.example.myapplication.Entity.Term;
import com.example.myapplication.R;
import com.example.myapplication.Repositories.TermRepository;
import com.example.myapplication.ViewModels.TermListViewModel;

import java.util.List;

public class TermList extends AppCompatActivity {

    public static final int ADD_TERM_REQUEST = 1;
    public static final int EDIT_TERM_REQUEST = 2;
    private TermListViewModel termViewModel;
    private int numCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Selecting our Recyclerview by name (from the activity_term_list.xml)
        RecyclerView recyclerView = findViewById(R.id.termRecyclerView2);
        TermRepository repo = new TermRepository(getApplication());
        List<Term> terms = repo.getAllTerms();
        // Store adapter in a variable
        final TermAdapter adapter = new TermAdapter(this);
        //Tell the recycler view which adapter to use
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setTerms(terms);
    }


    //ADDS THE MENU
    public boolean onCreateOptionsMenu (Menu menu){
        //Inflate the menu; This adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_courselist, menu);
        return true;
    }

    //THIS ALLOWS THIS.FINISH() TO TAKE US HOME
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addTermClicked(View view) {
        Intent intent = new Intent(TermList.this, TermDetails.class);
        startActivity(intent);
    }
}