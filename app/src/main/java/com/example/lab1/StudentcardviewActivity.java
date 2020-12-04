package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentcardviewActivity extends AppCompatActivity {

    EditText edName, edNumber,edSchool,edLevel,edValidity,edProgram,edStudent;

    Button updateBtn,closeBtn;

    Integer  Id;
    myDatabase myDb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentcardview);

        edName = findViewById(R.id.username);
        edNumber = findViewById(R.id.contactNumber);
        edSchool = findViewById(R.id.school);
        edLevel = findViewById(R.id.level);
        edValidity = findViewById(R.id.validity);
        edProgram = findViewById(R.id.program);
        edStudent = findViewById(R.id.student);

        updateBtn = findViewById(R.id.updateBtn);
        closeBtn = findViewById(R.id.closeBtn);


//        myDb = new myDatabase(MainActivity.this);

        Intent intent = getIntent();
//        Toast.makeText(this,intent.getStringExtra("username"),Toast.LENGTH_LONG).show();
//        username varchar(30), number varchar(20), student varchar(10),school varchar(20), program varch(10),level varchar(1),validity varchar(20))");
        edName.setText(intent.getStringExtra("username") );
        edNumber.setText(intent.getStringExtra("number"));
        edSchool.setText(intent.getStringExtra("school"));
        edLevel.setText(intent.getStringExtra("level"));
        edValidity.setText(intent.getStringExtra("validity"));
        edProgram.setText(intent.getStringExtra("program"));
        edStudent.setText(intent.getStringExtra("student"));
//        Id= Integer.parseInt(intent.getIntExtra("id",0));

        System.out.println("********"+intent.getIntExtra("id",0)+2);

        updateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myDb = new myDatabase(getApplicationContext());
                System.out.println("<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>> "+edStudent.getText().toString());
                myDb.updateData(edName.getText().toString(),edNumber.getText().toString(),edStudent.getText().toString(),edSchool.getText().toString(),edProgram.getText().toString(),edLevel.getText().toString(),edValidity.getText().toString());

                Intent i =new Intent(StudentcardviewActivity.this, DisplayActivity.class);
                startActivity(i);

            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(StudentcardviewActivity.this, MainActivity.class);
                startActivity(i);
            }
        });




    }

}
 