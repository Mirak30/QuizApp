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

    private static final int DATABASE_VERSION = 16;
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


    public static final String TABLE_EASYANIME_S = "t_EAnimeS";
    public static final String TABLE_DIFICULTANIME_S = "t_DAnimeS";
    public static final String TABLE_EASYCINE_S = "t_ECineS";
    public static final String TABLE_DIFICULTCINE_S = "t_DCineS";
    public static final String TABLE_EASYHISTORY_S = "t_EHistoryS";
    public static final String TABLE_DIFICULTHISTORY_S = "t_DHistoryS";
    public static final String TABLE_EASYVIDEOGAMES_S = "t_EVideogamesS";
    public static final String TABLE_DIFICULTVIDEOGAMES_S = "t_DVideogamesS";


    public static final String TABLE_EASYANIME_V = "t_EAnimeV";
    public static final String TABLE_DIFICULTANIME_V = "t_DAnimeV";
    public static final String TABLE_EASYCINE_V = "t_ECineV";
    public static final String TABLE_DIFICULTCINE_V = "t_DCineV";
    public static final String TABLE_EASYHISTORY_V = "t_EHistoryV";
    public static final String TABLE_DIFICULTHISTORY_V = "t_DHistoryV";
    public static final String TABLE_EASYVIDEOGAMES_V = "t_EVideogamesV";
    public static final String TABLE_DIFICULTVIDEOGAMES_V = "t_DVideogamesV";
    public static final String TABLE_RANKING = "t_Ranking";
    public static final String TABLE_OPTIONS = "t_Options";

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


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYVIDEOGAMES_S + "(" +
                "EVideogamesS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EVideogamesS_Quest TEXT NOT NULL," +
                "EVideogamesS_S INTEGER NOT NULL," +
                "EVideogamesS_Answ1 TEXT NOT NULL," +
                "EVideogamesS_Answ2 TEXT NOT NULL," +
                "EVideogamesS_Answ3 TEXT NOT NULL," +
                "EVideogamesS_Answ4 TEXT NOT NULL," +
                "EVideogamesS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYHISTORY_S + "(" +
                "EHistoryS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EHistoryS_Quest TEXT NOT NULL," +
                "EHistoryS_S INTEGER NOT NULL," +
                "EHistoryS_Answ1 TEXT NOT NULL," +
                "EHistoryS_Answ2 TEXT NOT NULL," +
                "EHistoryS_Answ3 TEXT NOT NULL," +
                "EHistoryS_Answ4 TEXT NOT NULL," +
                "EHistoryS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYCINE_S + "(" +
                "ECineS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ECineS_Quest TEXT NOT NULL," +
                "ECineS_S INTEGER NOT NULL," +
                "ECineS_Answ1 TEXT NOT NULL," +
                "ECineS_Answ2 TEXT NOT NULL," +
                "ECineS_Answ3 TEXT NOT NULL," +
                "ECineS_Answ4 TEXT NOT NULL," +
                "ECineS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYANIME_S + "(" +
                "EAnimeS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EAnimeS_Quest TEXT NOT NULL," +
                "EAnimeS_S INTEGER NOT NULL," +
                "EAnimeS_Answ1 TEXT NOT NULL," +
                "EAnimeS_Answ2 TEXT NOT NULL," +
                "EAnimeS_Answ3 TEXT NOT NULL," +
                "EAnimeS_Answ4 TEXT NOT NULL," +
                "EAnimeS_CorrectAnsw TEXT NOT NULL)"
        );


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTVIDEOGAMES_S + "(" +
                "DVideogamesS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DVideogamesS_Quest TEXT NOT NULL," +
                "DVideogamesS_S INTEGER NOT NULL," +
                "DVideogamesS_Answ1 TEXT NOT NULL," +
                "DVideogamesS_Answ2 TEXT NOT NULL," +
                "DVideogamesS_Answ3 TEXT NOT NULL," +
                "DVideogamesS_Answ4 TEXT NOT NULL," +
                "DVideogamesS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTANIME_S + "(" +
                "DAnimeS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DAnimeS_Quest TEXT NOT NULL," +
                "DAnimeS_S INTEGER NOT NULL," +
                "DAnimeS_Answ1 TEXT NOT NULL," +
                "DAnimeS_Answ2 TEXT NOT NULL," +
                "DAnimeS_Answ3 TEXT NOT NULL," +
                "DAnimeS_Answ4 TEXT NOT NULL," +
                "DAnimeS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTHISTORY_S + "(" +
                "DHistoryS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DHistoryS_Quest TEXT NOT NULL," +
                "DHistoryS_S INTEGER NOT NULL," +
                "DHistoryS_Answ1 TEXT NOT NULL," +
                "DHistoryS_Answ2 TEXT NOT NULL," +
                "DHistoryS_Answ3 TEXT NOT NULL," +
                "DHistoryS_Answ4 TEXT NOT NULL," +
                "DHistoryS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTCINE_S + "(" +
                "DCineS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DCineS_Quest TEXT NOT NULL," +
                "DCineS_S INTEGER NOT NULL," +
                "DCineS_Answ1 TEXT NOT NULL," +
                "DCineS_Answ2 TEXT NOT NULL," +
                "DCineS_Answ3 TEXT NOT NULL," +
                "DCineS_Answ4 TEXT NOT NULL," +
                "DCineS_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYANIME_V + "(" +
                "EAnimeV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EAnimeV_Quest TEXT NOT NULL," +
                "EAnimeV_V INTEGER NOT NULL," +
                "EAnimeV_Answ1 TEXT NOT NULL," +
                "EAnimeV_Answ2 TEXT NOT NULL," +
                "EAnimeV_Answ3 TEXT NOT NULL," +
                "EAnimeV_Answ4 TEXT NOT NULL," +
                "EAnimeV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYCINE_V + "(" +
                "ECineV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ECineV_Quest TEXT NOT NULL," +
                "ECineV_V INTEGER NOT NULL," +
                "ECineV_Answ1 TEXT NOT NULL," +
                "ECineV_Answ2 TEXT NOT NULL," +
                "ECineV_Answ3 TEXT NOT NULL," +
                "ECineV_Answ4 TEXT NOT NULL," +
                "ECineV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYHISTORY_V + "(" +
                "EHistoryV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EHistoryV_Quest TEXT NOT NULL," +
                "EHistoryV_V INTEGER NOT NULL," +
                "EHistoryV_Answ1 TEXT NOT NULL," +
                "EHistoryV_Answ2 TEXT NOT NULL," +
                "EHistoryV_Answ3 TEXT NOT NULL," +
                "EHistoryV_Answ4 TEXT NOT NULL," +
                "EHistoryV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EASYVIDEOGAMES_V + "(" +
                "EVideogamesV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EVideogamesV_Quest TEXT NOT NULL," +
                "EVideogamesV_V INTEGER NOT NULL," +
                "EVideogamesV_Answ1 TEXT NOT NULL," +
                "EVideogamesV_Answ2 TEXT NOT NULL," +
                "EVideogamesV_Answ3 TEXT NOT NULL," +
                "EVideogamesV_Answ4 TEXT NOT NULL," +
                "EVideogamesV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTANIME_V + "(" +
                "DAnimeV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DAnimeV_Quest TEXT NOT NULL," +
                "DAnimeV_V INTEGER NOT NULL," +
                "DAnimeV_Answ1 TEXT NOT NULL," +
                "DAnimeV_Answ2 TEXT NOT NULL," +
                "DAnimeV_Answ3 TEXT NOT NULL," +
                "DAnimeV_Answ4 TEXT NOT NULL," +
                "DAnimeV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTVIDEOGAMES_V + "(" +
                "DVideogamesV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DVideogamesV_Quest TEXT NOT NULL," +
                "DVideogamesV_V INTEGER NOT NULL," +
                "DVideogamesV_Answ1 TEXT NOT NULL," +
                "DVideogamesV_Answ2 TEXT NOT NULL," +
                "DVideogamesV_Answ3 TEXT NOT NULL," +
                "DVideogamesV_Answ4 TEXT NOT NULL," +
                "DVideogamesV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTHISTORY_V + "(" +
                "DHistoryV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DHistoryV_Quest TEXT NOT NULL," +
                "DHistoryV_V INTEGER NOT NULL," +
                "DHistoryV_Answ1 TEXT NOT NULL," +
                "DHistoryV_Answ2 TEXT NOT NULL," +
                "DHistoryV_Answ3 TEXT NOT NULL," +
                "DHistoryV_Answ4 TEXT NOT NULL," +
                "DHistoryV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DIFICULTCINE_V + "(" +
                "DCineV_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DCineV_Quest TEXT NOT NULL," +
                "DCineV_V INTEGER NOT NULL," +
                "DCineV_Answ1 TEXT NOT NULL," +
                "DCineV_Answ2 TEXT NOT NULL," +
                "DCineV_Answ3 TEXT NOT NULL," +
                "DCineV_Answ4 TEXT NOT NULL," +
                "DCineV_CorrectAnsw TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_RANKING+ "(" +
                "Player_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Player_NAME TEXT NOT NULL," +
                "Player_CORRECT INTEGER NOT NULL," +
                "Player_INCORRECT TEXT NOT NULL," +
                "Player_TIME INTEGER NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_OPTIONS+ "(" +
                "Option_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Option_NQUEST INTEGER NOT NULL," +
                "Option_DIFF INTEGER NOT NULL," +
                "Option_NAME TEXT NOT NULL," +
                "Option_AUDIO INTEGER NOT NULL)"
        );

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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYANIME_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYCINE_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYHISTORY_IMG);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTANIME_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTCINE_IMG);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTHISTORY_IMG);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTANIME_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTHISTORY_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTCINE_S);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYANIME_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYHISTORY_S);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYCINE_S);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTVIDEOGAMES_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTANIME_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTHISTORY_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DIFICULTCINE_V);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYVIDEOGAMES_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYANIME_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYHISTORY_V);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYCINE_V);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RANKING);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_OPTIONS);

        onCreate(sqLiteDatabase);
    }

}
