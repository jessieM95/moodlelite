package com.example.jessi.moodlelite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Grades extends AppCompatActivity {
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.grades);
    }

}