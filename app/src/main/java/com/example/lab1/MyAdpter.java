package com.example.lab1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyClass> {



//    private final ClickListener listener;
    Context context;
    ArrayList<GetterSetter> al;
    public  MyAdpter (Context context, ArrayList<GetterSetter> al){
//        this.listener = listener;
        this.context = context;
        this.al=al;
    }

    @NonNull
    @Override
    public MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowfile,parent,false);
        return new MyClass(v);
    }


    //this Function is for delleting item from DB
    public void deleteItem(int position, int id){
//        String stdName= al.get(position ).getName();
        Toast.makeText(context,id+" has been deleted Successfully", Toast.LENGTH_LONG).show();
        myDatabase db = new myDatabase(context);
        db.deleteStudent(id);
        al.remove(position);
//        Toast.makeText(context, tr, Toast.LENGTH_LONG).show();

    }


    @Override
    public void onBindViewHolder(@NonNull MyClass holder, int position) {

        GetterSetter gl = al.get(position);

        holder.tv_name.setText(gl.getName());
        holder.tv_number.setText(gl.getNumber());
        holder.tv_student.setText(gl.getStudent());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentcardviewActivity.class);
                intent.putExtra("username", al.get(position).getName());
                intent.putExtra("number", al.get(position).getNumber());
                intent.putExtra("student", al.get(position).getStudent());
//                username varchar(30), number varchar(20), student varchar(10),school varchar(20), program varch(10),level varchar(1),validity varchar(20))");

                intent.putExtra("school", al.get(position).getSchool());
                intent.putExtra("program", al.get(position).getProgram());
                intent.putExtra("level", al.get(position).getLevel());
                intent.putExtra("validity", al.get(position).getValidity());
                intent.putExtra("id", al.get(position).getId());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyClass extends RecyclerView.ViewHolder{

        TextView tv_name,tv_number,tv_student;
        Button btnEdit;



        public MyClass(View itemView) {
            super(itemView);



            tv_name=itemView.findViewById(R.id.tv_name);
            tv_number=itemView.findViewById(R.id.tv_number);
            tv_student =itemView.findViewById(R.id.tv_student);
            btnEdit = itemView.findViewById(R.id.viewStd);


        }


    }
}
