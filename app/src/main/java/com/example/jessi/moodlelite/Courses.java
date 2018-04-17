package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
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

public class Courses extends AppCompatActivity {
    RadioGroup rgp;
    RadioGroup rgp2;
    RadioGroup rgp3, rgp4, rgp5;
    RadioGroup rg;

    static ArrayList current;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=core_enrol_get_users_courses&userid=87916";
    static JSONArray array;
    static JSONObject j;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.courses);

        rgp = (RadioGroup) findViewById(R.id.radio_group);
        makeRequest();

        rgp2 = findViewById(R.id.radio_group2);
        rgp3 = findViewById(R.id.radio_group3);
        rgp4 = findViewById(R.id.radio_group4);
        rgp5 = findViewById(R.id.radio_group5);


        rgp2.setOrientation(LinearLayout.HORIZONTAL);
        rgp3.setOrientation(LinearLayout.HORIZONTAL);
        rgp4.setOrientation(LinearLayout.HORIZONTAL);
        rgp5.setOrientation(LinearLayout.HORIZONTAL);
        for (int i = 1; i <= 4; i++) {
            RadioButton rbn = new RadioButton(Courses.this);
            rbn.setId(i + 1000);
            rbn.setText("Week 0" + i);
            rgp2.addView(rbn);
        }

        for (int i = 5; i <= 8; i++) {
            RadioButton rbn2 = new RadioButton(Courses.this);
            rbn2.setId(i + 1000);
            rbn2.setText("Week 0" + i);
            rgp3.addView(rbn2);
        }
        for (int i = 9; i <= 12; i++) {
            RadioButton rbn3 = new RadioButton(Courses.this);
            rbn3.setId(i + 1000);
            rbn3.setText("Week  " + i);
            rgp4.addView(rbn3);
        }
        for (int i = 13; i <= 16; i++) {
            RadioButton rbn4 = new RadioButton(Courses.this);
            rbn4.setId(i + 1000);
            rbn4.setText("Week " + i);
            rgp5.addView(rbn4);
        }

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
                startActivity(new Intent(Courses.this, announcements.class));
                return true;
            case R.id.settings:
                Toast.makeText(Courses.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sign_out:
                startActivity(new Intent(Courses.this, MainActivity.class));
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
                    current = new ArrayList();

                    for (int i = 0; i < array.length(); ++i) {
                        j = array.getJSONObject(i);
                        if (!j.getString("progress").equals("null")) {
                            current.add(j.getString("fullname"));
                        }
                    }
                    for(int i = 0; i < current.size(); i++)
                    {
                        RadioButton rbn = new RadioButton(Courses.this);
                        rbn.setId(i + 1000);
                        rbn.setText(current.get(i).toString());
                        rgp.addView(rbn);
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
        RequestQueue rQueue = Volley.newRequestQueue(Courses.this);
        rQueue.add(request);
    }

}
