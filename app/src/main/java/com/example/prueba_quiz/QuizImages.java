package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class QuizImages extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private String difficulty;
    Chronometer chronometerImage;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int[][] idImagesEasy= {{R.drawable.rs,R.drawable.cr,R.drawable.es,R.drawable.ru},{R.drawable.suzuki,R.drawable.seat,R.drawable.cat,R.drawable.renault}};
    private int[][] idImagesDifficult= {{R.drawable.bru,R.drawable.pas,R.drawable.ok,R.drawable.les},{R.drawable.amberes,R.drawable.kiribati,R.drawable.bretana,R.drawable.cornualles}};
    long antChronometer;
    long sigChronometer = 0;
    private int correctAnswer;
    private String[] imageEasyQuestions;
    private String[] imageDiffQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private int counter;
    private TextView textQuestion;
    int partialRes;
    int partialResIncorrect;
    Intent i, intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_images);
        intent=getIntent();
        i=new Intent(QuizImages.this, QuizQuestionImages.class);
        partialRes=intent.getIntExtra("result",0);
        partialResIncorrect=intent.getIntExtra("resultIncorrect",0);
        difficulty=intent.getStringExtra("Difficulty");
        antChronometer = intent.getLongExtra("timeChronometerQuizImage",0);
        i.putExtra("Difficulty",difficulty);
        currentQuestion= 0;
        textQuestion = findViewById(R.id.textQuestion);
        chronometerImage = findViewById(R.id.chronometerQuizImage);
        counter= 0;
        imageEasyQuestions=getResources().getStringArray(R.array.image_question_Easy);
        imageDiffQuestions=getResources().getStringArray(R.array.image_question_Hard);
        answerIsCorrect = new boolean[4];
        BOp1 = findViewById(R.id.ButtonOp1);
        BOp2 = findViewById(R.id.ButtonOp2);
        BOp3 = findViewById(R.id.ButtonOp3);
        BOp4 = findViewById(R.id.ButtonOp4);

        chronometerImage.setBase(antChronometer);

        showQuestion();
        configureButton(correctAnswer);
    }

    private void showQuestion() {
        String q="";
        if(difficulty.equals("Easy")) {
             q = imageEasyQuestions[counter];
        }else{
             q = imageDiffQuestions[counter];
        }

        String[] parts = q.split(";");

        textQuestion.setText(parts[0]);
    if(intent.getStringExtra("Difficulty").equals("Easy")){
        BOp1.setImageResource(idImagesEasy[counter][0]);
        BOp2.setImageResource(idImagesEasy[counter][1]);
        BOp3.setImageResource(idImagesEasy[counter][2]);
        BOp4.setImageResource(idImagesEasy[counter][3]);
    }else{

        BOp1.setImageResource(idImagesDifficult[counter][0]);
        BOp2.setImageResource(idImagesDifficult[counter][1]);
        BOp3.setImageResource(idImagesDifficult[counter][2]);
        BOp4.setImageResource(idImagesDifficult[counter][3]);
    }

        for(int i=0; i < id_answers.length; i++) {
            String answer = parts[i + 1];
            if (answer.charAt(0) == '*') {
                correctAnswer = i;
            }
        }
    }

    public void configureButton(int cA)
    {
        BExit = findViewById(R.id.BExitQuiz);
        BExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(QuizImages.this, Category.class));
            }
        });

        BOp1 = findViewById(R.id.ButtonOp1);
        BOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = 0;
                doValidate(answer);
            }
        });

        BOp2 = findViewById(R.id.ButtonOp2);
        BOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = 1;
                doValidate(answer);
            }
        });

        BOp3 = findViewById(R.id.ButtonOp3);
        BOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = 2;
                doValidate(answer);
            }
        });

        BOp4 = findViewById(R.id.ButtonOp4);
        BOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer = 3;
                doValidate(answer);
            }
        });

    }

    public void doValidate(int answer)
    {

        if(answer == correctAnswer)
        {
            Toast.makeText(this,R.string.correctAnswer,Toast.LENGTH_SHORT).show();
            //answerIsCorrect[currentQuestion] = true;
            partialRes++;
            i.putExtra("result", partialRes);
            i.putExtra("resultIncorrect", partialResIncorrect);

        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
            partialResIncorrect++;
            i.putExtra("result", partialRes);
            i.putExtra("resultIncorrect", partialResIncorrect);
        }

        if(currentQuestion == 1)
        {
            sigChronometer = SystemClock.elapsedRealtime() - chronometerImage.getBase();
            i.putExtra("timeChronometerQuestionImage", sigChronometer);
            chronometerImage.stop();
            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
            counter++;
            showQuestion();
        }
    }
}