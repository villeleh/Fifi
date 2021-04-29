package com.example.testing123;

import java.util.ArrayList;
import java.util.Collections;

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
    /** reverse list */
    public void reverseList (){
        Collections.reverse(this.lista);
    }
    /** get list */
    public ArrayList<FeelObj> getList() {
        return lista;
    }
}
