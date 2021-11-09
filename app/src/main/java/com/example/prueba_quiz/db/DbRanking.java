package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.Player;
import com.example.prueba_quiz.VideoQuestions;

import java.util.ArrayList;

public class DbRanking extends DbHelper{

    Context context;
    int size = 0;
    public DbRanking(@Nullable Context context, int size) {
        super(context);
        this.size=size;
        this.context = context;
    }
    public DbRanking(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public long insertPlayer(String name, int correct,
                                     int incorrect, long seconds){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("Player_NAME", name);
            contentValues.put("Player_CORRECT", correct);
            contentValues.put("Player_INCORRECT", incorrect);
            contentValues.put("Player_TIME", seconds);

            result = db.insert(TABLE_RANKING, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public ArrayList<Player> showPlayers()
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Player> players = new ArrayList<>();

        Cursor cursorQuestions = null;


        cursorQuestions = db.rawQuery("SELECT * FROM " + TABLE_RANKING + " ORDER BY Player_CORRECT DESC" ,null);


        if(cursorQuestions.moveToFirst())
        {
            do{
                Player player =new Player();
                player.setId(cursorQuestions.getInt(0));
                player.setName(cursorQuestions.getString(1));
                player.setCorrect(cursorQuestions.getInt(2));
                player.setIncorrect(cursorQuestions.getInt(3));
                player.setSeconds(cursorQuestions.getInt(4));

                players.add(player);
            }while(cursorQuestions.moveToNext());
        }

        cursorQuestions.close();

        return players;
    }

}
