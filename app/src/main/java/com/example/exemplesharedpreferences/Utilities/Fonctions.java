package com.example.exemplesharedpreferences.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Fonctions {
    public static boolean insertSharedPreference(Context context, String key, String value){
        try{
            //Fichier de sauvegarde interne de connées ( nom , MODE_PRIVATE)
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.SHARED_PREFERENCES,context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            if(!sharedPreferences.contains(key)) { editor.putString(key,value); }

            return editor.commit();
        }
        catch (Exception ex){
            Log.e("Fonction - InsertSP :", ex.getMessage());
            return false;
        }
    }

    public static String getSharedPreference(Context context, String key){
        //Fichier de sauvegarde interne de connées ( nom , MODE_PRIVATE)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.SHARED_PREFERENCES,context.MODE_PRIVATE);

        return sharedPreferences.getString(key, "");
    }

    public static boolean removeSharedPreference(Context context, String key){
        try{
            //Fichier de sauvegarde interne de connées ( nom , MODE_PRIVATE)
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constantes.SHARED_PREFERENCES,context.MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            if(!sharedPreferences.contains(key)) { editor.remove(key); }

             return editor.commit();
        }
        catch (Exception ex){
            Log.e("Fonction - RemoveSP :", ex.getMessage());
            return false;
        }

    }
}
