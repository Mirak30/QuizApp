package com.example.prueba_quiz;

public class Comunicador {
    private static Object objeto = null;
    private static int entero = 0;


    public static void setObjeto(Object newObjeto) {
        objeto = newObjeto;
    }
    public static Object getObjeto() {
        return objeto;
    }
    public static void setInt(int newInt) {
        entero = newInt;
    }
    public static Object getInt() {
        return entero;
    }

}
