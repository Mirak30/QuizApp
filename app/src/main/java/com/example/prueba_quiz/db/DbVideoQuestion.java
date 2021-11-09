package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.ImageQuestions;
import com.example.prueba_quiz.SoundQuestions;
import com.example.prueba_quiz.TextQuestions;
import com.example.prueba_quiz.VideoQuestions;

import java.util.ArrayList;

public class DbVideoQuestion extends DbHelper {

    Context context;
    int size = 0;
    public DbVideoQuestion(@Nullable Context context, int size) {
        super(context);
        this.size=size;
        this.context = context;
    }
    public DbVideoQuestion(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertQuestionEAnimeV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EAnimeV_Quest", question);
            contentValues.put("EAnimeV_V", video);
            contentValues.put("EAnimeV_Answ1", answer1);
            contentValues.put("EAnimeV_Answ2", answer2);
            contentValues.put("EAnimeV_Answ3", answer3);
            contentValues.put("EAnimeV_Answ4", answer4);
            contentValues.put("EAnimeV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYANIME_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionEHistoryV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EHistoryV_Quest", question);
            contentValues.put("EHistoryV_V", video);
            contentValues.put("EHistoryV_Answ1", answer1);
            contentValues.put("EHistoryV_Answ2", answer2);
            contentValues.put("EHistoryV_Answ3", answer3);
            contentValues.put("EHistoryV_Answ4", answer4);
            contentValues.put("EHistoryV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYHISTORY_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionECineV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("ECineV_Quest", question);
            contentValues.put("ECineV_V", video);
            contentValues.put("ECineV_Answ1", answer1);
            contentValues.put("ECineV_Answ2", answer2);
            contentValues.put("ECineV_Answ3", answer3);
            contentValues.put("ECineV_Answ4", answer4);
            contentValues.put("ECineV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYCINE_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }






    public long insertQuestionEVideogamesV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EVideogamesV_Quest", question);
            contentValues.put("EVideogamesV_V", video);
            contentValues.put("EVideogamesV_Answ1", answer1);
            contentValues.put("EVideogamesV_Answ2", answer2);
            contentValues.put("EVideogamesV_Answ3", answer3);
            contentValues.put("EVideogamesV_Answ4", answer4);
            contentValues.put("EVideogamesV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYVIDEOGAMES_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionDAnimeV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DAnimeV_Quest", question);
            contentValues.put("DAnimeV_V", video);
            contentValues.put("DAnimeV_Answ1", answer1);
            contentValues.put("DAnimeV_Answ2", answer2);
            contentValues.put("DAnimeV_Answ3", answer3);
            contentValues.put("DAnimeV_Answ4", answer4);
            contentValues.put("DAnimeV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTANIME_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionDVideogamesV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DVideogamesV_Quest", question);
            contentValues.put("DVideogamesV_V", video);
            contentValues.put("DVideogamesV_Answ1", answer1);
            contentValues.put("DVideogamesV_Answ2", answer2);
            contentValues.put("DVideogamesV_Answ3", answer3);
            contentValues.put("DVideogamesV_Answ4", answer4);
            contentValues.put("DVideogamesV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTVIDEOGAMES_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDHistoryV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DHistoryV_Quest", question);
            contentValues.put("DHistoryV_V", video);
            contentValues.put("DHistoryV_Answ1", answer1);
            contentValues.put("DHistoryV_Answ2", answer2);
            contentValues.put("DHistoryV_Answ3", answer3);
            contentValues.put("DHistoryV_Answ4", answer4);
            contentValues.put("DHistoryV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTHISTORY_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDCineV(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int video){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DCineV_Quest", question);
            contentValues.put("DCineV_V", video);
            contentValues.put("DCineV_Answ1", answer1);
            contentValues.put("DCineV_Answ2", answer2);
            contentValues.put("DCineV_Answ3", answer3);
            contentValues.put("DCineV_Answ4", answer4);
            contentValues.put("DCineV_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTCINE_V, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public ArrayList<VideoQuestions> showQuestions(String table)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<VideoQuestions> listQuestion = new ArrayList<VideoQuestions>();
        VideoQuestions questions = null;
        Cursor cursorQuestions = null;


            cursorQuestions = db.rawQuery("SELECT * FROM " + table + " ORDER BY RANDOM() LIMIT 1" ,null);


        if(cursorQuestions.moveToFirst())
        {
            do{
                questions=new VideoQuestions();
                questions.setId(cursorQuestions.getInt(0));
                questions.setQuestion(cursorQuestions.getString(1));
                questions.setVideo(cursorQuestions.getInt(2));
                questions.setAnswer1(cursorQuestions.getString(3));
                questions.setAnswer2(cursorQuestions.getString(4));
                questions.setAnswer3(cursorQuestions.getString(5));
                questions.setAnswer4(cursorQuestions.getString(6));
                questions.setCorrectAnswer(cursorQuestions.getString(7));

                listQuestion.add(questions);
            }while(cursorQuestions.moveToNext());
        }

        cursorQuestions.close();

        return listQuestion;
    }

}

