package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.ImageQuestions;
import com.example.prueba_quiz.SoundQuestions;
import com.example.prueba_quiz.TextQuestions;

import java.util.ArrayList;

public class DbSoundQuestion extends DbHelper {

    Context context;
    int size = 0;
    public DbSoundQuestion(@Nullable Context context, int size) {
        super(context);
        this.size=size;
        this.context = context;
    }
    public DbSoundQuestion(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertQuestionEAnimeS(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EAnimeS_Quest", question);
            contentValues.put("EAnimeS_S", sound);
            contentValues.put("EAnimeS_Answ1", answer1);
            contentValues.put("EAnimeS_Answ2", answer2);
            contentValues.put("EAnimeS_Answ3", answer3);
            contentValues.put("EAnimeS_Answ4", answer4);
            contentValues.put("EAnimeS_CorrectAnsw", correctAnswer);
          result = db.insert(TABLE_EASYANIME_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionECineS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("ECineS_Quest", question);
            contentValues.put("ECineS_S", sound);
            contentValues.put("ECineS_Answ1", answer1);
            contentValues.put("ECineS_Answ2", answer2);
            contentValues.put("ECineS_Answ3", answer3);
            contentValues.put("ECineS_Answ4", answer4);
            contentValues.put("ECineS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYCINE_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionEHistoryS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EHistoryS_Quest", question);
            contentValues.put("EHistoryS_S", sound);
            contentValues.put("EHistoryS_Answ1", answer1);
            contentValues.put("EHistoryS_Answ2", answer2);
            contentValues.put("EHistoryS_Answ3", answer3);
            contentValues.put("EHistoryS_Answ4", answer4);
            contentValues.put("EHistoryS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYHISTORY_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }






    public long insertQuestionEVideogamesS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EVideogamesS_Quest", question);
            contentValues.put("EVideogamesS_S", sound);
            contentValues.put("EVideogamesS_Answ1", answer1);
            contentValues.put("EVideogamesS_Answ2", answer2);
            contentValues.put("EVideogamesS_Answ3", answer3);
            contentValues.put("EVideogamesS_Answ4", answer4);
            contentValues.put("EVideogamesS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_EASYVIDEOGAMES_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionDAnimeS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DAnimeS_Quest", question);
            contentValues.put("DAnimeS_S", sound);
            contentValues.put("DAnimeS_Answ1", answer1);
            contentValues.put("DAnimeS_Answ2", answer2);
            contentValues.put("DAnimeS_Answ3", answer3);
            contentValues.put("DAnimeS_Answ4", answer4);
            contentValues.put("DAnimeS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTANIME_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionDVideogamesS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DVideogamesS_Quest", question);
            contentValues.put("DVideogamesS_S", sound);
            contentValues.put("DVideogamesS_Answ1", answer1);
            contentValues.put("DVideogamesS_Answ2", answer2);
            contentValues.put("DVideogamesS_Answ3", answer3);
            contentValues.put("DVideogamesS_Answ4", answer4);
            contentValues.put("DVideogamesS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTVIDEOGAMES_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDCineS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DCineS_Quest", question);
            contentValues.put("DCineS_S", sound);
            contentValues.put("DCineS_Answ1", answer1);
            contentValues.put("DCineS_Answ2", answer2);
            contentValues.put("DCineS_Answ3", answer3);
            contentValues.put("DCineS_Answ4", answer4);
            contentValues.put("DCineS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTCINE_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDHistoryS(String question, String answer1,
                                      String answer2, String answer3, String answer4,
                                      String correctAnswer,int sound){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DHistoryS_Quest", question);
            contentValues.put("DHistoryS_S", sound);
            contentValues.put("DHistoryS_Answ1", answer1);
            contentValues.put("DHistoryS_Answ2", answer2);
            contentValues.put("DHistoryS_Answ3", answer3);
            contentValues.put("DHistoryS_Answ4", answer4);
            contentValues.put("DHistoryS_CorrectAnsw", correctAnswer);
            result = db.insert(TABLE_DIFICULTHISTORY_S, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public ArrayList<SoundQuestions> showQuestions(String table)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<SoundQuestions> listQuestion = new ArrayList<SoundQuestions>();
        SoundQuestions questions = null;
        Cursor cursorQuestions = null;

            cursorQuestions = db.rawQuery("SELECT * FROM " + table + " ORDER BY RANDOM() LIMIT 1" ,null);


        if(cursorQuestions.moveToFirst())
        {
            do{
                questions=new SoundQuestions();
                questions.setId(cursorQuestions.getInt(0));
                questions.setQuestion(cursorQuestions.getString(1));
                questions.setSound(cursorQuestions.getInt(2));
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
