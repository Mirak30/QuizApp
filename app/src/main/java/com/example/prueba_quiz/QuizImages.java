package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizImages extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int id_images1[] = {R.drawable.rs,R.drawable.suzuki};
    private int id_images2[] = {R.drawable.cr,R.drawable.seat};
    private int id_images3[] = {R.drawable.es,R.drawable.cat};
    private int id_images4[] = {R.drawable.ru,R.drawable.renault};

    private int correctAnswer;
    private String[] imageQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private int counter;
    private TextView textQuestion;
    int partialRes;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_images);
        Intent intent=getIntent();
        i=new Intent(QuizImages.this, Result.class);
        partialRes=intent.getIntExtra("result",0);
        currentQuestion= 0;
        textQuestion = findViewById(R.id.textQuestion);
        imageQuestions = getResources().getStringArray(R.array.image_question);
        counter= 0;
        answerIsCorrect = new boolean[imageQuestions.length];
        BOp1 = findViewById(R.id.ButtonOp1);
        BOp2 = findViewById(R.id.ButtonOp2);
        BOp3 = findViewById(R.id.ButtonOp3);
        BOp4 = findViewById(R.id.ButtonOp4);
        showQuestion();
        configureButton(correctAnswer);
    }

    private void showQuestion() {
        String q = imageQuestions[counter];
        String[] parts = q.split(";");

        textQuestion.setText(parts[0]);

            BOp1.setImageResource(id_images1[counter]);
            BOp2.setImageResource(id_images2[counter]);
            BOp3.setImageResource(id_images3[counter]);
            BOp4.setImageResource(id_images4[counter]);
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
            //answerIsCorrect[currentQuestion] = true;
            partialRes++;
            i.putExtra("result", partialRes);
        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
        }

        if(currentQuestion == 1)
        {
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