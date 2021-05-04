package com.example.testing123;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Random;

/** Handles onClick listeners for the buttons that change activities and retrieves random motivational phrases.
 * @author Ville Lehtola
 * @author Jerry Julenius
 * @author Mathias Karhu
 */
public class MainActivity extends AppCompatActivity {

    private Random rng = new Random(Calendar.getInstance().get(Calendar.MILLISECOND)); // creates a random number generator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moti();
    }
    /** opens the AddMood activity when button is pressed */
    public void feel(View view) {
        Intent intent = new Intent(this, AddMood.class);
        startActivity(intent);
    }
    /** opens the MoodList activity when button is pressed */
    public void historyActivity(View view) {
        Intent intent2 = new Intent(this, MoodList.class);
        startActivity(intent2);
    }
    /** retrieves a random motivational phrase from the motiList and assigns it to a textView */
    public void moti() {
        int nxt = rng.nextInt(MotivationText.getInstance().getLenght());
        String motiString = MotivationText.getInstance().getList().get(nxt);
        ((TextView) findViewById(R.id.motiView)).setText(motiString);
    }
}