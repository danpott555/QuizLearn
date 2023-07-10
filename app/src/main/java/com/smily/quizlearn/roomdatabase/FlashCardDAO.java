package com.smily.quizlearn.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.smily.quizlearn.model.FlashCard;

import java.util.List;

@Dao
public interface FlashCardDAO {
    @Insert
    void insertFlashCard(FlashCard card);

    @Query("SELECT * FROM flashcard WHERE setId = :setId")
    List<FlashCard> getListFlashCard(int setId);
    @Delete
    void deleteFlashCard(FlashCard card);

    @Update
    void updateFlashCard(FlashCard card);
}
