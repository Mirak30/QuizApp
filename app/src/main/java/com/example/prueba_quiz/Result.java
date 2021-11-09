package com.example.prueba_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.prueba_quiz.db.DbRanking;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton BExitFinal;
    ImageButton BReset;
    String name;
    ArrayList<Player> players;
    int result;
    int resultIncorrects;
    long chronometerResult;
    TextView textChronometerResult;
    DbRanking dbRanking;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        dbRanking=new DbRanking(this);
        result = getIntent().getIntExtra("result",0);
        resultIncorrects = getIntent().getIntExtra("resultIncorrect",0);
        TextView resultFinal = findViewById(R.id.textResult);
        TextView resultFinalIncorrect = findViewById(R.id.textPointsIncorrects);
        TextView nameResult = findViewById(R.id.textNameResult);
        String sc=Integer.toString(result);
        String si=Integer.toString(resultIncorrects);
        resultFinal.setText(sc);
        resultFinalIncorrect.setText(si);

        name = Comunicador.getString();
        nameResult = findViewById(R.id.textNameResult);
        nameResult.setText(name);
        play = (int) Comunicador.getInt();

        chronometerResult = getIntent().getLongExtra("timeChronometerResult",0)/1000;
        textChronometerResult = findViewById(R.id.textChronometerResult);
        textChronometerResult.setText(Long.toString(chronometerResult)+" s");

        dbRanking.insertPlayer(name,result,resultIncorrects,chronometerResult);
        players = dbRanking.showPlayers();
        recyclerView = findViewById(R.id.RecycleViewRanking);
        MyAdapter myAdapter = new MyAdapter(this, players);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        configureButton();
    }



    public void showRatingDialog(){
        String[] options={"Sí","No"};
        AlertDialog.Builder alert=new AlertDialog.Builder(Result.this);
        alert.setTitle("¿Disfrutaste de la aplicación?");
        alert.setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                finish();
                System.exit(0);
            }
        });
        alert.show();
    }

    public void configureButton()
    {
        BExitFinal = findViewById(R.id.BExitFinal);
        BExitFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRatingDialog();

            }
        });

        BReset = findViewById(R.id.BReset);
        BReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                startActivity(new Intent(Result.this, Category.class));
            }
        });

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