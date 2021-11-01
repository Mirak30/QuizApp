package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.MainActivity;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "questions.db";
    private static final String TABLE_EASYANIME = "t_EAnime";
    private static final String TABLE_DIFICULTANIME = "t_DAnime";
    private static final String TABLE_EASYCINE = "t_ECine";
    private static final String TABLE_DIFICULTCINE = "t_DCine";
    private static final String TABLE_EASYHISTORY = "t_EHistory";
    private static final String TABLE_DIFICULTHISTORY = "t_DHistory";
    private static final String TABLE_EASYVIDEOGAMES = "t_EVideogames";
    private static final String TABLE_DIFICULTVIDEOGAMES = "t_DVideogames";


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

    public boolean insertEasyQuestionAnime(String question, String answer1,
                                  String answer2, String answer3, String answer4,
                                  String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EQuestionAnime", question);
        contentValues.put("EAnswerAnime1", answer1);
        contentValues.put("EAnswerAnime2", answer2);
        contentValues.put("EAnswerAnime3", answer3);
        contentValues.put("EAnswerAnime4", answer4);
        contentValues.put("ECorrectAnswerAnime", correctAnswer);

        long result = db.insert(TABLE_EASYANIME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
             return true;
        }
    }
    public boolean insertDifficultQuestionAnime(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DQuestionAnime", question);
        contentValues.put("DAnswerAnime1", answer1);
        contentValues.put("DAnswerAnime2", answer2);
        contentValues.put("DAnswerAnime3", answer3);
        contentValues.put("DAnswerAnime4", answer4);
        contentValues.put("DCorrectAnswerAnime", correctAnswer);

        long result = db.insert(TABLE_DIFICULTANIME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertEasyQuestionCine(String question, String answer1,
                                           String answer2, String answer3, String answer4,
                                           String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EQuestionCine", question);
        contentValues.put("EAnswerCine1", answer1);
        contentValues.put("EAnswerCine2", answer2);
        contentValues.put("EAnswerCine3", answer3);
        contentValues.put("EAnswerCine4", answer4);
        contentValues.put("ECorrectAnswerCine", correctAnswer);

        long result = db.insert(TABLE_EASYCINE, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean insertDifficultQuestionCine(String question, String answer1,
                                                String answer2, String answer3, String answer4,
                                                String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DQuestionCine", question);
        contentValues.put("DAnswerCine1", answer1);
        contentValues.put("DAnswerCine2", answer2);
        contentValues.put("DAnswerCine3", answer3);
        contentValues.put("DAnswerCine4", answer4);
        contentValues.put("DCorrectAnswerCine", correctAnswer);

        long result = db.insert(TABLE_DIFICULTCINE, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertEasyQuestionHistory(String question, String answer1,
                                          String answer2, String answer3, String answer4,
                                          String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EQuestionHistory", question);
        contentValues.put("EAnswerHistory1", answer1);
        contentValues.put("EAnswerHistory2", answer2);
        contentValues.put("EAnswerHistory3", answer3);
        contentValues.put("EAnswerHistory4", answer4);
        contentValues.put("ECorrectAnswerHistory", correctAnswer);

        long result = db.insert(TABLE_EASYHISTORY, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean insertDifficultQuestionHistory(String question, String answer1,
                                               String answer2, String answer3, String answer4,
                                               String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DQuestionHistory", question);
        contentValues.put("DAnswerHistory1", answer1);
        contentValues.put("DAnswerHistory2", answer2);
        contentValues.put("DAnswerHistory3", answer3);
        contentValues.put("DAnswerHistory4", answer4);
        contentValues.put("DCorrectAnswerHistory", correctAnswer);

        long result = db.insert(TABLE_DIFICULTHISTORY, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean insertEasyQuestionVideogames(String question, String answer1,
                                             String answer2, String answer3, String answer4,
                                             String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EQuestionVideogames", question);
        contentValues.put("EAnswerVideogames1", answer1);
        contentValues.put("EAnswerVideogames2", answer2);
        contentValues.put("EAnswerVideogames3", answer3);
        contentValues.put("EAnswerVideogames4", answer4);
        contentValues.put("ECorrectAnswerVideogames", correctAnswer);

        long result = db.insert(TABLE_EASYVIDEOGAMES, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean insertDifficultQuestionVideogames(String question, String answer1,
                                                  String answer2, String answer3, String answer4,
                                                  String correctAnswer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DQuestionVideogames", question);
        contentValues.put("DAnswerVideogames1", answer1);
        contentValues.put("DAnswerVideogames2", answer2);
        contentValues.put("DAnswerVideogames3", answer3);
        contentValues.put("DAnswerVideogames4", answer4);
        contentValues.put("DCorrectAnswerVideogames", correctAnswer);

        long result = db.insert(TABLE_DIFICULTVIDEOGAMES, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
