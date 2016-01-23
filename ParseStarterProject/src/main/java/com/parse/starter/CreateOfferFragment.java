package com.parse.starter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wolf on 1/23/2016.
 */
public class CreateOfferFragment extends Fragment {


    private static final String LOG_TAG = "LOGTRACE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_offer, container, false);







        return rootView;

    }


}
