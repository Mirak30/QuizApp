package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class Options extends AppCompatActivity {


    Spinner nQuest;
    String opt[]={"Easy","Difficult"};
    CheckBox imgCheck;
    ImageButton goBack;
    ImageButton startQuiz;
    Intent i,in;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        nQuest=findViewById(R.id.spinnerQuest);
        imgCheck=findViewById(R.id.imagesCheck);
        goBack=findViewById(R.id.BGoBackOpt);
        startQuiz=findViewById(R.id.buttonStartQuiz);
        i=new Intent(this,Quiz.class);
        in=new Intent(this,MainActivity.class);
        arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,opt);
        nQuest.setAdapter(arrayAdapter);
        confButton();
    }
    private void confButton(){

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(in);
            }
        });
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgCheck.isChecked()){
                    i.putExtra("images",true);
                }else {
                    i.putExtra("images", false);
                }
                if (nQuest.getSelectedItem().toString()=="Easy"||nQuest.getSelectedItem()==null){
                    i.putExtra("Difficulty","Easy");

                }else{
                    i.putExtra("Difficulty","Difficult");
                }
                finish();
                startActivity(i);
            }
        });

    }


}