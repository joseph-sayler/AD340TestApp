package com.example.jsayler.ad340testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {
    String msg = "GRIDVIEW ACTIVITY : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    recyclerView(v);
                } else {
                    Toast.makeText(GridViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                    Log.d(msg, "toast event");
                }
            }
        });
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
