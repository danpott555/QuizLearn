package com.smily.quizlearn.roomdatabase;

import androidx.room.Dao;
import androidx.room.Query;

import com.smily.quizlearn.model.Role;

import java.util.List;

@Dao
public interface RoleDAO {
    @Query("SELECT * FROM role")
    List<Role> getAll();
}
