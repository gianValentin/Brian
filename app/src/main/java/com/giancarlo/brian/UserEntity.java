package com.giancarlo.brian;

import android.app.Activity;

public class UserEntity {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
