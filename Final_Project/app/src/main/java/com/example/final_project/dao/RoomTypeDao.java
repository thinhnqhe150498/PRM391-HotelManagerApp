package com.example.final_project.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.final_project.database.DbHelper;
import com.example.final_project.entity.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeDao

{
    private DbHelper dbHelper;
    private SQLiteDatabase db;


    public RoomTypeDao(Context context){
        dbHelper= new DbHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public long insertRoomType(RoomType roomType){
        ContentValues values= new ContentValues();
        values.put("name",roomType.getName());
        return db.insert("RoomType",null,values);
    }

    public List<RoomType> getDaTa(String sql, String...selectionArgs){
        List<RoomType> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql,selectionArgs);
        if (c.getCount() > 0) {
            c.moveToFirst();
            while (!c.isAfterLast()) {
                int a = c.getInt(0);
                String b = c.getString(1);
                list.add(new RoomType(a,b));
                c.moveToNext();
            }
            c.close();
        }
        return list;
    }


    public  List<RoomType> getListRoomType(){
        String query = "SELECT * FROM RoomType WHERE id=?";
      return getDaTa(query);
    }
}
