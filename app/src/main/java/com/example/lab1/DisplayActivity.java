package com.example.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView rv;

    String id, name, number,school,level,validity,program,student;

    ArrayList<GetterSetter> al= new ArrayList<>();

    myDatabase myDb;

    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button viewStd;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv = findViewById(R.id.rev);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayActivity.this);
        rv.setLayoutManager(layoutManager);

        myDb = new myDatabase(DisplayActivity.this);
        c=myDb.getData();
        if(c.getCount()>0){
            if(c.moveToFirst()){
                do{
                    id=c.getString(0);
                    name = c.getString(1);
                    number = c.getString(2);
                    school = c.getString(4);
                    level = c.getString(6);
                    program = c.getString(5);
                    validity = c.getString(7);
                    student = c.getString(3);

                    GetterSetter gl =new GetterSetter(id,name,number,school,level,program,validity,student);
                    al.add(gl);

                }while(c.moveToNext());
            }
        }
        MyAdpter my = new MyAdpter(DisplayActivity.this,al);
        rv.setAdapter(my);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {


                my.deleteItem(viewHolder.getAdapterPosition() ,al.get(viewHolder.getAdapterPosition() ).getId());
                my.notifyDataSetChanged();
            }
        }).attachToRecyclerView(rv);





    }
}