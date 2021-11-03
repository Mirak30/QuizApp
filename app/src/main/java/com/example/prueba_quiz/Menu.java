package com.example.prueba_quiz;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.VideoView;

import java.util.function.BinaryOperator;

public class Menu extends AppCompatActivity{

    ImageButton BExit, BStart, BRanking;
    EditText editName;
    private VideoView videoBg;
    MediaPlayer mMediaPlayer;
    int nCurrentVideoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoBg = (VideoView) findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fondo_v4);

        videoBg.setVideoURI(uri);
        videoBg.start();

        videoBg.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                mMediaPlayer.setLooping(true);
                if (nCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(nCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });

        editName = findViewById(R.id.editTextPersonName);

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
                startActivity(new Intent(Menu.this, Category.class));
            }
        });

        BRanking = findViewById(R.id.BRanking);
        BRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Menu.this, Ranking.class));
            }
        });
    }

}
