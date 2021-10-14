package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int correctAnswer;
    private String[] allQuestions;
    private int currentQuestion;
    private TextView textQuestion;
    int result;
    boolean correct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textQuestion = findViewById(R.id.textQuestion);
        allQuestions = getResources().getStringArray(R.array.all_question);
        currentQuestion = 0;
        result = getResources().getInteger(R.integer.result);
        showQuestion();

        configureButton(correctAnswer);
    }

    private void showQuestion() {
        String q = allQuestions[currentQuestion];
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
                finish();
                System.exit(0);
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
        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
        }

        if(currentQuestion == 2)
        {
            finish();
            startActivity(new Intent(Quiz.this, Result.class));
        }else
            {
                currentQuestion++;
                showQuestion();
            }
    }

}