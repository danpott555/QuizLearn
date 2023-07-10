package com.smily.quizlearn.roomdatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.model.Role;
import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;

import java.io.File;

@Database(
        entities =
                {
                        FlashCard.class,
                        Role.class,
                        User.class,
                        StudySet.class
                },
        version = 1)
public abstract class InitDatabase extends RoomDatabase {
    private static String DB_NAME = "quizLearn.db";
    private static InitDatabase instance;

    public static synchronized InitDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), InitDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
    public abstract FlashCardDAO flashCardDAO();
    public abstract RoleDAO roleDAO();
    public abstract StudySetDAO studySetDAO();
}
