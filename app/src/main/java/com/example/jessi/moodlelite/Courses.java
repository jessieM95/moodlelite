package com.example.jessi.moodlelite;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageButton;
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
    RadioGroup rgp,rgp2, rgp3, rgp4, rgp5;
    RadioButton rbn, rbn2;
    Button bt;
    ImageButton bt2;
    static ArrayList current;
    String url = "https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=core_enrol_get_users_courses&userid=87916";
    static JSONArray array;
    static JSONObject j;
    String myURL = "";

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
        rbn = findViewById(R.id.radioButton0);
        rbn2 = findViewById(R.id.radioButton1);

        rgp2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radioButton2:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-2";
                        break;
                    case R.id.radioButton3:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-3";
                        break;
                    case R.id.radioButton4:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-4";
                        break;
                    case R.id.radioButton5:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-5";
                        break;
                }
            }


        });

        rgp3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radioButton6:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-6";
                        break;
                    case R.id.radioButton7:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-7";
                        break;
                    case R.id.radioButton8:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-8";
                        break;
                    case R.id.radioButton9:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-9";
                        break;

                }
            }


        });

        rgp4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radioButton10:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-10";
                        break;
                    case R.id.radioButton11:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-11";
                        break;
                    case R.id.radioButton12:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-12";
                        break;
                    case R.id.radioButton13:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-13";
                        break;
                }
            }


        });

        rgp5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.radioButton14:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-14";
                        break;
                    case R.id.radioButton15:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-15";
                        break;
                    case R.id.radioButton16:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-16";
                        break;
                    case R.id.radioButton17:
                        myURL = "https://learn.illinois.edu/course/view.php?id=27441#section-17";
                        break;
                }
            }


        });

        bt = findViewById(R.id.button9);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(myURL));
                startActivity(browserIntent);
            }
        });
        bt2 = findViewById(R.id.imageButton7);
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Courses.this,
                        Home.class);
                startActivity(myIntent);
            }
        });

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
                    rbn.setText(current.get(0).toString());
                    rbn2.setText(current.get(1).toString());
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
