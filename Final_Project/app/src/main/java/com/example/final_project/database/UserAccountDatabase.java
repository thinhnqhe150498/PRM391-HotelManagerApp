package com.example.final_project.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.final_project.dao.UserAccountDAO;
import com.example.final_project.entity.UserAccount;

@Database(entities = UserAccount.class, version = 1)
public abstract class UserAccountDatabase extends RoomDatabase {

    public static UserAccountDatabase getInstance(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                UserAccountDatabase.class,
                "userAccount").allowMainThreadQueries().build();
    }

    public abstract UserAccountDAO userAccountDAO();
}
