package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;

public class schedule extends AppCompatActivity {
    ImageButton button1;
    WebView wv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.schedule);
        button1 = findViewById(R.id.imageButton3);

        // Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(schedule.this,
                        Home.class);
                startActivity(myIntent);
            }
        });

        wv = findViewById(R.id.webview);
        wv.loadUrl("http://apps.uillinois.edu");
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
                startActivity(new Intent(schedule.this, schedule.class));
                return true;
            case R.id.gradebook:
                startActivity(new Intent(schedule.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(schedule.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(schedule.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(schedule.this, Calendar.class));
                return true;
            case R.id.announcements:
                Toast.makeText(schedule.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(schedule.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                Toast.makeText(schedule.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
