package com.smily.quizlearn.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.smily.quizlearn.model.FlashCard;
import com.smily.quizlearn.model.StudySet;
import com.smily.quizlearn.model.User;

@Database(
        entities =
                {
                        FlashCard.class,
                        User.class,
                        StudySet.class
                },
        version = 1
)
public abstract class InitDatabase extends RoomDatabase {
    private static String DB_NAME = "quizAppDB";
    private static InitDatabase instance;

    public static synchronized InitDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), InitDatabase.class, DB_NAME)
                    .createFromAsset("database/quizapp.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();

    public abstract FlashCardDAO flashCardDAO();

    public abstract StudySetDAO studySetDAO();
}
