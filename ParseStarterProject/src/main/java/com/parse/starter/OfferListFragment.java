package com.parse.starter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wolf on 1/23/2016.
 */
public class OfferListFragment extends Fragment {

    private static final String LOG_TAG = "LOGTRACE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_offer, container, false);


        /*
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("JobOffer");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> markers, ParseException e) {
                if (e == null) {
                    // your logic here

                    for (int i = 0; i< markers.size(); i++){

                        Log.d(LOG_TAG, "The record is: " + markers.get(i));

                    }
                } else {
                    // handle Parse Exception here


                }
            }
        });*/



        return rootView;
    }

    public void getData(){

        List<Information> data = new ArrayList<>();




    }

}
