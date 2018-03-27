package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.courses);


    }

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
                startActivity(new Intent(Courses.this, schedule.class));
                return true;
            case R.id.gradebook:
                startActivity(new Intent(Courses.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(Courses.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(Courses.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(Courses.this, Calendar.class));
                return true;
            case R.id.announcements:
                Toast.makeText(Courses.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(Courses.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(Courses.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
