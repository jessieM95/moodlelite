package com.example.jessi.moodlelite;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Data extends AppCompatActivity {

    Button btnHit;
    TextView txtJson;
    ProgressDialog pd;
    ArrayList past_courses;
    static ArrayList current_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_parser);

        txtJson = (TextView) findViewById(R.id.tvJsonItem);

        new JsonTask().execute("https://learn.illinois.edu/webservice/rest/server.php?wstoken=9927efa95940f0e7e81c3231a201079a&moodlewsrestformat=json&wsfunction=core_enrol_get_users_courses&userid=87916");

    }

    protected static String getCurrentCourses() {
        String result = "";
        for(int i = 0; i < current_courses.size(); i++)
        {
            result +=  current_courses.get(i).toString() + "\n";
        }
        return result;
    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(Data.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                try {
                    connection = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            past_courses = new ArrayList();
            current_courses = new ArrayList();
            JSONArray courses = null;
            try {
                courses = new JSONArray(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }

            JSONObject course_info = null;

            for (int i = 0; i < courses.length(); i++) {
                try {
                    course_info = courses.getJSONObject(i);
                    if (course_info.getString("progress").equals("null")){
                        past_courses.add(course_info.getString("fullname"));
                    }
                    else {
                        current_courses.add(course_info.getString("fullname"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            txtJson.setText(getCurrentCourses());
        }



    }
}