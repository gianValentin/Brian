package com.giancarlo.brian;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.giancarlo.brian.db.entity.UserEntity;

import java.util.List;

public class NuevoUserDialogViewModel extends AndroidViewModel {
    private LiveData<List<UserEntity>> allUsers;
    private UserRepository userRepository;

    public NuevoUserDialogViewModel(Application application){
        super(application);

        userRepository = new UserRepository(application);
        allUsers = userRepository.getAll();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return allUsers;
    }

    public void insertarUser(UserEntity userEntity){
        userRepository.insert(userEntity);
    }
}