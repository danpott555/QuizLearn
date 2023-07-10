package com.smily.quizlearn.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "studySet")
@TypeConverters({Converters.class})
public class StudySet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String createBy;
    private Date createDate;
    private Date updateDate;
    private String description;

    public StudySet(int id, String name, String createBy, Date createDate, Date updateDate, String description) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
