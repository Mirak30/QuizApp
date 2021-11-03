package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class Options extends AppCompatActivity {

    Spinner nQuest;
    String opt[]={"5","10","15"};
    ImageButton goBack,bChangeName,bsound;
    boolean sound = true;
    EditText changeName;
    Intent in;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        nQuest = findViewById(R.id.spinnerNumberQuestions);
        goBack = findViewById(R.id.BGoBackOpt);
        bsound = findViewById(R.id.BSoundOn);
        changeName = findViewById(R.id.editTextPersonName);

        in=new Intent(this,Category.class);
        arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,opt);
        nQuest.setAdapter(arrayAdapter);

        confButton();
    }
    private void confButton(){

        bsound.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if(sound)
                  {
                      bsound.setImageResource(R.drawable.sonido_off);
                      sound = false;
                  }
                  else
                  {
                      bsound.setImageResource(R.drawable.sonido_on);
                      sound = true;
                  }

              }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(in);
            }
        });


    }


}