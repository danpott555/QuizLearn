package com.smily.quizlearn.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_role", foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "email",
                childColumns = "userEmail",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Role.class,
                parentColumns = "id",
                childColumns = "roleId",
                onDelete = ForeignKey.CASCADE)
})
public class User_role {
    @PrimaryKey
    @ColumnInfo(index = true)
    private String userEmail;

    @PrimaryKey
    @ColumnInfo(index = true)
    private int roleId;

    public User_role(String userEmail, int roleId) {
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
