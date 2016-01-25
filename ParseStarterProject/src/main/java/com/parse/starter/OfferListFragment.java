package com.parse.starter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wolf on 1/23/2016.
 */
public class OfferListFragment extends Fragment implements RecyclerViewAdapter.ClickListener{

    private static final String LOG_TAG = "LOGTRACE";


    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    List<Information> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_offer, container, false);


    recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_id);


        ParseQuery<ParseObject> query = ParseQuery.getQuery("JobOffers");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < scoreList.size(); i++) {

                        Log.d(LOG_TAG, "Retrieved " + scoreList.size() + " scores");

                        String id=scoreList.get(i).getObjectId();
                        String  title= (String) scoreList.get(i).get("title");
                        String company= (String) scoreList.get(i).get("company");
                        String description = (String) scoreList.get(i).get("description");
                        String dateStart = (String) scoreList.get(i).get("dateStart");
                        String dateEnd = (String) scoreList.get(i).get("dateEnd");
                        int category = (int) scoreList.get(i).get("category");


                        Information infoTest = new Information(id,title,company, description, dateStart, dateEnd, category);
                        data.add(infoTest);

                    }

                    recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), data);
                    recyclerViewAdapter.setClickListener(OfferListFragment.this);
                    recyclerView.setAdapter(recyclerViewAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                } else {
                    Log.d(LOG_TAG, "Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });



        return rootView;
    }

    public void getData(){

        List<Information> data = new ArrayList<>();




    }


    @Override
    public void itemClicked(View view, int position) {

        Log.d(LOG_TAG, "Entering itemClick from interface with position: " + position);

    }
}
