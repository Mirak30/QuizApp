package com.example.prueba_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    ImageButton BExitFinal;
    ImageButton BReset;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = getIntent().getIntExtra("result",0);
        TextView resultFinal = findViewById(R.id.textResult);
        String s=Integer.toString(result);
        resultFinal.setText(s);

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
                startActivity(new Intent(Result.this, Options.class));
            }
        });

    }
}