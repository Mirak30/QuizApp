package com.example.prueba_quiz;

public class Comunicador {
    private static int entero = 0;
    private static int nQuest = 5;
    private static String dif = null;
    private static String string = null;


    public static void setInt(int newInt) { entero = newInt; }
    public static int getInt() {
        return entero;
    }

    public static void setnQuest(int newInt) { nQuest = newInt; }
    public static int getnQuest() {
        return nQuest;
    }

    public static void setString(String newString) {
        string = newString;
    }
    public static String getString() {
        return string;
    }

    public static void setDif(String newString) { dif = newString; }
    public static String getDif() {
        return dif;
    }

}
