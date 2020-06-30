package com.giancarlo.brian;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.giancarlo.brian.db.UserRoomDatabase;
import com.giancarlo.brian.db.dao.UserDao;
import com.giancarlo.brian.db.entity.UserEntity;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    private LiveData<List<UserEntity>> findAll;

    public UserRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        findAll = userDao.findAll();
    }


    public LiveData<List<UserEntity>> getAll(){ return  findAll; }

    public void insert(UserEntity userEntity){

    }

    private static class insertAsyncTask extends AsyncTask<UserEntity, Void, Void>{
        private UserDao userDaoAsyncTask;

        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDaoAsyncTask.insert(userEntities[0]);
            return null;
        }
    }
}
