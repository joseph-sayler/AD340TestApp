package com.example.jsayler.ad340testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    public void recycleView(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
        Log.d(msg, "recycleView event");
    }

    public void coordViewer(View view) {
        Intent intent = new Intent(this, MapDisplay.class);
        startActivity(intent);
        Log.d(msg, "coordViewer event");
    }

    public void popUpDialog(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setIcon(android.R.drawable.sym_def_app_icon)
                .setTitle(R.string.dialog_title2)
//                .setMessage(R.string.dialog_text)
                .setItems(R.array.colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (id == 0) {
                            Log.d(msg, "Red clicked");
                        } else if (id == 1) {
                            Log.d(msg, "Green clicked");
                        } else if (id == 2) {
                            Log.d(msg, "Blue clicked");
                        } else {
                            Log.d(msg, "Yellow clicked");
                        }
                    }
/*                })

                .setPositiveButton(R.string.ok_txt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        Log.d(msg, "OK clicked");
                    }
                })
                .setNegativeButton(R.string.cancel_txt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        Log.d(msg, "Cancel clicked");
                    }
*/
                });
        AlertDialog alertDialog =  mBuilder.create();
        alertDialog.show();
        Log.d(msg, "dialog event");
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
