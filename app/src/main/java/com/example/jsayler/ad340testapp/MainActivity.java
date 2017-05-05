package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;


public class MainActivity extends OptionsMenu {
    String msg = "MAIN ACTIVITY : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Log.d(msg, "create event");
    }

    public void gridViewer(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
        Log.d(msg, "gridview event");
    }

    public void textView(View view) {
        Intent intent = new Intent(this, TextEntry.class);
        startActivity(intent);
        Log.d(msg, "textentry event");
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
