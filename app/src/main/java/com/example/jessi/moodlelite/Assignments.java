package com.example.jessi.moodlelite;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Assignments extends AppCompatActivity {
    ImageButton button1;
    static ArrayList course_name;
    static ArrayList assignment_name;
    static ArrayList due_date;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=mod_assign_get_assignments&courseids[]=27441&courseids[]=28149";
    static JSONArray array;
    static JSONObject j;
    TextView tv;
    View constrant;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.assignments);
        button1 = findViewById(R.id.imageButton2);

        // Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Assignments.this,
                        Home.class);
                startActivity(myIntent);
            }
        });

        constrant =  findViewById(R.id.assignLayout);

        makeRequest();
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
                startActivity(new Intent(Assignments.this, schedule.class));
                return true;
            case R.id.gradebook:
                startActivity(new Intent(Assignments.this, Grades.class));
                return true;
            case R.id.assignments:
                startActivity(new Intent(Assignments.this, Assignments.class));
                return true;
            case R.id.courses:
                startActivity(new Intent(Assignments.this, Courses.class));
                return true;
            case R.id.cal:
                startActivity(new Intent(Assignments.this, Calendar.class));
                return true;
            case R.id.announcements:
                startActivity(new Intent(Assignments.this, announcements.class));
                return true;
            case R.id.settings:
                Toast.makeText(Assignments.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                startActivity(new Intent(Assignments.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void makeRequest()
    {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(String string) {
                try {
                    course_name = new ArrayList();
                    assignment_name = new ArrayList();
                    due_date = new ArrayList();
                    j = new JSONObject(string);
                    array = j.getJSONArray("courses");

                    JSONObject temp = array.getJSONObject(0);
                    course_name.add(temp.getString("shortname"));
                    JSONArray t = temp.getJSONArray("assignments");
                    for (int j = 0; j < t.length(); j++) {
                        JSONObject obj = t.getJSONObject(j);
                        assignment_name.add(obj.getString("name"));
                        //current.add(Html.fromHtml(obj.getString("intro").toString()));

                        Instant inst = Instant.ofEpochSecond(Long.parseLong(obj.getString("duedate")));
                        ZoneId zoneId = ZoneId.of("America/Chicago");
                        ZonedDateTime zdt = inst.atZone(zoneId);
                        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
                        String date = zdt.format(formatter);

                        due_date.add(date);
                    }
                    ArrayList assignments = new ArrayList();

                    for(int k = 0; k < assignment_name.size(); k++){
                        assignments.add(" " + course_name.get(0).toString() + '\n' + " " + assignment_name.get(k).toString() + "\n" + " Due Date: " + due_date.get(k).toString() + "\n");
                    }
                    for(int i =0; i < assignments.size(); i++) {

                        TextView txtView = new TextView(Assignments.this);
                        txtView.setId(i+1000);
                        txtView.setText(assignments.get(i).toString());
                        txtView.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT));

                        txtView.setTextSize(18);
                        txtView.setTextColor(Color.BLACK);
                        txtView.setX(200);
                        txtView.setY(200 + (i*300));
                        ((ConstraintLayout) constrant).addView(txtView);
                    }

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(Assignments.this);
        rQueue.add(request);
    }
}