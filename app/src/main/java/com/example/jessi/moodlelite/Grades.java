package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Grades extends AppCompatActivity {
    ImageButton button1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.grades);
        button1 = findViewById(R.id.imageButton);

        // Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Grades.this,
                        Home.class);
                startActivity(myIntent);
            }
        });
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
                startActivity(new Intent(Grades.this, schedule.class));
                return true;
            case R.id.gradebook:
                startActivity(new Intent(Grades.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(Grades.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(Grades.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(Grades.this, Calendar.class));
                return true;
            case R.id.announcements:
                startActivity(new Intent(Grades.this, announcements.class));
                return true;
            case R.id.settings:
                Toast.makeText(Grades.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                startActivity(new Intent(Grades.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
