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
import com.example.prueba_quiz.db.DbSoundQuestion;
import com.example.prueba_quiz.db.DbTextQuestion;
import com.example.prueba_quiz.db.DbVideoQuestion;

import java.util.ArrayList;

public class Category extends AppCompatActivity {

    ImageButton BOptions, startQuiz, goBack,bCinema, bHistory,bVideogames, bAnime;
    String opt[]={"Easy","Difficult"};
    int numQuest=5;
    Intent i,in,options;
    ArrayAdapter<String> arrayAdapter;
    DbTextQuestion dbTextQuestion;
    DbImageQuestion dbImageQuestion;
    DbVideoQuestion dbVideoQuestion;
    DbSoundQuestion dbSoundQuestion;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        goBack=findViewById(R.id.BGoBackOpt);
        startQuiz=findViewById(R.id.ButtomStartQuiz);
        bVideogames=findViewById(R.id.BCategoryVideogames);
        bAnime=findViewById(R.id.BCategoryAnime);
        bCinema=findViewById(R.id.BCategoryCinema);
        bHistory=findViewById(R.id.BCategoryHistory);
        play = (int) Comunicador.getInt();
        i=new Intent(this,Quiz.class);
        in=new Intent(this,Menu.class);


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
                /*if(imgCheck.isChecked()){
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
                startActivity(i);*/
                startActivity(new Intent(Category.this, Result.class));
            }
        });


        bHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                options=getIntent();

                numQuest=options.getIntExtra("nQuest",5);
                dbTextQuestion=new DbTextQuestion(Category.this,numQuest);
                dbImageQuestion=new DbImageQuestion(Category.this,numQuest);
                dbSoundQuestion=new DbSoundQuestion(Category.this,numQuest);
                dbVideoQuestion=new DbVideoQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                ArrayList<SoundQuestions> listaPreguntasS=new ArrayList<>();
                ArrayList<VideoQuestions> listaPreguntasV=new ArrayList<>();


                if (Comunicador.getDif()=="Fácil"||Comunicador.getDif()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_EASYHISTORY_V);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_DIFICULTHISTORY_V);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                i.putExtra("soundQuest",listaPreguntasS);
                i.putExtra("videoQuest",listaPreguntasV);
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
                dbSoundQuestion=new DbSoundQuestion(Category.this,numQuest);
                dbVideoQuestion=new DbVideoQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                ArrayList<SoundQuestions> listaPreguntasS=new ArrayList<>();
                ArrayList<VideoQuestions> listaPreguntasV=new ArrayList<>();

                if (Comunicador.getDif()=="Fácil"||Comunicador.getDif()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYANIME);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYANIME_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_EASYANIME_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_EASYANIME_V);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_DIFICULTANIME_V);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                i.putExtra("soundQuest",listaPreguntasS);
                i.putExtra("videoQuest",listaPreguntasV);
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
                dbSoundQuestion=new DbSoundQuestion(Category.this,numQuest);
                dbVideoQuestion=new DbVideoQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                ArrayList<SoundQuestions> listaPreguntasS=new ArrayList<>();
                ArrayList<VideoQuestions> listaPreguntasV=new ArrayList<>();

                if (Comunicador.getDif()=="Fácil"||Comunicador.getDif()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYCINE);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYCINE_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_EASYCINE_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_EASYCINE_V);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_DIFICULTCINE_V);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                i.putExtra("soundQuest",listaPreguntasS);
                i.putExtra("videoQuest",listaPreguntasV);
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
                dbSoundQuestion=new DbSoundQuestion(Category.this,numQuest);
                dbVideoQuestion=new DbVideoQuestion(Category.this,numQuest);
                i.putExtra("nQuest",numQuest);
                ArrayList<TextQuestions> listaPreguntasTxt=new ArrayList<>();
                ArrayList<ImageQuestions> listaPreguntasImg=new ArrayList<>();
                ArrayList<SoundQuestions> listaPreguntasS=new ArrayList<>();
                ArrayList<VideoQuestions> listaPreguntasV=new ArrayList<>();

                if (Comunicador.getDif()=="Fácil"||Comunicador.getDif()==null) {
                    //i.putExtra("Difficulty","Easy");

                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES);
                    listaPreguntasImg = dbImageQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_EASYVIDEOGAMES_V);
                }else{
                    listaPreguntasTxt = dbTextQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES);
                    listaPreguntasImg=dbImageQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES_IMG);
                    listaPreguntasS = dbSoundQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES_S);
                    listaPreguntasV = dbVideoQuestion.showQuestions(DbHelper.TABLE_DIFICULTVIDEOGAMES_V);
                }


                i.putExtra("textQuest",listaPreguntasTxt);
                i.putExtra("imgQuest",listaPreguntasImg);
                i.putExtra("soundQuest",listaPreguntasS);
                i.putExtra("videoQuest",listaPreguntasV);
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
