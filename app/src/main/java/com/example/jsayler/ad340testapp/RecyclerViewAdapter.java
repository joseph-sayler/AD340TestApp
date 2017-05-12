package com.example.jsayler.ad340testapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    View view1;
    ViewHolder viewHolder1;
    LayoutInflater inflater;
    List<JSONLayout> data = Collections.emptyList();

    public RecyclerViewAdapter(Context context1, List<JSONLayout> data){
        this.context = context1;
        inflater = LayoutInflater.from(context);
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        view1 = LayoutInflater.from(context).inflate(R.layout.recycler_adapter,parent,false);
        viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JSONLayout current = data.get(position);
        holder.textView1.setText(current.title);
        holder.textView2.setText(current.date);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView1;
        public TextView textView2;

        public ViewHolder(View v){

            super(v);

            textView1 = (TextView)v.findViewById(R.id.item1);
            textView2 = (TextView)v.findViewById(R.id.item2);
        }
    }
}