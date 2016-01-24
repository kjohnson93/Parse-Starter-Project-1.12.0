package com.parse.starter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class OfferListActivity extends BaseActivity {

    private static final String LOG_TAG = "LOGTRACE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_list);

        agregarToolbar();
        setUpDrawer();


        //recyclerView = (RecyclerView) findViewById(R.id.recycler_id2);
        //recyclerViewAdapter = new RecyclerViewAdapter(this, getData());

;






    }


    public void getData(){






    }


    @Override
    public void onBackPressed() {

        Log.d(LOG_TAG, " Entering onBackPressed on OfferListActivity");

        super.onBackPressed();
    }
}
