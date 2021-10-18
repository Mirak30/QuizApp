package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class Options extends AppCompatActivity {


    Spinner nQuest;
    String opt[]={"Easy","Difficult"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        nQuest=findViewById(R.id.spinnerQuest);

    }
}