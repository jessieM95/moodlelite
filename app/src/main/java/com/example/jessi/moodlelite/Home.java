package com.example.jessi.moodlelite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
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

import java.time.LocalDate;
import java.util.ArrayList;


public class Home extends AppCompatActivity {
    TextView et1;
    TextView tv;
    TextView tv3;
    ImageButton button1;
    static ArrayList past;
    static ArrayList current;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=core_enrol_get_users_courses&userid=87916";
    static JSONArray array;
    static JSONObject j;

    static ArrayList current2;
    String url2 = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=mod_forum_get_forum_discussions_paginated&forumid=195048";
    static JSONArray array2;
    static JSONObject j2;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Generate random passport number
        /*Random rand = new Random();
        int passport = rand.nextInt(1000000);
        String scheme = "moodlelite";
        String loginUrl = "https://learn.illinois.edu/admin/tool/mobile/launch.php?passport=" + passport + "&service=moodle_mobile_app&urlscheme=" + scheme;

        // Launch login
        Intent loginIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(loginUrl));
        startActivity(loginIntent);

        // Get data token from login return
        Intent intent = getIntent();
        Uri data = intent.getData();*/

        et1 = findViewById(R.id.editText3);
        String day = LocalDate.now().getDayOfWeek().name().toLowerCase();
        String month = LocalDate.now().getMonth().name().toLowerCase();
        et1.setText(String.valueOf(day.charAt(0)).toUpperCase() + day.substring(1) + ", " + String.valueOf(month.charAt(0)).toUpperCase() + month.toLowerCase().substring(1) + " " + LocalDate.now().getDayOfMonth());
        et1.setGravity(Gravity.CENTER_HORIZONTAL);

        tv = findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        tv3 = findViewById(R.id.textView3);
        tv3.setMovementMethod(new ScrollingMovementMethod());
        makeRequest();
        makeRequestAnnouce();

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
                startActivity(new Intent(Home.this, schedule.class));
                return true;
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
                startActivity(new Intent(Home.this, announcements.class));
                return true;
            case R.id.settings:
                Toast.makeText(Home.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                startActivity(new Intent(Home.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void makeRequest()
    {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                try {
                    array = new JSONArray(string);
                    past = new ArrayList();
                    current = new ArrayList();

                    for (int i = 0; i < array.length(); ++i) {
                        j = array.getJSONObject(i);
                        if (j.getString("progress").equals("null")) {
                            past.add(j.getString("fullname"));
                        } else {
                            current.add(j.getString("fullname"));
                        }
                    }

                    String res = "";
                    String r = "";
                    for(int i = 0; i < current.size(); i++)
                    {
                        r = " Courses: " + "\n ";
                        res += current.get(i).toString() + " \n ";
                    }
                    tv.setText(r+res);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(Home.this);
        rQueue.add(request);
    }

    public void makeRequestAnnouce()
    {
        StringRequest request = new StringRequest(url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                try {
                    current2 = new ArrayList();
                    j2 = new JSONObject(string);
                    array2 = j2.getJSONArray("discussions");

                    for (int i = 0; i < 1; ++i) {
                        JSONObject temp = array2.getJSONObject(i);
                        current2.add(temp.getString("name"));
                        current2.add(Html.fromHtml(temp.getString("message").toString()));
                    }

                    tv3.setText(" Annoucements: " + "\n" + " " + current2.get(0).toString() + " " + '\n' + " " + current2.get(1).toString() + " ");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(Home.this);
        rQueue.add(request);
    }

}
