package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends OptionsMenu {
    String msg = "MAIN ACTIVITY : ";
    String[] toastString = {
            "Arrow","Blades of Steel","Battletoads","Castlevania","Duck Hunt","Excitebike",
            "Final Fantasy","Ice Climbers","Kirby's Adventure","Zelda II: The Adventure of Link",
            "Super Mario Bros.","Ninja Gaiden","Teenage Mutant Ninja Turtles","Q*bert","The Legend of Zelda",
            "Slalom","Pinball","Metroid","Kid Icarus","Popeye","Gumshoe","Donkey Kong 3","Baseball",
            "Donkey Kong Jr. Math","Wrecking Crew","10-Yard Fight","Balloon Fight","Mega Man 2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    recyclerView(v);
                } else {
                    Toast.makeText(MainActivity.this, "" + toastText(position), Toast.LENGTH_SHORT).show();
                    Log.d(msg, "toast event");
                }
            }
        });
    }

    private String toastText(int pos) {
        return toastString[pos];
    }

    public void recyclerView(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
        Log.d(msg, "recyclerView event");
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
