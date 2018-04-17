package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

public class announcements extends AppCompatActivity {

    ImageButton but1;
    static ArrayList past;
    static ArrayList current;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=mod_forum_get_forum_discussions_paginated&forumid=195048";
    static JSONArray array;
    static JSONObject j;
    TextView tv,tv2,tv3,tv4;

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

        tv = findViewById(R.id.textView22);
        tv2 = findViewById(R.id.textView23);
        //tv3 = findViewById(R.id.textView24);
        //tv4 = findViewById(R.id.textView25);
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

    public void makeRequest()
    {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                try {
                    current = new ArrayList();
                    j = new JSONObject(string);
                    array = j.getJSONArray("discussions");

                    for (int i = 0; i < array.length(); ++i) {
                        JSONObject temp = array.getJSONObject(i);
                        current.add(temp.getString("name"));
                        current.add(Html.fromHtml(temp.getString("message").toString()));
                    }

                    tv.setText(current.get(0).toString() + '\n' + current.get(1).toString());
                    tv2.setText(current.get(2).toString() + '\n' + current.get(3).toString());
                    //tv3.setText(current.get(4).toString() + '\n' + current.get(5).toString());
                    //tv4.setText(current.get(6).toString() + '\n' + current.get(7).toString());
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(announcements.this);
        rQueue.add(request);
    }

}
