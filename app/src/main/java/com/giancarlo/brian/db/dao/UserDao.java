package com.giancarlo.brian.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.giancarlo.brian.db.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity userEntity);

    @Update
    void update(UserEntity userEntity);

    @Query("DELETE FROM users")
    void DeleteAll();

    @Query("DELETE FROM users WHERE id = :idUser")
    void deleteById(int idUser);

    @Query("SELECT * FROM users ORDER BY name ASC")
    LiveData<List<UserEntity>> findAll();
}
