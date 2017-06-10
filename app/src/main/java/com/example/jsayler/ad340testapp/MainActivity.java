package com.example.jsayler.ad340testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends OptionsMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    public void gridViewer(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

    public void textView(View view) {
        Intent intent = new Intent(this, TextEntry.class);
        startActivity(intent);
    }

    public void recycleView(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void coordViewer(View view) {
        Intent intent = new Intent(this, MapDisplay.class);
        startActivity(intent);
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
                            showToast("Red clicked");
                        } else if (id == 1) {
                            showToast("Green clicked");
                        } else if (id == 2) {
                            showToast("Blue clicked");
                        } else {
                            showToast("Yellow clicked");
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
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
