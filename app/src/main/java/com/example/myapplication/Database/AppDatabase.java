package com.example.myapplication.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.DAO.AssessmentDAO;
import com.example.myapplication.DAO.CourseDAO;
import com.example.myapplication.DAO.MentorDAO;
import com.example.myapplication.DAO.NoteDAO;
import com.example.myapplication.DAO.TermDAO;
import com.example.myapplication.Entity.Assessment;
import com.example.myapplication.Entity.Course;
import com.example.myapplication.Entity.Mentor;
import com.example.myapplication.Entity.Note;
import com.example.myapplication.Entity.Term;

@Database(entities = {Assessment.class, Course.class, Mentor.class, Note.class, Term.class},
                    version = 2,
                    exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TermDAO termDAO();
    public abstract CourseDAO courseDAO();
    public abstract MentorDAO mentorDAO();
    public abstract AssessmentDAO assessmentDAO();
    public abstract NoteDAO noteDAO();

    private static volatile AppDatabase INSTANCE;

    public static synchronized AppDatabase getDatabaseInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDatabase.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
