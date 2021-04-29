package com.example.testing123;

import java.util.Calendar;

/** class for object that holds the information given in the AddMood class  */
public class FeelObj {
    String note, sleep, ulkoilu, kuntoilu, koti;
    int rateMood;
    boolean out, exercise, chores;
    int minute = Calendar.getInstance().get(Calendar.MINUTE);
    String minuteString;
    String currentTime = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                 + "." + Integer.toString((Calendar.getInstance().get(Calendar.MONTH) + 1))
                 + "." + Integer.toString(Calendar.getInstance().get(Calendar.YEAR))
                 + " " + Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
                 + ":" + getMinute();

    public FeelObj(String note, int rateMood, String sleep, boolean out, boolean exercise, boolean chores){
        this.note = note;
        this.rateMood = rateMood;
        this.sleep = sleep;
        this.out = out;
        this.exercise = exercise;
        this.chores = chores;
        if(getOut()){ulkoilu = "Ulkoilin";} else ulkoilu = "";
        if(getExercise()){kuntoilu = "Kuntoilin";} else kuntoilu = "";
        if(getChores()){koti = "Tein kotitöitä";} else koti = "";
    }

    public String getMinute(){ // adds a "0" in front of the minute if there isnt one
        if (minute<10){
            minuteString = "0" + minute;
            return minuteString;
        } else return Integer.toString(minute);
    }

    public String getNote(){
        return this.note;
    }
    public int getMood(){
        return this.rateMood;
    }
    public String getSleep() {
        return this.sleep;
    }
    public Boolean getOut(){
        return this.out;
    }
    public Boolean getExercise(){
        return this.exercise;
    }
    public Boolean getChores(){
        return this.chores;
    }
    public String getTime(){
        return this.currentTime;
    }
    public String getUlkoilu(){
        return this.ulkoilu;
    }
    public String getKuntoilu(){
        return this.kuntoilu;
    }
    public String getKoti(){
        return this.koti;
    }

    public String toString(){
        return "pvm: " + currentTime + " " + this.note;
    }
}
