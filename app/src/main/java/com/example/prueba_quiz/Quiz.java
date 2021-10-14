package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    ImageButton BExit;
    ImageButton BCorrect, BIncorret1, BIncorret2, BIncorret3;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    boolean correct = false;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_Question = findViewById(R.id.textQuestion);
        text_Question.setText(R.string.content_question);

        String[] answers = getResources().getStringArray(R.array.answer);

        for(int i=0; i < id_answers.length; i++)
        {
            TextView tb = (TextView) findViewById(id_answers[i]);
            tb.setText(answers[i]);
        }

        int correctAnswers = getResources().getInteger(R.integer.correct_name);


        configureButton(correctAnswers);
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

        BCorrect = findViewById(R.id.ButtonOp1);
        BCorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer1 = 0;
                if(answer1 == cA)
                {
                    correct = true;
                    doValidate();
                }else
                {
                    correct = false;
                    doValidate();
                }
            }
        });

        BIncorret1 = findViewById(R.id.ButtonOp2);
        BIncorret1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer2 = 1;
                if(answer2 == cA)
                {
                    correct = true;
                    doValidate();
                }else
                {
                    correct = false;
                    doValidate();
                }
            }
        });

        BIncorret2 = findViewById(R.id.ButtonOp3);
        BIncorret2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer3 = 2;
                if(answer3 == cA)
                {
                    correct = true;
                    doValidate();
                }else
                {
                    correct = false;
                    doValidate();
                }
            }
        });

        BIncorret3 = findViewById(R.id.ButtonOp4);
        BIncorret3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer4 = 3;
                if(answer4 == cA)
                {
                    correct = true;
                    doValidate();
                }else
                    {
                        correct = false;
                    }
            }
        });

    }

    public void doValidate()
    {
        if(correct)
        {
            Toast.makeText(this,R.string.correctAnswer,Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(Quiz.this, Result.class));
        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
        }
    }

}