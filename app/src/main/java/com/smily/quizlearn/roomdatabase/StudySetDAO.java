package com.smily.quizlearn.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.smily.quizlearn.model.StudySet;

import java.util.List;

@Dao
public interface StudySetDAO {
    @Insert
    void insertStudySet(StudySet studySet);

    @Query("SELECT * FROM studySet WHERE name LIKE '%' || :search || '%'")
    List<StudySet> getListBySearch(String search);

    @Query("SELECT * FROM studySet")
    List<StudySet> getAll();
    @Query("SELECT * FROM studySet WHERE createBy = :email")
    List<StudySet> getListCreated(String email);
    @Query("SELECT * FROM studySet WHERE id = :setId")
    StudySet getStudySet(int setId);
}
