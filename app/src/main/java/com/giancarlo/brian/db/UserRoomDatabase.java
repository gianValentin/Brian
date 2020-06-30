package com.giancarlo.brian.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.giancarlo.brian.db.dao.UserDao;
import com.giancarlo.brian.db.entity.UserEntity;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    private static volatile UserRoomDatabase INSTANCE;

    public static UserRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (UserRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserRoomDatabase.class,"brian_database").build();
                }
            }
        }

        return INSTANCE;
    }
}
