package com.parse.starter;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class CreateOfferActivity extends BaseActivity {


    private static final String LOG_TAG = "LOGTRACE";

    public static TextView SelectedDateView;
    public static TextView SelectedDateView2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_offer);


        agregarToolbar();
        setUpDrawer();


        SelectedDateView = (TextView) findViewById(R.id.selected_date);
        SelectedDateView2 = (TextView) findViewById(R.id.selected_date_end);



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
    public void onBackPressed() {

        Log.d(LOG_TAG, " Entering onBackPressed on CreateOfferActivity");

        super.onBackPressed();
    }
}
