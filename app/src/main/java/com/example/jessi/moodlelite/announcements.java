package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class announcements extends AppCompatActivity {

    ImageButton but1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcements);

        but1 = findViewById(R.id.imageButton6);

        but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(announcements.this,
                        Home.class);
                startActivity(myIntent);
            }
        });

        TextView t1 = findViewById(R.id.textView28);
        TextView t2 = findViewById(R.id.textView29);
        TextView t3 = findViewById(R.id.textView30);
        TextView t4 = findViewById(R.id.textView31);

        t1.setMovementMethod(new ScrollingMovementMethod());
        t2.setMovementMethod(new ScrollingMovementMethod());
        t3.setMovementMethod(new ScrollingMovementMethod());
        t4.setMovementMethod(new ScrollingMovementMethod());



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
                startActivity(new Intent(announcements.this, schedule.class));
                return true;
            case R.id.gradebook:
                startActivity(new Intent(announcements.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(announcements.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(announcements.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(announcements.this, Calendar.class));
                return true;
            case R.id.announcements:
                startActivity(new Intent(announcements.this, announcements.class));
                return true;
            case R.id.settings:
                Toast.makeText(announcements.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(announcements.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
