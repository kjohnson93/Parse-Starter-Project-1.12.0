package com.parse.starter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by wolf on 1/23/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList(); //On this array i will save the data coming from the fragment
    Context context;
    private ClickListener clickListener;
    private static final String LOG_TAG = "LOGTRACE";


    RecyclerViewAdapter(Context context, List<Information> data) { //to initialize the adapter

        Log.d("RECYCLER", "Entering at RecylerPlanRouteAdapter constructor");

        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder myViewHolder, int position) {

        Information current = data.get(position);

        Log.d(LOG_TAG, "Data passed is:" + current.company + current.dateStart);
        //on this part i set the content to the recyclerview item
        myViewHolder.textViewTitle.setText(current.title);
        //holder.imageView2.setImageResource(current.iconid2);
        myViewHolder.textViewCompany.setText(current.company);

        myViewHolder.textViewStartDate.setText(current.dateStart);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setClickListener(RecyclerViewAdapter.ClickListener clickListener){

        this.clickListener = clickListener;



    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTitle, textViewCompany, textViewStartDate;


        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            textViewTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textViewCompany = (TextView) itemView.findViewById(R.id.textViewCompany);
            textViewStartDate = (TextView) itemView.findViewById(R.id.textViewStartDate);
        }

        @Override
        public void onClick(View v) {

            /*

            Log.d(LOG_TAG, "Clicking this item.. " + getAdapterPosition());

            Information selectedItem = data.get(getAdapterPosition());

            Log.d(LOG_TAG, "DATA from item clicked: " + selectedItem.getTitle() + selectedItem.getCompany());

            Intent intent = new Intent(context, OfferDetailsActivity.class);
            context.startActivity(intent);*/

            if (clickListener != null){

                Log.d(LOG_TAG, "Entering onClickview normal with pos: " + getAdapterPosition());

                clickListener.itemClicked(v, getAdapterPosition());
            }

        }
    }


    public interface ClickListener{ //my interface implemented because following the approach of slidenerd

        public void itemClicked(View view, int position);

    }

}

