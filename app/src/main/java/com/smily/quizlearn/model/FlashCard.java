package com.smily.quizlearn.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "flashcard",
        foreignKeys = @ForeignKey(
                entity = StudySet.class,
                parentColumns = "id",
                childColumns = "setId",
                onDelete = ForeignKey.CASCADE
        )
)
@TypeConverters({Converters.class})
public class FlashCard {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private int setId;

    @NonNull
    private String question;

    @NonNull
    private String answer;
    private Date createDate;
    private Date updateDate;

    @Ignore
    public FlashCard() {
    }
    @Ignore
    public FlashCard(String question, String answer){
    }
    public FlashCard(int setId, String question, String answer, Date createDate, Date updateDate) {
        this.setId = setId;
        this.question = question;
        this.answer = answer;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
