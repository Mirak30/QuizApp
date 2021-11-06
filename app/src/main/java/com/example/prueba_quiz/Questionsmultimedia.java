package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Questionsmultimedia extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private int correctAnswer;
    private VideoView question;
    private String[] allQuestions;
    private boolean[] answerIsCorrect;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int currentQuestion;
    private TextView textQuestion;
    private int partialRes;
    private int partialResIncorrect;
    Chronometer chronometerMulti;
    boolean correct = false;
    Intent i,opt;
    String difficulty;
    long antChronometer;
    long chronometerResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question_multimedia);
        opt=getIntent();
        difficulty=opt.getStringExtra("Difficulty");

        i=new Intent(Questionsmultimedia.this, Result.class);
        textQuestion = findViewById(R.id.textQuestion);
        partialRes=opt.getIntExtra("result",0);
        partialResIncorrect = opt.getIntExtra("resultIncorrect",0);
        antChronometer = opt.getLongExtra("timeChronometerMultimedia",0);
        currentQuestion = 0;
        answerIsCorrect = new boolean[allQuestions.length];
        question=findViewById(R.id.videoQuestions);
        showQuestion();
        configureButton(correctAnswer);

    }

    private void showQuestion() {
        String q = allQuestions[currentQuestion];
        /*if(difficulty.equals("Easy")){
            question.setImageResource(imagesEasy[currentQuestion]);

        }else{
            question.setImageResource(imagesHard[currentQuestion]);
        }*/

        String[] parts = q.split(";");

        textQuestion.setText(parts[0]);

        for(int i=0; i < id_answers.length; i++)
        {
            TextView tb = (TextView) findViewById(id_answers[i]);
            String answer = parts[i+1];
            if(answer.charAt(0) == '*')
            {
                correctAnswer = i;
                answer = answer.substring(1);
            }
            tb.setText(answer);
        }
    }

    public void configureButton(int cA)
    {
        BExit = findViewById(R.id.BExitQuiz);
        BExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometerMulti.stop();
                finish();
                startActivity(new Intent(Questionsmultimedia.this, Category.class));
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
            i.putExtra("resultIncorrect", partialResIncorrect);
            i.putExtra("result", partialRes);

        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
            partialResIncorrect++;
            i.putExtra("result", partialRes);
            i.putExtra("resultIncorrect", partialResIncorrect);
        }

        if(currentQuestion == 1)
        {

            chronometerResult = SystemClock.elapsedRealtime() - chronometerMulti.getBase();
            i.putExtra("timeChronometerResult", chronometerResult);
            chronometerMulti.stop();
            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
            showQuestion();
        }
    }

}