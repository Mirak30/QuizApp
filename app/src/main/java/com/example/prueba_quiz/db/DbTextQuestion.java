package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.TextQuestions;

import java.util.ArrayList;

public class DbTextQuestion extends DbHelper{
    Context context;
    int size = 0;
    public DbTextQuestion(@Nullable Context context, int size) {
        super(context);
        this.size=size;
        this.context = context;
    }
    public DbTextQuestion(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertEasyQuestionAnime(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer){
        long result = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EQuestionAnime", question);
            contentValues.put("EAnswerAnime1", answer1);
            contentValues.put("EAnswerAnime2", answer2);
            contentValues.put("EAnswerAnime3", answer3);
            contentValues.put("EAnswerAnime4", answer4);
            contentValues.put("ECorrectAnswerAnime", correctAnswer);

            result = db.insert(TABLE_EASYANIME, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }

        return result;
    }

    public long insertDifficultQuestionAnime(String question, String answer1,
                                             String answer2, String answer3, String answer4,
                                             String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DQuestionAnime", question);
            contentValues.put("DAnswerAnime1", answer1);
            contentValues.put("DAnswerAnime2", answer2);
            contentValues.put("DAnswerAnime3", answer3);
            contentValues.put("DAnswerAnime4", answer4);
            contentValues.put("DCorrectAnswerAnime", correctAnswer);
            result = db.insert(TABLE_DIFICULTANIME, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }

        return result;
    }

    public long insertEasyQuestionCine(String question, String answer1,
                                       String answer2, String answer3, String answer4,
                                       String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EQuestionCine", question);
            contentValues.put("EAnswerCine1", answer1);
            contentValues.put("EAnswerCine2", answer2);
            contentValues.put("EAnswerCine3", answer3);
            contentValues.put("EAnswerCine4", answer4);
            contentValues.put("ECorrectAnswerCine", correctAnswer);

            result = db.insert(TABLE_EASYCINE, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }
    public long insertDifficultQuestionCine(String question, String answer1,
                                            String answer2, String answer3, String answer4,
                                            String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DQuestionCine", question);
            contentValues.put("DAnswerCine1", answer1);
            contentValues.put("DAnswerCine2", answer2);
            contentValues.put("DAnswerCine3", answer3);
            contentValues.put("DAnswerCine4", answer4);
            contentValues.put("DCorrectAnswerCine", correctAnswer);

            result = db.insert(TABLE_DIFICULTCINE, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertEasyQuestionHistory(String question, String answer1,
                                          String answer2, String answer3, String answer4,
                                          String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EQuestionHistory", question);
            contentValues.put("EAnswerHistory1", answer1);
            contentValues.put("EAnswerHistory2", answer2);
            contentValues.put("EAnswerHistory3", answer3);
            contentValues.put("EAnswerHistory4", answer4);
            contentValues.put("ECorrectAnswerHistory", correctAnswer);

            result = db.insert(TABLE_EASYHISTORY, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }
    public long insertDifficultQuestionHistory(String question, String answer1,
                                               String answer2, String answer3, String answer4,
                                               String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DQuestionHistory", question);
            contentValues.put("DAnswerHistory1", answer1);
            contentValues.put("DAnswerHistory2", answer2);
            contentValues.put("DAnswerHistory3", answer3);
            contentValues.put("DAnswerHistory4", answer4);
            contentValues.put("DCorrectAnswerHistory", correctAnswer);

            result = db.insert(TABLE_DIFICULTHISTORY, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertEasyQuestionVideogames(String question, String answer1,
                                             String answer2, String answer3, String answer4,
                                             String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EQuestionVideogames", question);
            contentValues.put("EAnswerVideogames1", answer1);
            contentValues.put("EAnswerVideogames2", answer2);
            contentValues.put("EAnswerVideogames3", answer3);
            contentValues.put("EAnswerVideogames4", answer4);
            contentValues.put("ECorrectAnswerVideogames", correctAnswer);

            result = db.insert(TABLE_EASYVIDEOGAMES, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }
    public long insertDifficultQuestionVideogames(String question, String answer1,
                                                  String answer2, String answer3, String answer4,
                                                  String correctAnswer){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DQuestionVideogames", question);
            contentValues.put("DAnswerVideogames1", answer1);
            contentValues.put("DAnswerVideogames2", answer2);
            contentValues.put("DAnswerVideogames3", answer3);
            contentValues.put("DAnswerVideogames4", answer4);
            contentValues.put("DCorrectAnswerVideogames", correctAnswer);

            result = db.insert(TABLE_DIFICULTVIDEOGAMES, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public ArrayList<TextQuestions> showQuestions(String category)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<TextQuestions> listQuestion = new ArrayList<TextQuestions>();
        TextQuestions questions = null;
        Cursor cursorQuestions = null;

        if(size == 10)
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + category + " ORDER BY RANDOM() LIMIT 5" ,null);

        }else if(size == 15)
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + category + " ORDER BY RANDOM() LIMIT 10" ,null);

        }
        else
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + category + " ORDER BY RANDOM() LIMIT 2" ,null);
        }


        if(cursorQuestions.moveToFirst())
        {
         do{
             questions=new TextQuestions();
             questions.setId(cursorQuestions.getInt(0));
             questions.setQuestion(cursorQuestions.getString(1));
             questions.setAnswer1(cursorQuestions.getString(2));
             questions.setAnswer2(cursorQuestions.getString(3));
             questions.setAnswer3(cursorQuestions.getString(4));
             questions.setAnswer4(cursorQuestions.getString(5));
             questions.setCorrectAnswer(cursorQuestions.getString(6));

             listQuestion.add(questions);
         }while(cursorQuestions.moveToNext());
        }

        cursorQuestions.close();

        return listQuestion;
    }
}
