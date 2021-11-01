package com.example.prueba_quiz;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity{

    ImageButton BExit, BStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BExit = findViewById(R.id.ButtonExit);
        BExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        BStart = findViewById(R.id.ButtomStart);
        BStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Menu.this, Options.class));
            }
        });
    }

}
