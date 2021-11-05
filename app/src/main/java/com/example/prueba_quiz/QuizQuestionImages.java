package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizQuestionImages extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private ImageView question;
    private int imagesEasy[]={R.drawable.reinaisabel};
    private int imagesHard[]={R.drawable.saneduardo};
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int correctAnswer;
    private String[] allQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private TextView textQuestion;
    private int partialRes;
    private int partialResIncorrect;
    boolean correct = false;
    Intent i,opt;
    String difficulty;
    boolean images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question_images);
        opt=getIntent();
        difficulty=opt.getStringExtra("Difficulty");
        images=opt.getBooleanExtra("images",true);
        i=new Intent(QuizQuestionImages.this, Questionsmultimedia.class);
        textQuestion = findViewById(R.id.textQuestion);
        partialRes=opt.getIntExtra("result",0);
        partialResIncorrect = opt.getIntExtra("resultIncorrect",0);
        question=findViewById(R.id.imgQuest);
        if(difficulty.equals("Easy")){
            allQuestions = getResources().getStringArray(R.array.image_question_text_resp_Easy);
        }else if(difficulty.equals("Difficult")){
            allQuestions = getResources().getStringArray(R.array.image_question_text_resp_Hard);
        }

        currentQuestion = 0;
        answerIsCorrect = new boolean[allQuestions.length];

        showQuestion();
        configureButton(correctAnswer);
    }

    private void showQuestion() {
        String q = allQuestions[currentQuestion];
        if(difficulty.equals("Easy")){
            question.setImageResource(imagesEasy[currentQuestion]);

        }else{
            question.setImageResource(imagesHard[currentQuestion]);
        }

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

        if(currentQuestion == 0)
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