package com.shubham.agr.roomexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.shubham.agr.roomexample.models.User;
import com.shubham.agr.roomexample.models.Dao.UserDao;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
