package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName, edNumber,edSchool,edLevel,edValidity,edProgram,edStudent;

    Button btn,viewBtn;

    myDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.username);
        edNumber = findViewById(R.id.contactNumber);
        edSchool = findViewById(R.id.school);
        edLevel = findViewById(R.id.level);
        edValidity = findViewById(R.id.validity);
        edProgram = findViewById(R.id.program);
        edStudent = findViewById(R.id.student);

        btn = findViewById(R.id.saveBtn);
        viewBtn = findViewById(R.id.display);


        myDb = new myDatabase(MainActivity.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDb.insertData(edName.getText().toString(),edNumber.getText().toString(),edStudent.getText().toString(),edSchool.getText().toString(),edProgram.getText().toString(),edLevel.getText().toString(),edValidity.getText().toString());

                Intent i =new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //myDb.insertData(edName.getText().toString(),edNumber.getText().toString(),edStudent.getText().toString(),edSchool.getText().toString(),edProgram.getText().toString(),edLevel.getText().toString(),edValidity.getText().toString());

                Intent i =new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });


    }
}