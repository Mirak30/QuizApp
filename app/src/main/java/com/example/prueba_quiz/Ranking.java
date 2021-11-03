package com.example.prueba_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Ranking extends AppCompatActivity {
    String s1[], s2[];
    RecyclerView recyclerView;
    ImageButton goBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = findViewById(R.id.RecycleViewRanking);
        s1 = getResources().getStringArray(R.array.nameRanking);
        s2 = getResources().getStringArray(R.array.resultRanking);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2);
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

}
