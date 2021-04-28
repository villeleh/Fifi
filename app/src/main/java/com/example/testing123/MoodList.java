package com.example.testing123;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

public class MoodList extends AppCompatActivity {

    public static final String EXTRA = "com.example.testing123.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_list);


        SharedPreferences getPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = getPrefs.getString("epic list", null);
        Type type = new TypeToken<ArrayList<FeelObj>>() {}.getType();
        ArrayList<FeelObj> dataList = gson.fromJson(json, type);
        if (dataList != null){
            Collections.reverse(dataList);
            Singleton.getInstance().idk(dataList);
        }

        ListView histList = findViewById(R.id.HistList);
        ArrayAdapter<FeelObj> adapter1;
        adapter1 = new ArrayAdapter<FeelObj>(this, android.R.layout.simple_list_item_1, Singleton.getInstance().getList());
        histList.setAdapter(adapter1);

        histList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(MoodList.this, ExpandList.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });
    }
}