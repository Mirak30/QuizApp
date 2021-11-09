package com.example.prueba_quiz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba_quiz.ImageQuestions;
import com.example.prueba_quiz.TextQuestions;

import java.util.ArrayList;

public class DbImageQuestion extends DbHelper {

    Context context;
    int size = 0;
    public DbImageQuestion(@Nullable Context context, int size) {
        super(context);
        this.size=size;
        this.context = context;
    }
    public DbImageQuestion(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertQuestionEAnimeImg(String question, String answer1,
                                            String answer2, String answer3, String answer4,
                                            String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EAnimeImg_Quest", question);
            contentValues.put("EAnimeImg_Img", image);
            contentValues.put("EAnimeImg_Answ1", answer1);
            contentValues.put("EAnimeImg_Answ2", answer2);
            contentValues.put("EAnimeImg_Answ3", answer3);
            contentValues.put("EAnimeImg_Answ4", answer4);
            contentValues.put("EAnimeImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_EASYANIME_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionECineImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("ECineImg_Quest", question);
            contentValues.put("ECineImg_Img", image);
            contentValues.put("ECineImg_Answ1", answer1);
            contentValues.put("ECineImg_Answ2", answer2);
            contentValues.put("ECineImg_Answ3", answer3);
            contentValues.put("ECineImg_Answ4", answer4);
            contentValues.put("ECineImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_EASYCINE_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionEHistoryImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EHistoryImg_Quest", question);
            contentValues.put("EHistoryImg_Img", image);
            contentValues.put("EHistoryImg_Answ1", answer1);
            contentValues.put("EHistoryImg_Answ2", answer2);
            contentValues.put("EHistoryImg_Answ3", answer3);
            contentValues.put("EHistoryImg_Answ4", answer4);
            contentValues.put("EHistoryImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_EASYHISTORY_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }






    public long insertQuestionEVideogamesImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("EVideogamesImg_Quest", question);
            contentValues.put("EVideogamesImg_Img", image);
            contentValues.put("EVideogamesImg_Answ1", answer1);
            contentValues.put("EVideogamesImg_Answ2", answer2);
            contentValues.put("EVideogamesImg_Answ3", answer3);
            contentValues.put("EVideogamesImg_Answ4", answer4);
            contentValues.put("EVideogamesImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_EASYVIDEOGAMES_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }



    public long insertQuestionDAnimeImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DAnimeImg_Quest", question);
            contentValues.put("DAnimeImg_Img", image);
            contentValues.put("DAnimeImg_Answ1", answer1);
            contentValues.put("DAnimeImg_Answ2", answer2);
            contentValues.put("DAnimeImg_Answ3", answer3);
            contentValues.put("DAnimeImg_Answ4", answer4);
            contentValues.put("DAnimeImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_DIFICULTANIME_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }

    public long insertQuestionDCineImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DCineImg_Quest", question);
            contentValues.put("DCineImg_Img", image);
            contentValues.put("DCineImg_Answ1", answer1);
            contentValues.put("DCineImg_Answ2", answer2);
            contentValues.put("DCineImg_Answ3", answer3);
            contentValues.put("DCineImg_Answ4", answer4);
            contentValues.put("DCineImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_DIFICULTCINE_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDHistoryImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DHistoryImg_Quest", question);
            contentValues.put("DHistoryImg_Img", image);
            contentValues.put("DHistoryImg_Answ1", answer1);
            contentValues.put("DHistoryImg_Answ2", answer2);
            contentValues.put("DHistoryImg_Answ3", answer3);
            contentValues.put("DHistoryImg_Answ4", answer4);
            contentValues.put("DHistoryImg_CorrectAnsw", correctAnswer);

            //db.execSQL("INSERT OR REPLACE INTO " + TABLE_DIFICULTHISTORY_IMG+ " VALUES (question,image,answer1,answer2,answer3,answer4,correctAnswer)");
            result = db.insert(TABLE_DIFICULTHISTORY_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }


    public long insertQuestionDVideogamesImg(String question, String answer1,
                                        String answer2, String answer3, String answer4,
                                        String correctAnswer,int image){
        long result = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("DVideogamesImg_Quest", question);
            contentValues.put("DVideogamesImg_Img", image);
            contentValues.put("DVideogamesImg_Answ1", answer1);
            contentValues.put("DVideogamesImg_Answ2", answer2);
            contentValues.put("DVideogamesImg_Answ3", answer3);
            contentValues.put("DVideogamesImg_Answ4", answer4);
            contentValues.put("DVideogamesImg_CorrectAnsw", correctAnswer);

            result = db.insert(TABLE_DIFICULTVIDEOGAMES_IMG, null, contentValues);
        }catch (Exception ex)
        {
            ex.toString();
        }
        return result;
    }
    
    
    
    public ArrayList<ImageQuestions> showQuestions(String table)
    {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<ImageQuestions> listQuestion = new ArrayList<ImageQuestions>();
        ImageQuestions questions = null;
        Cursor cursorQuestions = null;

        if(size == 10)
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + table + " ORDER BY RANDOM() LIMIT 3" ,null);

        }else if(size == 15)
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + table + " ORDER BY RANDOM() LIMIT 3" ,null);

        }
        else
        {
            cursorQuestions = db.rawQuery("SELECT * FROM " + table + " ORDER BY RANDOM() LIMIT 1" ,null);
        }


        if(cursorQuestions.moveToFirst())
        {
            do{
                questions=new ImageQuestions();
                questions.setId(cursorQuestions.getInt(0));
                questions.setQuestion(cursorQuestions.getString(1));
                questions.setImg(cursorQuestions.getInt(2));
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
