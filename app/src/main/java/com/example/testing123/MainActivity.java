package com.example.testing123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rng = new Random(Calendar.getInstance().get(Calendar.MILLISECOND));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moti();
    }
    /** YEA */
    public void feel(View view) {
        Intent intent = new Intent(this, AddMood.class);
        startActivity(intent);
    }

    public void historyActivity(View view) {
        Intent intent2 = new Intent(this, MoodList.class);
        startActivity(intent2);
    }

    public void moti(){
        int nxt = rng.nextInt(MotivationText.getInstance().getLenght());
        String motiString = MotivationText.getInstance().getList().get(nxt);;
        ((TextView) findViewById(R.id.motiView)).setText(motiString);
    }
}