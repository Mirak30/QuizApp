package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private ImageView barra;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int id_Questions5[] = {R.drawable.barra_5_1, R.drawable.barra_5_2, R.drawable.barra_5_3, R.drawable.barra_5_4, R.drawable.barra_5_5};
    private int id_Questions10[] = {R.drawable.barra_10_1, R.drawable.barra_10_2, R.drawable.barra_10_3, R.drawable.barra_10_4, R.drawable.barra_10_5,
                                    R.drawable.barra_10_6, R.drawable.barra_10_7, R.drawable.barra_10_8, R.drawable.barra_10_9, R.drawable.barra_10_10};
    private int id_Questions15[] = {R.drawable.barra_15_1, R.drawable.barra_15_2, R.drawable.barra_15_3, R.drawable.barra_15_4, R.drawable.barra_15_5,
                                    R.drawable.barra_15_6, R.drawable.barra_15_7, R.drawable.barra_15_8, R.drawable.barra_15_9, R.drawable.barra_15_10,
                                    R.drawable.barra_15_11, R.drawable.barra_15_12, R.drawable.barra_15_13, R.drawable.barra_15_14, R.drawable.barra_15_15};
    private int correctAnswer;
    private String[] allQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private TextView textQuestion;
    private TextView textCorrect;
    private TextView textIncorrect;
    private int partialRes;
    private int partialResIncorrect;
    boolean correct = false;
    Intent i,opt;
    String difficulty;
    boolean images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        opt=getIntent();
        difficulty=opt.getStringExtra("Difficulty");
        images=opt.getBooleanExtra("images",true);
        if(images){
            i=new Intent(Quiz.this, QuizImages.class);
        }else{
            i=new Intent(Quiz.this, Result.class);
        }
        i.putExtra("Difficulty",difficulty);
        textQuestion = findViewById(R.id.textQuestion);
        textCorrect = findViewById(R.id.textPointCorrects);
        textIncorrect = findViewById(R.id.textPointsIncorrects);
        barra = findViewById(R.id.ImageNumberQuestions);
        if(difficulty.equals("Easy")){
            allQuestions = getResources().getStringArray(R.array.easyQuestions);
        }else if(difficulty.equals("Difficult")){
            allQuestions = getResources().getStringArray(R.array.diffQuestions);
        }

        currentQuestion = 0;
        answerIsCorrect = new boolean[allQuestions.length];
        partialRes = 0;
        partialResIncorrect = 0;

        showQuestion();
        configureButton(correctAnswer);
    }

    private void showQuestion() {
        String q = allQuestions[currentQuestion];
        String[] parts = q.split(";");

        textQuestion.setText(parts[0]);
        barra.setImageResource(id_Questions10[currentQuestion]);
        textCorrect.setText(Integer.toString(partialRes));
        textIncorrect.setText(Integer.toString(partialResIncorrect));

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
                startActivity(new Intent(Quiz.this, Category.class));
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
            i.putExtra("resultIncorrect", partialResIncorrect);
            i.putExtra("result", partialRes);
        }

        if(currentQuestion == 9)
        {
            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
            showQuestion();
        }
    }

}