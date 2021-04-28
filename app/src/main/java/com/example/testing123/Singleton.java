package com.example.testing123;


import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Singleton {

    public static Singleton ourInstance = new Singleton();

    private ArrayList<FeelObj> lista;

    private Singleton() {
        lista = new ArrayList<FeelObj>();
    }

    public static Singleton getInstance() {
        return ourInstance;
    }

    public void idk (ArrayList test){
        this.lista = test;
    }

    public ArrayList<FeelObj> getList() {
        return lista;
    }

}
