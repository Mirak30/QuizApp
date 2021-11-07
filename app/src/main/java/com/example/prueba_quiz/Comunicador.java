package com.example.prueba_quiz;

public class Comunicador {
    private static int entero = 0;
    private static String string = null;

    public static void setInt(int newInt) { entero = newInt; }
    public static Object getInt() {
        return entero;
    }

    public static void setString(String newString) {
        string = newString;
    }
    public static String getString() {
        return string;
    }

}
