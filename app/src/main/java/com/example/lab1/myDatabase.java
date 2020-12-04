package com.example.lab1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDatabase extends SQLiteOpenHelper
{


    public myDatabase(@Nullable Context context) {
        super(context, "MyDBb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table student(id integer primary key autoincrement, username varchar(30), number varchar(20), student varchar(10),school varchar(20), program varch(10),level varchar(1),validity varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Method for inserting Data

    public void insertData (String username, String number, String student, String school, String program, String level , String validity){
        SQLiteDatabase sd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username",username);
        cv.put("number",number);
        cv.put("student",student);
        cv.put("school",school);
        cv.put("program",program);
        cv.put("level",level);
        cv.put("validity",validity);
        sd.insert("student",null,cv);

    }


    public void updateData(String username, String number, String student, String school, String program, String level , String validity){
        SQLiteDatabase sd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("number",number);
        cv.put("student",student);
        cv.put("school",school);
        cv.put("program",program);
        cv.put("level",level);
        cv.put("validity",validity);

        sd.update("student",cv,"student= ?",new String[]{student});
        sd.close();

    }

    public Cursor getData(){
        SQLiteDatabase sd=this.getReadableDatabase();
        Cursor c=sd.rawQuery("select * from student",null);
        return c;
}

    public boolean deleteStudent(int id)
    {
        SQLiteDatabase sd = this.getWritableDatabase();
        return sd.delete("student","id="+id,null)>0;

    }

}
