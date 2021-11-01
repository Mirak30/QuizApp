package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.MainActivity;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "questions.db";
    private static final String TABLE_QUESTIONS = "t_questions";
    private static final String TABLE_EASYANIME = "t_EAnime";
    private static final String TABLE_DIFICULTANIME = "t_DAnime";
    private static final String TABLE_EASYCINE = "t_ECine";
    private static final String TABLE_DIFICULTCINE = "t_DCine";
    private static final String TABLE_EASYHISTORY = "t_EHistory";
    private static final String TABLE_DIFICULTHISTORY = "t_DHistory";
    private static final String TABLE_EASYVIDEOGAMES = "t_EVideogames";
    private static final String TABLE_DIFICULTVIDEOGAMES = "t_DVideogames";
    private static final String TABLE_CATEGORYANIME = "t_cAnime";
    private static final String TABLE_CATEGORYCINE = "t_cCine";
    private static final String TABLE_CATEGORYHISTORY = "t_cHistory";
    private static final String TABLE_CATEGORYVIDEOGAMES = "t_cVideogames";

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

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CATEGORYANIME + "(" +
                "EasyAnime_ID INTEGER," +
                "DificultAnime_ID INTEGER," +
                "CONSTRAINT PK_Anime_ID PRIMARY KEY (EasyAnime_ID, DificultAnime_ID),"+
                "FOREIGN KEY (EasyAnime_ID) REFERENCES " + TABLE_EASYANIME + "(EAnime_ID)," +
                "FOREIGN KEY (DificultAnime_ID) REFERENCES " + TABLE_DIFICULTANIME + "(DAnime_ID))");
       sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CATEGORYCINE + "(" +
                "EasyCine_ID INTEGER," +
                "DificultCine_ID INTEGER," +
                "CONSTRAINT PK_Cine_ID PRIMARY KEY (EasyCine_ID, DificultCine_ID),"+
                "FOREIGN KEY (EasyCine_ID) REFERENCES " + TABLE_EASYCINE + "(ECine_ID)," +
                "FOREIGN KEY (DificultCine_ID) REFERENCES " + TABLE_DIFICULTCINE + "(DCine_ID))");
       sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CATEGORYHISTORY + "(" +
                "EasyHistory_ID INTEGER," +
                "DificultHistory_ID INTEGER," +
                "CONSTRAINT PK_History_ID PRIMARY KEY (EasyHistory_ID, DificultHistory_ID),"+
                "FOREIGN KEY (EasyHistory_ID) REFERENCES " + TABLE_EASYHISTORY + "(EHistory_ID)," +
                "FOREIGN KEY (DificultHistory_ID) REFERENCES " + TABLE_DIFICULTHISTORY + "(DHistory_ID))");
       sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CATEGORYVIDEOGAMES + "(" +
                "EasyVideogames_ID INTEGER," +
                "DificultVideogames_ID INTEGER," +
                "CONSTRAINT PK_Videogames_ID PRIMARY KEY (EasyVideogames_ID, DificultVideogames_ID),"+
                "FOREIGN KEY (EasyVideogames_ID) REFERENCES " + TABLE_EASYVIDEOGAMES + "(EVideogames_ID)," +
                "FOREIGN KEY (DificultVideogames_ID) REFERENCES " + TABLE_DIFICULTVIDEOGAMES + "(DVideogames_ID))");

       sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_QUESTIONS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CAnime_ID INTEGER," +
                "CCine_ID INTEGER," +
                "CHistory_ID INTEGER," +
                "CVideogames_ID INTEGER," +
                "FOREIGN KEY (CAnime_ID) REFERENCES " + TABLE_CATEGORYANIME + "(PK_Anime_ID)," +
                "FOREIGN KEY (CCine_ID) REFERENCES " + TABLE_CATEGORYCINE + "(PK_Cine_ID)," +
                "FOREIGN KEY (CHistory_ID) REFERENCES " + TABLE_CATEGORYHISTORY + "(PK_History_ID)," +
                "FOREIGN KEY (CVideogames_ID) REFERENCES " + TABLE_CATEGORYVIDEOGAMES + "(PK_Videogames_ID))");

       //sqLiteDatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYANIME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTANIME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYCINE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTCINE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DIFICULTVIDEOGAMES);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EASYVIDEOGAMES);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CATEGORYANIME);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CATEGORYCINE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CATEGORYHISTORY);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CATEGORYVIDEOGAMES);
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
    public boolean insertCategoryAnime(Integer id_E, Integer id_D){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EasyAnime_ID", id_E);
        contentValues.put("DificultAnime_ID", id_D);

        long result = db.insert(TABLE_CATEGORYANIME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

}
