package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class Questionsmultimedia extends AppCompatActivity {
    private ImageButton BExit;
    private ImageButton BPlay;
    Chronometer chronometerSound;
    private ImageView barra;
    private ImageButton BOp1, BOp2, BOp3, BOp4;
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
    boolean images;
    private VideoView video;
    long antChronometer;
    long sigChronometer = 0;
    MediaPlayer mMediaPlayer;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question_multimedia);
        cat=getIntent();
        //difficulty=opt.getStringExtra("Difficulty");
        //images=cat.getBooleanExtra("images",true);
        i=new Intent(Questionsmultimedia.this, Result.class);
        textQuestion = findViewById(R.id.textQuestion);
        textCorrect = findViewById(R.id.textPointCorrects);
        textIncorrect = findViewById(R.id.textPointsIncorrects);
        partialRes=cat.getIntExtra("result",0);
        partialResIncorrect = cat.getIntExtra("resultIncorrect",0);
        antChronometer = cat.getLongExtra("timeChronometerMultimedia",0);
        barra = findViewById(R.id.imageNumberQuestions);
        videoQuestions=(ArrayList<VideoQuestions>)cat.getSerializableExtra("videoQuest");
        chronometerSound=findViewById(R.id.chronometer);
        chronometerSound.setBase(SystemClock.elapsedRealtime()-antChronometer);
        chronometerSound.start();
        video=findViewById(R.id.videoQuestions);
        currentQuestion = 0;
        currentQuestionGlobal=cat.getIntExtra("ccGlobal",0);
        //answerIsCorrect = new boolean[imageQuestions.size()];

        showQuestion();
        configureButton();
    }

    private void showQuestion() {
        textCorrect.setText(Integer.toString(partialRes));
        textIncorrect.setText(Integer.toString(partialResIncorrect));
        VideoQuestions q = videoQuestions.get(currentQuestion);

        textQuestion.setText(q.getQuestion());
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + q.getVideo());

        video.setVideoURI(uri);
        video.start();

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                mMediaPlayer.setLooping(true);
            }
        });

        correctAnswer=q.getCorrectAnswer();
        TextView tb = (TextView) findViewById(id_answers[0]);
        tb.setText(q.getAnswer1());

        tb = (TextView) findViewById(id_answers[1]);
        tb.setText(q.getAnswer2());

        tb = (TextView) findViewById(id_answers[2]);
        tb.setText(q.getAnswer3());

        tb = (TextView) findViewById(id_answers[3]);
        tb.setText(q.getAnswer4());

        if(Comunicador.getnQuest()==5){
            barra.setImageResource(id_Questions5[currentQuestionGlobal+1]);

        }else if(Comunicador.getnQuest()==10) {
            barra.setImageResource(id_Questions10[currentQuestionGlobal+1]);

        }else if(Comunicador.getnQuest()==15){
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
                startActivity(new Intent(Questionsmultimedia.this, Category.class));
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

        if(currentQuestion == videoQuestions.size()-1)
        {
            i.putExtra("timeChronometerResult",sigChronometer);

            finish();
            startActivity(i);
        }else
        {
            currentQuestion++;
            currentQuestionGlobal++;
            showQuestion();
        }
    }
   /* @Override
    protected void onPause() {
        super.onPause();
        //pausar();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.START);
        startService(i);
    }*/
}