package com.example.testing123;

import java.util.ArrayList;

/** Singleton class to hold list of FeelObj objects */
public class Singleton {

    private static Singleton ourInstance = new Singleton();

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
