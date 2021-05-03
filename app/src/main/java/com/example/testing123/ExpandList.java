package com.example.testing123;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.annotation.SuppressLint;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

/** Class for the activity that opens when a list item is clicked */
public class ExpandList extends AppCompatActivity {
    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obj_desc);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(MoodList.EXTRA, 0); // get the index of the list item that was clicked

        // put text into text fields
        ((TextView) findViewById(R.id.descText)).setText(Singleton.getInstance().getList().get(i).getNote());
        ((TextView) findViewById(R.id.feelText)).setText(Integer.toString(Singleton.getInstance().getList().get(i).getMood()) + "/5");
        ((TextView) findViewById(R.id.sleepText)).setText(Singleton.getInstance().getList().get(i).getSleep() + " h");
        ((TextView) findViewById(R.id.dateText)).setText(Singleton.getInstance().getList().get(i).getTime());
        ((TextView) findViewById(R.id.outView)).setText(Singleton.getInstance().getList().get(i).getUlkoilu());
        ((TextView) findViewById(R.id.exerView)).setText(Singleton.getInstance().getList().get(i).getKuntoilu());
        ((TextView) findViewById(R.id.choreView)).setText(Singleton.getInstance().getList().get(i).getKoti());
        ((TextView) findViewById(R.id.descText)).setMovementMethod(new ScrollingMovementMethod());

        Intent goBack = new Intent(this, MainActivity.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Poista?");
        builder.setMessage("Haluatko varmasti poistaa tämän muistiinpanon");

        builder.setNegativeButton("Ei", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                Singleton.getInstance().deleteItem(i);
                SharedPreferences mPrefs = getSharedPreferences("shared preferences", MODE_PRIVATE); // creating a variable for storing data in shared preferences
                SharedPreferences.Editor editor = mPrefs.edit(); // creating a variable for editor to store data in shared preferences.
                Gson gson = new Gson();
                ArrayList saveList = Singleton.getInstance().getList(); // creating a copy of the singleton list to save into shared preferences
                String json = gson.toJson(saveList);
                editor.putString("epic list", json); // save list
                editor.apply();
                dialog.dismiss();
                startActivity(goBack);
            }
        });

        ImageButton delButton = findViewById(R.id.deleteButton);
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
}
}
