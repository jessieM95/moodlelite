package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Assignments extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.assignments);

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.user:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.gradebook:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.assignments:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.courses:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.cal:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.announcements:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }*/
}