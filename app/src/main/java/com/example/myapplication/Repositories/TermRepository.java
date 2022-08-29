package com.example.myapplication.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Insert;

import com.example.myapplication.DAO.TermDAO;
import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TermRepository {

    public int newTermID;

    private TermDAO termDAO;
    private List<Term> allTerms;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public TermRepository(Application application) {
        AppDatabase AppDB = AppDatabase.getDatabaseInstance(application);
        termDAO = AppDB.termDAO();
        allTerms = termDAO.getAllTerms();
    }


    public List<Term>getAllTerms(){
        databaseExecutor.execute(()->{
            allTerms = termDAO.getAllTerms();
        });
        //Delay allows time for it to grab stuff from database
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allTerms;
    }

    public void insert(Term term) {

        databaseExecutor.execute(()->{
            termDAO.insertTerm(term);
        });
        //Cause a delay or else function fails before DB is changed.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update(Term term) {

        databaseExecutor.execute(()->{
            termDAO.update(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Term term) {
        databaseExecutor.execute(()->{
            termDAO.delete(term);
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getANewTermID() {
    databaseExecutor.execute(()->{
        newTermID = termDAO.getNewTermID();
    });
        try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return newTermID;
}

}
