package com.example.testing123;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

public class ExpandList extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.obj_desc);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(MoodList.EXTRA, 0);

        ((TextView) findViewById(R.id.descText)).setText(Singleton.getInstance().getList().get(i).getNote());
        ((TextView) findViewById(R.id.feelText)).setText(Integer.toString(Singleton.getInstance().getList().get(i).getMood()) + "/5");
        ((TextView) findViewById(R.id.sleepText)).setText(Singleton.getInstance().getList().get(i).getSleep() + " h");
        ((TextView) findViewById(R.id.dateText)).setText(Singleton.getInstance().getList().get(i).getTime());
        ((TextView) findViewById(R.id.outView)).setText(Singleton.getInstance().getList().get(i).getUlkoilu());
        ((TextView) findViewById(R.id.exerView)).setText(Singleton.getInstance().getList().get(i).getKuntoilu());
        ((TextView) findViewById(R.id.choreView)).setText(Singleton.getInstance().getList().get(i).getKoti());

        ((TextView) findViewById(R.id.descText)).setMovementMethod(new ScrollingMovementMethod());

    }
}
