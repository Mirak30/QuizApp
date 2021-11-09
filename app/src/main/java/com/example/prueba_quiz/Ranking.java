package com.example.prueba_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba_quiz.db.DbRanking;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {
    ArrayList<Player> players;
    DbRanking ranking;
    RecyclerView recyclerView;
    ImageButton goBack;
    int play;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        ranking=new DbRanking(this);
        players=ranking.showPlayers();
        recyclerView = findViewById(R.id.RecycleViewRanking);

        play = (int) Comunicador.getInt();
        MyAdapter myAdapter = new MyAdapter(this, players);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        configureButton();
    }

    public void configureButton()
    {
        goBack = findViewById(R.id.BExitQuiz);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Ranking.this, Menu.class));
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
