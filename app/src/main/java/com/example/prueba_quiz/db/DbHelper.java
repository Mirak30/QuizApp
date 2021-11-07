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

    private static final int DATABASE_VERSION = 10;
    private static final String DATABASE_NAME = "questions.db";
    public static final String TABLE_EASYANIME = "t_EAnime";
    public static final String TABLE_DIFICULTANIME = "t_DAnime";
    public static final String TABLE_EASYCINE = "t_ECine";
    public static final String TABLE_DIFICULTCINE = "t_DCine";
    public static final String TABLE_EASYHISTORY = "t_EHistory";
    public static final String TABLE_DIFICULTHISTORY = "t_DHistory";
    public static final String TABLE_EASYVIDEOGAMES = "t_EVideogames";
    public static final String TABLE_DIFICULTVIDEOGAMES = "t_DVideogames";

    public static final String TABLE_EASYANIME_IMG = "t_EAnimeIMG";
    public static final String TABLE_DIFICULTANIME_IMG = "t_DAnimeIMG";
    public static final String TABLE_EASYCINE_IMG = "t_ECineIMG";
    public static final String TABLE_DIFICULTCINE_IMG = "t_DCineIMG";
    public static final String TABLE_EASYHISTORY_IMG = "t_EHistoryIMG";
    public static final String TABLE_DIFICULTHISTORY_IMG = "t_DHistoryIMG";
    public static final String TABLE_EASYVIDEOGAMES_IMG = "t_EVideogamesIMG";
    public static final String TABLE_DIFICULTVIDEOGAMES_IMG = "t_DVideogamesIMG";

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


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYANIME_IMG + "(" +
                "EAnimeImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EAnimeImg_Quest TEXT NOT NULL," +
                "EAnimeImg_Img INTEGER NOT NULL," +
                "EAnimeImg_Answ1 TEXT NOT NULL," +
                "EAnimeImg_Answ2 TEXT NOT NULL," +
                "EAnimeImg_Answ3 TEXT NOT NULL," +
                "EAnimeImg_Answ4 TEXT NOT NULL," +
                "EAnimeImg_CorrectAnsw TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTANIME_IMG + "(" +
                "DAnimeImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DAnimeImg_Quest TEXT NOT NULL," +
                "DAnimeImg_Img INTEGER NOT NULL," +
                "DAnimeImg_Answ1 TEXT NOT NULL," +
                "DAnimeImg_Answ2 TEXT NOT NULL," +
                "DAnimeImg_Answ3 TEXT NOT NULL," +
                "DAnimeImg_Answ4 TEXT NOT NULL," +
                "DAnimeImg_CorrectAnsw TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTVIDEOGAMES_IMG + "(" +
                "DVideogamesImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DVideogamesImg_Quest TEXT NOT NULL," +
                "DVideogamesImg_Img INTEGER NOT NULL," +
                "DVideogamesImg_Answ1 TEXT NOT NULL," +
                "DVideogamesImg_Answ2 TEXT NOT NULL," +
                "DVideogamesImg_Answ3 TEXT NOT NULL," +
                "DVideogamesImg_Answ4 TEXT NOT NULL," +
                "DVideogamesImg_CorrectAnsw TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTCINE_IMG + "(" +
                "DCineImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DCineImg_Quest TEXT NOT NULL," +
                "DCineImg_Img INTEGER NOT NULL," +
                "DCineImg_Answ1 TEXT NOT NULL," +
                "DCineImg_Answ2 TEXT NOT NULL," +
                "DCineImg_Answ3 TEXT NOT NULL," +
                "DCineImg_Answ4 TEXT NOT NULL," +
                "DCineImg_CorrectAnsw TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTHISTORY_IMG + "(" +
                "DHistoryImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DHistoryImg_Quest TEXT NOT NULL," +
                "DHistoryImg_Img INTEGER NOT NULL," +
                "DHistoryImg_Answ1 TEXT NOT NULL," +
                "DHistoryImg_Answ2 TEXT NOT NULL," +
                "DHistoryImg_Answ3 TEXT NOT NULL," +
                "DHistoryImg_Answ4 TEXT NOT NULL," +
                "DHistoryImg_CorrectAnsw TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYCINE_IMG + "(" +
                "ECineImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ECineImg_Quest TEXT NOT NULL," +
                "ECineImg_Img INTEGER NOT NULL," +
                "ECineImg_Answ1 TEXT NOT NULL," +
                "ECineImg_Answ2 TEXT NOT NULL," +
                "ECineImg_Answ3 TEXT NOT NULL," +
                "ECineImg_Answ4 TEXT NOT NULL," +
                "ECineImg_CorrectAnsw TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYHISTORY_IMG + "(" +
                "EHistoryImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EHistoryImg_Quest TEXT NOT NULL," +
                "EHistoryImg_Img INTEGER NOT NULL," +
                "EHistoryImg_Answ1 TEXT NOT NULL," +
                "EHistoryImg_Answ2 TEXT NOT NULL," +
                "EHistoryImg_Answ3 TEXT NOT NULL," +
                "EHistoryImg_Answ4 TEXT NOT NULL," +
                "EHistoryImg_CorrectAnsw TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYVIDEOGAMES_IMG + "(" +
                "EVideogamesImg_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EVideogamesImg_Quest TEXT NOT NULL," +
                "EVideogamesImg_Img INTEGER NOT NULL," +
                "EVideogamesImg_Answ1 TEXT NOT NULL," +
                "EVideogamesImg_Answ2 TEXT NOT NULL," +
                "EVideogamesImg_Answ3 TEXT NOT NULL," +
                "EVideogamesImg_Answ4 TEXT NOT NULL," +
                "EVideogamesImg_CorrectAnsw TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYANIME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTANIME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYCINE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTCINE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_IMG);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_IMG);

        onCreate(sqLiteDatabase);
    }

}
