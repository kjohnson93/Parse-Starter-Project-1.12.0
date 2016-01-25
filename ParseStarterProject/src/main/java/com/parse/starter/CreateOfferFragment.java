package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wolf on 1/23/2016.
 */
public class CreateOfferFragment extends Fragment {


    private static final String LOG_TAG = "LOGTRACE";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.create_offer, container, false);




        Button buttonUpload = (Button) rootView.findViewById(R.id.button_upload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadData(rootView);

                Intent intent = new Intent(getActivity(), OfferListActivity.class);
                startActivity(intent);

            }
        });


        return rootView;

    }

    private void uploadData(View rootView) {

        Information info = new Information();

        EditText edtTitle, edtCompany, edtDescription;
        TextView tvwStartDate, tvwEndDate;
        Spinner spCategory;

        edtTitle = (EditText) rootView.findViewById(R.id.editTextTitle); //string
        edtCompany = (EditText) rootView.findViewById(R.id.editTextCompany); //string
        edtDescription = (EditText) rootView.findViewById(R.id.editTextDescription); //string

        tvwStartDate = (TextView) rootView.findViewById(R.id.selected_date); //date
        tvwEndDate = (TextView) rootView.findViewById(R.id.selected_date_end); //date

        spCategory = (Spinner) rootView.findViewById(R.id.spinner); //string or int

        info.title = edtTitle.getText().toString().trim();
        info.company = edtCompany.getText().toString().trim();
        info.description = edtDescription.getText().toString().trim();
        info.category = spCategory.getSelectedItemPosition();

        info.dateStart = tvwStartDate.getText().toString().trim();


        info.dateEnd = tvwEndDate.getText().toString().trim();




        ParseObject jobOffer = new ParseObject("JobOffers");

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
        //jobOffer.put("array", data);
        jobOffer.saveInBackground();




        ParseAnalytics.trackAppOpenedInBackground(getActivity().getIntent());


    }




}
