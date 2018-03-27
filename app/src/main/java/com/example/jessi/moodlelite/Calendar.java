package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


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
                Toast.makeText(Calendar.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.gradebook:
                startActivity(new Intent(Calendar.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(Calendar.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(Calendar.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(Calendar.this, Calendar.class));
                return true;
            case R.id.announcements:
                Toast.makeText(Calendar.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(Calendar.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(Calendar.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }




}