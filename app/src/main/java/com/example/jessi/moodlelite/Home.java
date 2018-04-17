package com.example.jessi.moodlelite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Home extends AppCompatActivity {
    TextView et1;
    TextView tv;
    TextView tv2;
    TextView tv3;
    ImageButton button1;
    static ArrayList past;
    static ArrayList current;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=core_enrol_get_users_courses&userid=87916";
    static JSONArray array;
    static JSONObject j;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        /*button1 = findViewById(R.id.imageButton4);

        // Capture button clicks
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent intent = new Intent(Home.this,
                        Calendar.class);
                startActivity(intent);
            }
        });*/

        et1 = findViewById(R.id.editText3);
        et1.setText( DateFormat.getDateInstance().format(new Date()) );

        tv = findViewById(R.id.textView2);
        tv.setMovementMethod(new ScrollingMovementMethod());

        tv2 = findViewById(R.id.textView4);
        tv2.setMovementMethod(new ScrollingMovementMethod());

        tv3 = findViewById(R.id.textView5);
        tv3.setMovementMethod(new ScrollingMovementMethod());
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


}
