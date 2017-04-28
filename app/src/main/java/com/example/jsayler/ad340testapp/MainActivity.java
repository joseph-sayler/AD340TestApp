package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String msg = "MAIN ACTIVITY : ";
    public static final String EXTRA_MESSAGE = "com.example.jsayler.ad340testapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "create event");
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d(msg, "send message event");
    }

    public void viewGrid(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
        Log.d(msg, "gridview event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "start event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "resume event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "pause event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "stop event");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "destroy event");
    }
}
