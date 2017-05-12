package com.example.jsayler.ad340testapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends OptionsMenu {

    String msg = "RECYCLER VIEW :";
    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter jsonRecyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;

    //private static final String ENDPOINT = "https://drive.google.com/file/d/0B99wiRp9KNZ_TlFEaE5HLVhpSWM/view?usp=sharing";
    private static final String ENDPOINT = "http://jsayler.icoolshow.net/AD410-json/nes_games.json";

    private RequestQueue requestQueue;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        context = getApplicationContext();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayoutJSON);
        recyclerView = (RecyclerView) findViewById(R.id.jsonPost);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        fetchPosts();
    }

    public void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);
        requestQueue.add(request);
        Log.d(msg, "fetchPosts()");
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<JSONLayout> posts = Arrays.asList(gson.fromJson(response, JSONLayout[].class));
            jsonRecyclerViewAdapter = new RecyclerViewAdapter(context, posts);
            recyclerView.setAdapter(jsonRecyclerViewAdapter);
            Log.d(msg, "Response.Listener");
            for (JSONLayout post : posts) {
                Log.i("PostActivity", post.title + ": " + post.date);
            }
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(msg, error.toString());
        }
    };
}
