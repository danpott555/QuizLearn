package com.smily.quizlearn.model;

import java.util.Date;

public class Folder {
    private int id;
    private String name;
    private String createBy;
    private Date createDate;
    private Date updateDate;
    private String description;

    public Folder(String name, String createBy, Date createDate, Date updateDate, String description) {
        this.name = name;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.description = description;
    }

    public int getId() {
        return id;
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
