package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.MainActivity;
import com.example.prueba_quiz.TextQuestions;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "questions.db";
    public static final String TABLE_EASYANIME = "t_EAnime";
    public static final String TABLE_DIFICULTANIME = "t_DAnime";
    public static final String TABLE_EASYCINE = "t_ECine";
    public static final String TABLE_DIFICULTCINE = "t_DCine";
    public static final String TABLE_EASYHISTORY = "t_EHistory";
    public static final String TABLE_DIFICULTHISTORY = "t_DHistory";
    public static final String TABLE_EASYVIDEOGAMES = "t_EVideogames";
    public static final String TABLE_DIFICULTVIDEOGAMES = "t_DVideogames";

    public DbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYANIME + "(" +
                "EAnime_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EQuestionAnime TEXT NOT NULL," +
                "EAnswerAnime1 TEXT NOT NULL," +
                "EAnswerAnime2 TEXT NOT NULL," +
                "EAnswerAnime3 TEXT NOT NULL," +
                "EAnswerAnime4 TEXT NOT NULL," +
                "ECorrectAnswerAnime TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTANIME + "(" +
                "DAnime_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DQuestionAnime TEXT NOT NULL," +
                "DAnswerAnime1 TEXT NOT NULL," +
                "DAnswerAnime2 TEXT NOT NULL," +
                "DAnswerAnime3 TEXT NOT NULL," +
                "DAnswerAnime4 TEXT NOT NULL," +
                "DCorrectAnswerAnime TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYCINE + "(" +
                "ECine_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EQuestionCine TEXT NOT NULL," +
                "EAnswerCine1 TEXT NOT NULL," +
                "EAnswerCine2 TEXT NOT NULL," +
                "EAnswerCine3 TEXT NOT NULL," +
                "EAnswerCine4 TEXT NOT NULL," +
                "ECorrectAnswerCine TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTCINE + "(" +
                "DCine_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DQuestionCine TEXT NOT NULL," +
                "DAnswerCine1 TEXT NOT NULL," +
                "DAnswerCine2 TEXT NOT NULL," +
                "DAnswerCine3 TEXT NOT NULL," +
                "DAnswerCine4 TEXT NOT NULL," +
                "DCorrectAnswerCine TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYHISTORY + "(" +
                "EHistory_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EQuestionHistory TEXT NOT NULL," +
                "EAnswerHistory1 TEXT NOT NULL," +
                "EAnswerHistory2 TEXT NOT NULL," +
                "EAnswerHistory3 TEXT NOT NULL," +
                "EAnswerHistory4 TEXT NOT NULL," +
                "ECorrectAnswerHistory TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTHISTORY + "(" +
                "DHistory_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DQuestionHistory TEXT NOT NULL," +
                "DAnswerHistory1 TEXT NOT NULL," +
                "DAnswerHistory2 TEXT NOT NULL," +
                "DAnswerHistory3 TEXT NOT NULL," +
                "DAnswerHistory4 TEXT NOT NULL," +
                "DCorrectAnswerHistory TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYVIDEOGAMES + "(" +
                "EVideogames_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EQuestionVideogames TEXT NOT NULL," +
                "EAnswerVideogames1 TEXT NOT NULL," +
                "EAnswerVideogames2 TEXT NOT NULL," +
                "EAnswerVideogames3 TEXT NOT NULL," +
                "EAnswerVideogames4 TEXT NOT NULL," +
                "ECorrectAnswerVideogames TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTVIDEOGAMES + "(" +
                "DVideogames_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DQuestionVideogames TEXT NOT NULL," +
                "DAnswerVideogames1 TEXT NOT NULL," +
                "DAnswerVideogames2 TEXT NOT NULL," +
                "DAnswerVideogames3 TEXT NOT NULL," +
                "DAnswerVideogames4 TEXT NOT NULL," +
                "DCorrectAnswerVideogames TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYANIME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTANIME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYCINE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTCINE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTVIDEOGAMES);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYVIDEOGAMES);
        onCreate(sqLiteDatabase);
    }

}
