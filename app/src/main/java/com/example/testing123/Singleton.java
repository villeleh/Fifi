package com.example.testing123;

import java.util.ArrayList;
import java.util.Collections;

/** Singleton class to hold the list of FeelObj objects
 * @author Ville Lehtola
 * @author Jerry Julenius
 * @author Mathias Karhu
 */
public class Singleton {

    private static Singleton ourInstance = new Singleton();

    private ArrayList<FeelObj> lista;

    private Singleton() {
        lista = new ArrayList<FeelObj>();
    }
    /** returns instance */
    public static Singleton getInstance() {
        return ourInstance;
    }
    /** clones list */
    public void cloneList (ArrayList list){
        this.lista = list;
    }
    /** reverses list */
    public void reverseList (){
        Collections.reverse(this.lista);
    }
    /** returns list */
    public ArrayList<FeelObj> getList() {
        return lista;
    }
    /** deletes list item */
    public void deleteItem(int i){
        lista.remove(i);
    }
}
