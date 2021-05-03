package com.example.testing123;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/** Class to handle ListView */
public class MoodList extends AppCompatActivity {

    public static final String EXTRA = "com.example.testing123.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_list);

        SharedPreferences getPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE); // creating a variable for loading data from shared preferences
        Gson gson = new Gson();
        String json = getPrefs.getString("epic list", null); // get string from shared preferences
        Type type = new TypeToken<ArrayList<FeelObj>>() {}.getType();
        ArrayList<FeelObj> dataList = gson.fromJson(json, type); // load list and make it into a new list
        if (dataList != null){
            Singleton.getInstance().cloneList(dataList);
        }

        ListView histList = findViewById(R.id.HistList);
        ArrayAdapter<FeelObj> adapter; // make an adapter to show the list
        adapter = new ArrayAdapter<FeelObj>(this, android.R.layout.simple_list_item_1, Singleton.getInstance().getList());
        histList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        histList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent4 = new Intent(MoodList.this, ExpandList.class);
                intent4.putExtra(EXTRA, i); // send the index of the list item that was clicked
                startActivity(intent4); // start ExpandList activity
            }
        });
    }
}