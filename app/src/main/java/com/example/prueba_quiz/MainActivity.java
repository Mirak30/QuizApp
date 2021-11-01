package com.example.prueba_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba_quiz.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    ImageButton BExit, BStart;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHelper(this);
        db.insertEasyQuestionAnime("¿Cuál es el apellido de Edward en 'Fullmetal Alchemist'?", "Elmac",
        "Elrond", "Elric", "Edmod", "Elric");
        db.insertEasyQuestionAnime("¿Cuál es el EVA que pilota Shinji en 'Neon Genesis Evangelion'?", "Unidad 02",
                "Unidad 01", "Unidad 00", "Unidad 03", "Unidad 01");
        db.insertEasyQuestionAnime("¿Qué busca Inuyasha?", "Una espada","Una persona","Un libro",
                "Una joya", "Una joya");
        db.insertEasyQuestionAnime("¿Cuál es el verdadero nombre de Kira en 'Death Note'?", "Light Yagami",
                "Ryuk Yagami", "L", "N", "Light Yagami");
        db.insertEasyQuestionAnime("¿Cuál es el nombre japonés de Ash Ketchum?", "Yuji",
                "Shinji", "Satoshi", "Yuki", "Satoshi");
        db.insertEasyQuestionAnime("¿Cuál es el apellido de Sakura en 'Sakura Card Captor'?", "Kinomoto",
                "Sakamoto", "Lee", "Daidouji", "Kinomoto");
        db.insertEasyQuestionAnime("¿Cuál de estos no es un villano de 'Dragon Ball Z'?", "Cell",
                "Krilin", "Freezer", "Majin Buu", "Krilin");
        db.insertEasyQuestionAnime("¿Cómo se llama el familiar de Rin de 'Ao no Exorcist'?", "Shiro",
                "Black", "Kuro", "Leo", "Kuro");
        db.insertEasyQuestionAnime("¿Cómo se llama el dios del mundo de 'No game no Life'?", "Tet",
                "Shiro", "Sora", "Stephanie", "Tet");
        db.insertEasyQuestionAnime("¿Cuánto tiempo pasa desde la muerte de Menma hasta su regreso?", "5 años",
                "10 años", "11 años", "8 años", "10 años");

        db.insertDifficultQuestionAnime("¿Qué 'Akuma no mi' no existe en el mundo de 'One Piece'?", "Lolo Lolo no mi",
                "Ato Ato no mi", "Buki Buki no mi", "Horu Horu no mi", "Lolo Lolo no mi");
        db.insertDifficultQuestionAnime("¿De qué raza es Shiki Natsumezaka de 'Dance with Devils'?", "Ángel Caído",
                "Demonio", "Vampiro", "Exorcista", "Ángel Caído");
        db.insertDifficultQuestionAnime("En 'Hunter X Hunter', ¿cómo se llama el juego donde Meruem no consigue vencer a Komugi?",
                "Go", "MahHong","Shogi", "Gungi", "Gungi");
        db.insertDifficultQuestionAnime("De 'Mirai Nikki',¿quién es el primer Dueño de Diario en morir?", "La sexta, Tusbaki Kasugano",
                "El undécimo, John Balks","El tercero, Takao Hiyama", "La octava, Kamado Ueshita", "El tercero, Takao Hiyama");
        db.insertDifficultQuestionAnime("¿Cuántas transformaciones tiene Lagann de 'Tengen Toppa Gurren-Lagann'?", "7",
                "3","5", "8", "7");
        db.insertDifficultQuestionAnime("¿De cuántas formas distintas puede poner la cara Koro-sensei de 'Assassination Classroom'?",
                "10", "9","8", "6", "9");
        db.insertDifficultQuestionAnime("¿Qué clase de Diosa es Kofuku de 'Noragami'?", "Diosa de la Guerra",
                "Diosa de la fortuna","Diosa de la calamidad", "Diosa de la pobreza", "Diosa de la pobreza");
        db.insertDifficultQuestionAnime("En 'Death Parade', ¿por qué razón llegó Chiyuki a Quindecim?", "Tuvo un accidente",
                "Se suicido","En una operación", "En un incendio", "Se suicido");
        db.insertDifficultQuestionAnime("¿Cuántos Djinn tiene Sinbad de 'Magi'?", "8",
                "7","6", "9", "7");
        db.insertDifficultQuestionAnime("En 'Fairy Tail', ¿qué era Acnologia antes de ser un Dragón?", "Humano",
                "Dragón","Demonio", "Espíritu Celestial", "Humano");

        db.insertCategoryAnime(0,0);
        db.insertCategoryAnime(1,1);
        db.insertCategoryAnime(2,2);
        db.insertCategoryAnime(3,3);
        db.insertCategoryAnime(4,4);
        db.insertCategoryAnime(5,5);
        db.insertCategoryAnime(6,6);
        db.insertCategoryAnime(7,7);
        db.insertCategoryAnime(8,8);
        db.insertCategoryAnime(9,9);
        db.insertCategoryAnime(10,10);

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
                startActivity(new Intent(MainActivity.this, Options.class));
            }
        });

    }
}