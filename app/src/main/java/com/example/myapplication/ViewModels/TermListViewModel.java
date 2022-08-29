package com.example.myapplication.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Entity.Term;
import com.example.myapplication.Repositories.TermRepository;

import java.util.List;

public class TermListViewModel extends AndroidViewModel {

    private TermRepository repo;
    private List<Term> allTerms;

    public TermListViewModel(@NonNull Application application) {
        super(application);
        repo = new TermRepository(application);
        allTerms = repo.getAllTerms();
    }

}
