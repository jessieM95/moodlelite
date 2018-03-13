package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Calendar extends AppCompatActivity {
    ImageButton but1;
    ImageButton but2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        but1 = findViewById(R.id.imageButton5);

        but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Calendar.this,
                        Home.class);
                startActivity(myIntent);
            }
        });

        but2 = findViewById(R.id.imageButton);
        but2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Calendar.this, but2);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                popup.show();//showing popup menu
            }
        });

    }




}