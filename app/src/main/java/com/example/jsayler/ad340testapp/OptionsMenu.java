package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class OptionsMenu extends AppCompatActivity {

    String msg = "MENU ACTIVITY : ";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.About:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                Log.d(msg, "About event");
                break;
            case R.id.TextEntry:
                intent = new Intent(this, TextEntry.class);
                startActivity(intent);
                Log.d(msg, "TextEntry event");
                break;
            case R.id.GameList:
                intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                Log.d(msg, "Recycler View event");
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
