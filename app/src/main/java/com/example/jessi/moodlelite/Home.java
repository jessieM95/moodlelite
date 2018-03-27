package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class Home extends AppCompatActivity {
    TextView et1;
    TextView tv;
    TextView tv2;
    TextView tv3;
    ImageButton button1;

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


        et1 = findViewById(R.id.editText3);
        et1.setText( DateFormat.getDateInstance().format(new Date()) );

        tv = findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        tv2 = findViewById(R.id.textView4);
        tv2.setMovementMethod(new ScrollingMovementMethod());

        tv3 = findViewById(R.id.textView5);
        tv3.setMovementMethod(new ScrollingMovementMethod());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.user:
                //startActivity(new Intent(this, About.class));
                Toast.makeText(Home.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.gradebook:
                startActivity(new Intent(Home.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(Home.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(Home.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(Home.this, Calendar.class));
                return true;
            case R.id.announcements:
                Toast.makeText(Home.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(Home.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(Home.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


}
