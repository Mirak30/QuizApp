package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    Spinner nQuest,dif;
    String opt[]={"5","10","15"}, name;
    String optDif[]={"Fácil","Difícil"};
    ImageButton goBack,bChangeName,bsound;
    int play;
    EditText changeName;
    Intent in, i;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapterDif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        nQuest = findViewById(R.id.spinnerNumberQuestions);
        dif = findViewById(R.id.spinnerQuest);
        goBack = findViewById(R.id.BGoBackOpt);
        bsound = findViewById(R.id.BSoundOn);
        changeName = findViewById(R.id.editTextPersonName);
        bChangeName = findViewById(R.id.BChangeName);
        name = Comunicador.getString();
        changeName.setText(name);
        play = (int) Comunicador.getInt();

        i=new Intent(this, Result.class);

        arrayAdapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,opt);
        nQuest.setAdapter(arrayAdapter);

        arrayAdapterDif=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,optDif);
        dif.setAdapter(arrayAdapterDif);

        confButton();
    }
    private void confButton(){

        bsound.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i = new Intent(Options.this, AudioService.class);
                  if(play == 1)
                  {
                      bsound.setImageResource(R.drawable.sonido_on);
                      i.putExtra("action", AudioService.START);
                      startService(i);
                      play = 0;
                  }
                  else
                  {
                      bsound.setImageResource(R.drawable.sonido_off);
                      i.putExtra("action", AudioService.STOP);
                      startService(i);
                      play = 1;
                  }
                    Comunicador.setInt(play);
              }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in=new Intent(Options.this,Category.class);
                in.putExtra("nQuest",Integer.parseInt(nQuest.getSelectedItem().toString()));
                Comunicador.setDif(dif.getSelectedItem().toString());
                Comunicador.setnQuest(Integer.parseInt(nQuest.getSelectedItem().toString()));
                finish();
                startActivity(in);
            }
        });

        bChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = String.valueOf(changeName.getText());
                Comunicador.setString(name);
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