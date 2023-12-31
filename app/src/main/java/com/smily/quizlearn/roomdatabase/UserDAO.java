package com.smily.quizlearn.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.smily.quizlearn.model.User;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);


    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Query("SELECT * FROM user WHERE username = :username AND email <> :email")
    User getUserByUsername(String username, String email);

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    User getUser(String email, String password);

    @Query("SELECT * FROM user WHERE email = :email AND question = :question AND answer = :answer")
    User getForgotUser(String email, String question, String answer);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);
}
