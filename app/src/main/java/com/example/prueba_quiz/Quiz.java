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

public class Quiz extends AppCompatActivity {

    private ImageButton BExit;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
    Chronometer chronometerSound;
    private ImageView barra;
    private int id_answers[] = {R.id.textOp1, R.id.textOp2, R.id.textOp3, R.id.textOp4};
    private int id_Questions5[] = {R.drawable.barra_5_1, R.drawable.barra_5_2, R.drawable.barra_5_3, R.drawable.barra_5_4, R.drawable.barra_5_5};
    private int id_Questions10[] = {R.drawable.barra_10_1, R.drawable.barra_10_2, R.drawable.barra_10_3, R.drawable.barra_10_4, R.drawable.barra_10_5,
                                    R.drawable.barra_10_6, R.drawable.barra_10_7, R.drawable.barra_10_8, R.drawable.barra_10_9, R.drawable.barra_10_10};
    private int id_Questions15[] = {R.drawable.barra_15_1, R.drawable.barra_15_2, R.drawable.barra_15_3, R.drawable.barra_15_4, R.drawable.barra_15_5,
                                    R.drawable.barra_15_6, R.drawable.barra_15_7, R.drawable.barra_15_8, R.drawable.barra_15_9, R.drawable.barra_15_10,
                                    R.drawable.barra_15_11, R.drawable.barra_15_12, R.drawable.barra_15_13, R.drawable.barra_15_14, R.drawable.barra_15_15};
    private String correctAnswer;
    private ArrayList<TextQuestions> textQuestions;
    private ArrayList<ImageQuestions> imageQuestions;
    private ArrayList<SoundQuestions> soundQuestions;
    private ArrayList<VideoQuestions> videoQuestions;
    private boolean[] answerIsCorrect;
    private int currentQuestion;
    private TextView textQuestion;
    private TextView textCorrect;
    private TextView textIncorrect;
    private int partialRes;
    private int partialResIncorrect;
    boolean correct = false;
    Intent i,cat;
    String difficulty;
    boolean images;
    long sigChronometer = 0;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cat=getIntent();
        //difficulty=opt.getStringExtra("Difficulty");

            i=new Intent(Quiz.this, QuizQuestionImages.class);

        //i.putExtra("Difficulty",difficulty);
        textQuestion = findViewById(R.id.textQuestion);
        textCorrect = findViewById(R.id.textPointCorrects);
        textIncorrect = findViewById(R.id.textPointsIncorrects);
        barra = findViewById(R.id.ImageNumberQuestions);
        play = (int) Comunicador.getInt();
        textQuestions =(ArrayList<TextQuestions>)cat.getSerializableExtra("textQuest");
        imageQuestions =(ArrayList<ImageQuestions>)cat.getSerializableExtra("imgQuest");
        soundQuestions =(ArrayList<SoundQuestions>)cat.getSerializableExtra("soundQuest");
        videoQuestions =(ArrayList<VideoQuestions>)cat.getSerializableExtra("videoQuest");
        /*if(difficulty.equals("Easy")){
            allQuestions = getResources().getStringArray(R.array.easyQuestions);
        }else if(difficulty.equals("Difficult")){
            allQuestions = getResources().getStringArray(R.array.diffQuestions);
        }*/
        chronometerSound=findViewById(R.id.chronometer);
        chronometerSound.setBase(SystemClock.elapsedRealtime());
        chronometerSound.start();

        currentQuestion = 0;
        //answerIsCorrect = new boolean[textQuestions.size()];
        partialRes = 0;
        partialResIncorrect = 0;

        showQuestion();
        configureButton();
    }

    private void showQuestion() {
        textCorrect.setText(Integer.toString(partialRes));
        textIncorrect.setText(Integer.toString(partialResIncorrect));
        TextQuestions q = textQuestions.get(currentQuestion);
        //String[] parts = q.split(";");

        textQuestion.setText(q.getQuestion());
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
            barra.setImageResource(id_Questions5[currentQuestion]);

        }else if(cat.getIntExtra("nQuest",5)==10) {
            barra.setImageResource(id_Questions10[currentQuestion]);

        }else if(cat.getIntExtra("nQuest",5)==15){
            barra.setImageResource(id_Questions15[currentQuestion]);

        }
        //textQuestion.setText(parts[0]);

        /*textCorrect.setText(Integer.toString(partialRes));
        textIncorrect.setText(Integer.toString(partialResIncorrect));*/

        /*for(int i=0; i < id_answers.length; i++)
        {
            TextView tb = (TextView) findViewById(id_answers[i]);
            String answer = parts[i+1];
            if(answer.charAt(0) == '*')
            {
                correctAnswer = i;
                answer = answer.substring(1);
            }

            tb.setText(answer);
        }*/
    }

    public void configureButton()
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
            i.putExtra("result", partialRes);
            i.putExtra("resultIncorrect", partialResIncorrect);

        }
        else {
            Toast.makeText(this,R.string.incorrectAnswer,Toast.LENGTH_SHORT).show();
            partialResIncorrect++;
            i.putExtra("resultIncorrect", partialResIncorrect);
            i.putExtra("result", partialRes);
        }

        if(currentQuestion == textQuestions.size()-1)
        {
            i.putExtra("currentQuest",currentQuestion);
            i.putExtra("nQuest",cat.getIntExtra("nQuest",5));
            i.putExtra("imgQuest",imageQuestions);
            i.putExtra("soundQuest",soundQuestions);
            i.putExtra("videoQuest",videoQuestions);
            i.putExtra("ccGlobal",currentQuestion);
            sigChronometer = SystemClock.elapsedRealtime() - chronometerSound.getBase();
            i.putExtra("timeChronometerMultimedia", sigChronometer);
            chronometerSound.stop();
            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
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