package com.example.testing123;


import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/** Singleton class to hold list of FeelObj objects */
public class Singleton {

    public static Singleton ourInstance = new Singleton();

    private ArrayList<FeelObj> lista;

    private Singleton() {
        lista = new ArrayList<FeelObj>();
    }
    /** get instance */
    public static Singleton getInstance() {
        return ourInstance;
    }

    public void cloneList (ArrayList list){
        this.lista = list;
    }
    /** get list */
    public ArrayList<FeelObj> getList() {
        return lista;
    }

}
