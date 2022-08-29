package com.example.myapplication.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entity.Term;

import java.util.List;

@Dao
public interface TermDAO {

    @Insert
    void insertTerm(Term term);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Term term);

    @Delete
    void delete(Term term);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTerms(List<Term> terms);

    @Delete
    void deleteTerm(Term term);

    @Query("SELECT * FROM terms ORDER BY termStartDate ASC")
    List<Term> getAllTerms();

    @Query("SELECT * FROM terms WHERE termID = :termID")
    Term getTermByID(int termID);

    @Query("SELECT COUNT(*) FROM terms")
    int getTermCount();

    @Query("DELETE FROM terms")
    int deleteAllTerms();

    @Query("select (max(termID)+1) as newTermID from terms")
    int getNewTermID();

}
