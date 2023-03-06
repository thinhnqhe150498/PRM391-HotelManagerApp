package com.example.final_project;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.final_project.dao.UserAccountDAO;
import com.example.final_project.database.UserAccountDatabase;
import com.example.final_project.entity.UserAccount;

import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    UserAccountDatabase userAccountDatabase;

    UserAccountDAO userAccountDAO;

    private void initRoomDatabase() {
        userAccountDatabase = Room.databaseBuilder(getApplicationContext(),
                UserAccountDatabase.class,
                "userAccount").allowMainThreadQueries().build();
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        initRoomDatabase();
        List<UserAccount> l = userAccountDAO.getAll();
        System.out.println(l.size());
//        UserAccount u = userAccountDAO.getByAccount("abc");
//        System.out.println(u);
    }
}