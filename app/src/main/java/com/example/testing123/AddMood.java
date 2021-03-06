package com.example.testing123;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * Creates FeelObj objects to store the data given by the user, adds them to the list, and then saves the list.
 * @author Ville Lehtola
 * @author Jerry Julenius
 * @author Mathias Karhu
 */
public class AddMood extends AppCompatActivity {

    private int rateMood, i;
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

        /** creates object, adds it to list, saves list */
        public void saveFeel(){
            Singleton.getInstance().reverseList(); // reverse list
            EditText sleepField = (EditText) findViewById(R.id.sleepField);
            String sleep = sleepField.getText().toString(); // assigns text from textfield to a string
            EditText editText = (EditText) findViewById(R.id.NoteField);
            String message = editText.getText().toString();
            Singleton.getInstance().getList().add(new FeelObj(message, rateMood, sleep, out, exercise, chores)); // creates a new object with the given parameters and adds it to the list
            Singleton.getInstance().reverseList();
            SharedPreferences mPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE); // creates a variable for storing data in shared preferences
            SharedPreferences.Editor editor = mPrefs.edit(); // creates a variable for editor to store data in shared preferences.
            Gson gson = new Gson();
            ArrayList saveList = Singleton.getInstance().getList(); // creates a copy of the singleton list to save into shared preferences
            String json = gson.toJson(saveList);
            editor.putString("epic list", json); // saves list
            editor.apply();
            finish(); // returns to main activity after saving
            i++;
    }

    /** gets boolean value from checkboxes */
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Checks which checkbox was clicked
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