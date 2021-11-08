package com.example.prueba_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton BExitFinal;
    ImageButton BReset;
    String s1[], s2[], name;
    int result;
    int resultIncorrects;
    long chronometerResult;
    TextView textChronometerResult;
    int play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = getIntent().getIntExtra("result",0);
        resultIncorrects = getIntent().getIntExtra("resultIncorrect",0);
        TextView resultFinal = findViewById(R.id.textResult);
        TextView resultFinalIncorrect = findViewById(R.id.textPointsIncorrects);
        TextView nameResult = findViewById(R.id.textNameResult);
        String sc=Integer.toString(result);
        String si=Integer.toString(resultIncorrects);
        resultFinal.setText(sc);
        resultFinalIncorrect.setText(si);
        recyclerView = findViewById(R.id.RecycleViewRanking);
        name = Comunicador.getString();
        nameResult = findViewById(R.id.textNameResult);
        nameResult.setText(name);
        play = (int) Comunicador.getInt();
        s1 = getResources().getStringArray(R.array.nameRanking);
        s2 = getResources().getStringArray(R.array.resultRanking);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chronometerResult = SystemClock.elapsedRealtime() - getIntent().getLongExtra("timeChronometerResult",0);
        textChronometerResult = findViewById(R.id.textChronometerResult);
        textChronometerResult.setText(Long.toString(chronometerResult));

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