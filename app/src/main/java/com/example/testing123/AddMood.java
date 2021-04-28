package com.example.testing123;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class AddMood extends AppCompatActivity {

    int rateMood, i;
    private RadioButton rad1,rad2,rad3,rad4,rad5;
    private boolean out, exercise, chores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_mood);


        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFeel();
            }
        });

        rad1 = findViewById(R.id.radioButton);
        rad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMood = 1;
            }
        });

        rad2 = findViewById(R.id.radioButton2);
        rad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMood = 2;
            }
        });
        rad3 = findViewById(R.id.radioButton3);
        rad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMood = 3;
            }
        });
        rad4 = findViewById(R.id.radioButton4);
        rad4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMood = 4;
            }
        });
        rad5 = findViewById(R.id.radioButton5);
        rad5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateMood = 5;
            }
        });



    }
        public void saveFeel(){
            EditText sleepField = (EditText) findViewById(R.id.sleepField);
            String sleep = sleepField.getText().toString();
            EditText editText = (EditText) findViewById(R.id.NoteField);
            String message = editText.getText().toString();
            Singleton.getInstance().getList().add(new FeelObj(message, rateMood, sleep, out, exercise, chores));
            Log.d("LOG", Singleton.getInstance().getList().get(i).getNote() + " " + Singleton.getInstance().getList().get(i).getMood());

            SharedPreferences mPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = mPrefs.edit();
            Gson gson = new Gson();
            ArrayList saveList = Singleton.getInstance().getList();
            String json = gson.toJson(saveList);
            editor.putString("epic list", json);
            editor.apply();

            Intent intent3 = new Intent(this, MainActivity.class);
            startActivity(intent3);
            i++;
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    out = true;
                else
                    out = false;
                break;
            case R.id.checkBox2:
                if (checked)
                    exercise = true;

            else
                    exercise = false;
                break;
            case R.id.checkBox3:
                if (checked)
                    chores = true;

                else
                    chores = false;
                break;
        }
    }

}