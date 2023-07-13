package com.smily.quizlearn.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;

@Entity(tableName = "user")
@TypeConverters({Converters.class})
public class User implements Serializable {
    @PrimaryKey
    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String username;

    @NonNull
    private String question;

    @NonNull String answer;

//    @NonNull
//    private String avatar;

    public User() {
//        this.avatar = "@drawable/avatar.jpg";
    }

    public User(String email, String password, String username, String question, String answer) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.question = question;
        this.answer = answer;
//        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@NonNull String question) {
        this.question = question;
    }

    @NonNull
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(@NonNull String answer) {
        this.answer = answer;
    }

    //    @NonNull
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(@NonNull String avatar) {
//        this.avatar = avatar;
//    }
}
