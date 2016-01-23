package com.parse.starter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by wolf on 1/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList(); //On this array i will save the data coming from the fragment
    Context context;


    RecyclerViewAdapter(Context context, List<Information> data) { //to initialize the adapter

        Log.d("RECYCLER", "Entering at RecylerPlanRouteAdapter constructor");

        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

