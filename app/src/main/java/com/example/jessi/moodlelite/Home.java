package com.example.jessi.moodlelite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class Home extends AppCompatActivity {
    EditText et1;
    TextView tv;
    TextView tv2;
    TextView tv3;
    ImageButton button1;
    ImageButton button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        button1 = findViewById(R.id.imageButton4);

        // Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Home.this,
                        Calendar.class);
                startActivity(myIntent);
            }
        });

        button2 = findViewById(R.id.imageButton3);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Home.this, button2);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                popup.show();//showing popup menu
            }
        });


        et1 = findViewById(R.id.editText3);
        et1.setText( DateFormat.getDateInstance().format(new Date()) );

        tv = findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        tv2 = findViewById(R.id.textView4);
        tv2.setMovementMethod(new ScrollingMovementMethod());

        tv3 = findViewById(R.id.textView5);
        tv3.setMovementMethod(new ScrollingMovementMethod());


    }


}
