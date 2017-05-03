package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class About  extends OptionsMenu {
    String msg = "ABOUT ACTIVITY : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        Log.d(msg, "create event");
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Main:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Log.d(msg, "Home event");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }*/

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
