package com.example.prueba_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba_quiz.db.DbHelper;
import com.example.prueba_quiz.db.DbImageQuestion;
import com.example.prueba_quiz.db.DbTextQuestion;

import java.util.ArrayList;

public class Category extends AppCompatActivity {

    ImageButton BOptions, startQuiz, goBack,bCinema, bHistory,bVideogames, bAnime;
    String opt[]={"Easy","Difficult"};
    CheckBox imgCheck;
    Spinner nQuest;
    int numQuest=5;
    Intent i,in,options;
    ArrayAdapter<String> arrayAdapter;
    DbTextQuestion dbTextQuestion;
    DbImageQuestion dbImageQuestion;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        imgCheck=findViewById(R.id.imagesCheck);
        nQuest=findViewById(R.id.spinnerQuest);
        goBack=findViewById(R.id.BGoBackOpt);
        startQuiz=findViewById(R.id.ButtomStartQuiz);
        bVideogames=findViewById(R.id.BCategoryVideogames);
        bAnime=findViewById(R.id.BCategoryAnime);
        bCinema=findViewById(R.id.BCategoryCinema);
        bHistory=findViewById(R.id.BCategoryHistory);
        play = (int) Comunicador.getInt();
        i=new Intent(this,Quiz.class);
        in=new Intent(this,Menu.class);

        arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,opt);
        nQuest.setAdapter(arrayAdapter);

        confButton();
    }

    private void confButton()
    {
        BOptions = findViewById(R.id.Boptions);
        BOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Category.this, Options.class));
            }
        });

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


        bHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options=getIntent();

                numQuest=options.getIntExtra("nQuest",5);
                dbTextQuestion=new DbTextQuestion(Category.this,numQuest);
                dbImageQuestion=new DbImageQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                if(imgCheck.isChecked()){
                    i.putExtra("images",true);
                }else {
                    i.putExtra("images", false);
                }
                if (nQuest.getSelectedItem().toString()=="Easy"||nQuest.getSelectedItem()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY_IMG);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY_IMG);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                finish();
                startActivity(i);
            }
        });

        bAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options=getIntent();

                numQuest=options.getIntExtra("nQuest",5);
                dbTextQuestion=new DbTextQuestion(Category.this,numQuest);
                dbImageQuestion=new DbImageQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                if(imgCheck.isChecked()){
                    i.putExtra("images",true);
                }else {
                    i.putExtra("images", false);
                }
                if (nQuest.getSelectedItem().toString()=="Easy"||nQuest.getSelectedItem()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYANIME);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYANIME_IMG);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME_IMG);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                finish();
                startActivity(i);
            }
        });

        bCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                options=getIntent();

                numQuest=options.getIntExtra("nQuest",5);
                dbTextQuestion=new DbTextQuestion(Category.this,numQuest);
                dbImageQuestion=new DbImageQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                if(imgCheck.isChecked()){
                    i.putExtra("images",true);
                }else {
                    i.putExtra("images", false);
                }
                if (nQuest.getSelectedItem().toString()=="Easy"||nQuest.getSelectedItem()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYCINE);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYCINE_IMG);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE_IMG);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                finish();
                startActivity(i);
            }
        });


        bVideogames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options=getIntent();

                numQuest=options.getIntExtra("nQuest",5);
                dbTextQuestion=new DbTextQuestion(Category.this,numQuest);
                dbImageQuestion=new DbImageQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                if(imgCheck.isChecked()){
                    i.putExtra("images",true);
                }else {
                    i.putExtra("images", false);
                }
                if (nQuest.getSelectedItem().toString()=="Easy"||nQuest.getSelectedItem()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES_IMG);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES_IMG);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                finish();
                startActivity(i);
            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        if(play == 0) {
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.PAUSE);
            startService(i);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(play == 0) {
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
    }
}
