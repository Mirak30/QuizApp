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

import java.util.ArrayList;

public class QuizQuestionImages extends AppCompatActivity {

    private ImageButton BExit;
    private ImageView barra;
    Chronometer chronometerSound;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    private ImageView question;
    private int imagesEasy[]={R.drawable.reinaisabel};
    private int imagesHard[]={R.drawable.saneduardo};
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int id_Questions5[] = {R.drawable.barra_5_1, R.drawable.barra_5_2, R.drawable.barra_5_3, R.drawable.barra_5_4, R.drawable.barra_5_5};
    private int id_Questions10[] = {R.drawable.barra_10_1, R.drawable.barra_10_2, R.drawable.barra_10_3, R.drawable.barra_10_4, R.drawable.barra_10_5,
            R.drawable.barra_10_6, R.drawable.barra_10_7, R.drawable.barra_10_8, R.drawable.barra_10_9, R.drawable.barra_10_10};
    private int id_Questions15[] = {R.drawable.barra_15_1, R.drawable.barra_15_2, R.drawable.barra_15_3, R.drawable.barra_15_4, R.drawable.barra_15_5,
            R.drawable.barra_15_6, R.drawable.barra_15_7, R.drawable.barra_15_8, R.drawable.barra_15_9, R.drawable.barra_15_10,
            R.drawable.barra_15_11, R.drawable.barra_15_12, R.drawable.barra_15_13, R.drawable.barra_15_14, R.drawable.barra_15_15};
    private String correctAnswer;
    private ArrayList<ImageQuestions> imageQuestions;
    private ArrayList<SoundQuestions> soundQuestions;
    private ArrayList<VideoQuestions> videoQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private int currentQuestionGlobal;
    private TextView textQuestion;
    private int partialRes;
    private int partialResIncorrect;
    private TextView textCorrect;
    private TextView textIncorrect;
    boolean correct = false;
    Intent i,cat;
    String difficulty;
    long antChronometer;
    long sigChronometer = 0;
    boolean images;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question_images);
        cat=getIntent();
        //difficulty=opt.getStringExtra("Difficulty");
        //images=cat.getBooleanExtra("images",true);
        i=new Intent(QuizQuestionImages.this, QuizQuestionSound.class);
        textQuestion = findViewById(R.id.textQuestion);
        textCorrect = findViewById(R.id.textPointCorrects);
        textIncorrect = findViewById(R.id.textPointsIncorrects);
        partialRes=cat.getIntExtra("result",0);
        partialResIncorrect = cat.getIntExtra("resultIncorrect",0);
        question=findViewById(R.id.imgQuest);
        antChronometer = cat.getLongExtra("timeChronometerQuizImage",0);
        barra = findViewById(R.id.imageNumberQuestions);
        imageQuestions=(ArrayList<ImageQuestions>)cat.getSerializableExtra("imgQuest");
        soundQuestions=(ArrayList<SoundQuestions>)cat.getSerializableExtra("soundQuest");
        videoQuestions=(ArrayList<VideoQuestions>)cat.getSerializableExtra("videoQuest");
        chronometerSound=findViewById(R.id.chronometer2);
        chronometerSound.setBase(SystemClock.elapsedRealtime()-antChronometer);
        chronometerSound.start();
        play = (int) Comunicador.getInt();
        currentQuestion = 0;
        currentQuestionGlobal=cat.getIntExtra("ccGlobal",0);
        //answerIsCorrect = new boolean[imageQuestions.size()];

        showQuestion();
        configureButton();
    }

    private void showQuestion() {
        textCorrect.setText(Integer.toString(partialRes));
        textIncorrect.setText(Integer.toString(partialResIncorrect));
        ImageQuestions q = imageQuestions.get(currentQuestion);
        //String[] parts = q.split(";");

        textQuestion.setText(q.getQuestion());
        question.setImageResource(q.getImg());
        correctAnswer=q.getCorrectAnswer();
        TextView tb = (TextView) findViewById(id_answers[0]);
        tb.setText(q.getAnswer1());

        tb = (TextView) findViewById(id_answers[1]);
        tb.setText(q.getAnswer2());

        tb = (TextView) findViewById(id_answers[2]);
        tb.setText(q.getAnswer3());

        tb = (TextView) findViewById(id_answers[3]);
        tb.setText(q.getAnswer4());

        if(cat.getIntExtra("nQuest",5)==5){
            barra.setImageResource(id_Questions5[currentQuestionGlobal+1]);

        }else if(cat.getIntExtra("nQuest",5)==10) {
            barra.setImageResource(id_Questions10[currentQuestionGlobal+1]);

        }else if(cat.getIntExtra("nQuest",5)==15){
            barra.setImageResource(id_Questions15[currentQuestionGlobal+1]);

        }
    }

    public void configureButton()
    {
        BExit = findViewById(R.id.BExitQuiz);
        BExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(QuizQuestionImages.this, Category.class));
            }
        });

        BOp1 = findViewById(R.id.ButtonOp1);
        BOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int answer = 0;
                TextView t=(TextView)findViewById(id_answers[0]);
                doValidate((String) t.getText());
            }
        });

        BOp2 = findViewById(R.id.ButtonOp2);
        BOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int answer = 1;
                TextView t=(TextView)findViewById(id_answers[1]);
                doValidate((String) t.getText());
            }
        });

        BOp3 = findViewById(R.id.ButtonOp3);
        BOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int answer = 2;
                TextView t=(TextView)findViewById(id_answers[2]);
                doValidate((String) t.getText());
            }
        });

        BOp4 = findViewById(R.id.ButtonOp4);
        BOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int answer = 3;
                TextView t=(TextView)findViewById(id_answers[3]);
                doValidate((String) t.getText());
            }
        });

    }

    public void doValidate(String answer)
    {

        if(answer.equals(correctAnswer))
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

        if(currentQuestion == imageQuestions.size()-1)
        {
            i.putExtra("soundQuest",soundQuestions);
            i.putExtra("videoQuest",videoQuestions);
            sigChronometer = SystemClock.elapsedRealtime() - chronometerSound.getBase();
            i.putExtra("timeChronometerMultimedia", sigChronometer);
            i.putExtra("ccGlobal",currentQuestionGlobal+1);
            chronometerSound.stop();
            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
            currentQuestionGlobal++;
            showQuestion();
        }
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