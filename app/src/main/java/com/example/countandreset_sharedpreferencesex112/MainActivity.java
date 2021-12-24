package com.example.countandreset_sharedpreferencesex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    int counter;
    String editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        SharedPreferences settings=getSharedPreferences("Details",MODE_PRIVATE);
        counter = settings.getInt("points",0);
        tv.setText(String.valueOf(counter));
        editText = settings.getString("text","");
        et.setText(editText);
    }

    public void count(View view) {
        counter++;
        tv.setText(String.valueOf(counter));
    }

    public void reset(View view) {
        counter=0;
        tv.setText("0");
    }

    public void exit(View view) {
        editText = et.getText().toString();
        SharedPreferences settings=getSharedPreferences("Details",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("points",counter);
        editor.putString("text",editText);
        editor.commit();
        finish();
    }
}