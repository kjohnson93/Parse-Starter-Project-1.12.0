package com.parse.starter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CreateOfferActivity extends BaseActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public FragmentManager fragmentManager;
    private static final String LOG_TAG = "LOGTRACE";

    public static TextView SelectedDateView;
    public static TextView SelectedDateView2;

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {


            SelectedDateView.setText((month + 1) + "-" + day + "-" + year);

        }
    }

    public static class DatePickerFragmentEnd extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            Log.d(LOG_TAG, "Date selected: " + (month + 1) + "-" + day + "-" + year);
            Log.d(LOG_TAG, "Date selected with view " + view);


            SelectedDateView2.setText((month + 1) + "-" + day + "-" + year);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_offer);


        agregarToolbar();
        setUpDrawer();

        SelectedDateView = (TextView) findViewById(R.id.selected_date);
        SelectedDateView2 = (TextView) findViewById(R.id.selected_date_end);

        Button buttonUpload = (Button) findViewById(R.id.button_upload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadData();

                Intent intent = new Intent(CreateOfferActivity.this, OfferListActivity.class);
                startActivity(intent);

            }
        });


    }

    private void uploadData() {

        Information info = new Information();

        EditText edtTitle, edtCompany, edtDescription;
        TextView tvwStartDate, tvwEndDate;
        Spinner spCategory;

        edtTitle = (EditText) findViewById(R.id.editTextTitle); //string
        edtCompany = (EditText) findViewById(R.id.editTextCompany); //string
        edtDescription = (EditText) findViewById(R.id.editTextDescription); //string

        tvwStartDate = (TextView) findViewById(R.id.selected_date); //date
        tvwEndDate = (TextView) findViewById(R.id.selected_date_end); //date

        spCategory = (Spinner) findViewById(R.id.spinner); //string or int

        info.title = edtTitle.getText().toString().trim();
        info.company = edtCompany.getText().toString().trim();
        info.description = edtDescription.getText().toString().trim();
        info.category = spCategory.getSelectedItemPosition();

        if (tvwStartDate != null) {
            info.dateStart = tvwStartDate.getText().toString().trim();
        }

        if (tvwEndDate != null) {

            info.dateEnd = tvwEndDate.getText().toString().trim();

        }

        /*
        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();

        int score = gameScore.getInt("score");
        String playerName = gameScore.getString("playerName");
        boolean cheatMode = gameScore.getBoolean("cheatMode");


        Log.d(LOG_TAG, "My values are: " + "score: " + score + "playerName: " + playerName + "cheatMode: " + cheatMode);
        */




        /* Tried this approach, but forn some reason not working
        ParseObject jobOfferArray = new ParseObject("JobOfferArray");
        List<Information> data = new ArrayList<>();

        data.add(info);
        jobOfferArray.addAllUnique("array", data);
        jobOfferArray.saveInBackground();
        */


        ParseObject jobOffer = new ParseObject("JobOffer");

        List<String> data = new ArrayList<>();
        data.add(info.title);
        data.add(info.company);
        data.add(String.valueOf(info.category));
        data.add(info.description);
        data.add(info.dateStart);
        data.add(info.dateEnd);

        // data.add(info);

        //
        jobOffer.put("title", info.title);
        jobOffer.put("company", info.company);
        jobOffer.put("category", info.category);
        jobOffer.put("description", info.description);
        jobOffer.put("dateStart", info.dateStart);
        jobOffer.put("dateEnd", info.dateEnd);
        jobOffer.put("test", "blabla");
        //jobOffer.addAllUnique("skillsarray", Arrays.asList(data));
        //jobOffer.put("objecttest", Arrays.asList(info.title, info.company, info.category, info.description, info.dateStart, info.dateEnd)); arrays as list!!!!!!
        jobOffer.put("array", data);
        jobOffer.saveInBackground();

        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("JobOffer");
        query.whereEqualTo("dataStart" ,"Start Date");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> scoreList, ParseException e) {
                if (e == null) {
                    Log.d(LOG_TAG, "Retrieved " + scoreList.size() + " scores");




                    //Log.d(LOG_TAG, "Printing scoreList: " +  scoreList.get(0).getString("company"));
                } else {
                    Log.d(LOG_TAG, "Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });*/

/*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("JobOffer");
        query.whereExists("category");
        query.countInBackground(new CountCallback() {
            public void done(int count, ParseException e) {
                if (e == null) {
                    // The count request succeeded. Run the query multiple times using the query count
                    int numQueries = (int) Math.ceil(count / 1000); //Gives you how many queries to run
                    int l = 0;

                    for(int skipNum = 0; l < numQueries; l++){
                        ParseQuery<ParseObject> query = ParseQuery.getQuery("JobOffer");
                        query.whereExists("category");
                        query.setLimit(skipNum * 1000);
                        query.findInBackground(new FindCallback<ParseObject>() {
                            @Override
                            public void done(List<ParseObject> objects, ParseException e) {

                            }
                            //Run your query as normal here

                        }
                    }
                } else {
                    // The request failed
                }
            }*/



        ParseAnalytics.trackAppOpenedInBackground(getIntent());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_offer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDatePickerDialog(View v) {


        if (v.getId() == R.id.buttonDateStart) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "Start datePicker");
        }

        if (v.getId() == R.id.buttonDateEnd) {
            DialogFragment newFragmentEnd = new DatePickerFragmentEnd();
            newFragmentEnd.show(getSupportFragmentManager(), "End datePicker");
        }
    }


    @Override
    public void onBackPressed() {

        Log.d(LOG_TAG, " Entering onBackPressed on CreateOfferActivity");

        super.onBackPressed();
    }
}
