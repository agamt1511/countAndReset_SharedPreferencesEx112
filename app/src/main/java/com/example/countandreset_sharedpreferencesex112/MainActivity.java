package com.example.countandreset_sharedpreferencesex112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 24/12/2021
 * Short description - Practice (Shared Preferences) - Saves data in the app before exiting.
 */
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

    /**
     * Button:
     * Short description - Adds one to counter and presents it.
     * <p>
     *
     * @param view
     * @return none
     */
    public void count(View view) {
        counter++;
        tv.setText(String.valueOf(counter));
    }

    /**
     * Button:
     * Short description - Resets counter and presents it.
     * <p>
     *
     * @param view
     * @return none
     */
    public void reset(View view) {
        counter=0;
        tv.setText("0");
    }

    /**
     * Button:
     * Short description - Exits the app.
     * <p>
     *
     * @param view
     * @return none
     */
    public void exit(View view) {
        finish();
    }

    /**
     * onPause:
     * Short description - Saves data and exits the app.
     * <p>
     *
     * @return none
     */
    @Override
    protected void onPause() {
        editText = et.getText().toString();
        SharedPreferences settings=getSharedPreferences("Details",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("points",counter);
        editor.putString("text",editText);
        editor.commit();
        super.onPause();
    }

    /**
     * OptionMenu:
     * Short description - Creation of OptionMenu.
     * @param menu
     * @return super.onCreateOptionsMenu(menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * OptionMenu:
     * Short description - Activating the OptionMenu.
     * @param item
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent si = new Intent(this,CreditActivity.class);
        startActivity(si);
        return super.onOptionsItemSelected(item);
    }
}