package com.uplbphillidar1.handycapp;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_CreateRecord extends android.app.Fragment {

    public static View inflatedView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        inflatedView =  inflater.inflate(R.layout.fragment_create_record, container, false);

        EditText latitude = (EditText) inflatedView.findViewById(R.id.latitude);
        EditText longitude = (EditText) inflatedView.findViewById(R.id.longitude);

        latitude.setText(Double.toString(MainActivity.currentLatitude));
        longitude.setText(Double.toString(MainActivity.currentLongitude));
//        MainActivity.currentLatitude

        Button button = (Button) inflatedView.findViewById(R.id.requestLocation);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText latitude = (EditText) inflatedView.findViewById(R.id.latitude);
                EditText longitude = (EditText) inflatedView.findViewById(R.id.longitude);

                  latitude.setText(Double.toString(MainActivity.currentLatitude));
                  longitude.setText(Double.toString(MainActivity.currentLongitude));
            }
        });

        return inflatedView;

    }

    public Record getData(){

        EditText latitude = (EditText) this.getActivity().findViewById(R.id.latitude);
        String latitude_str =latitude.getText().toString();

//        Toast.makeText(getActivity(),latitude_str,Toast.LENGTH_SHORT).show();

        EditText longitude = (EditText) this.getActivity().findViewById(R.id.longitude);
        String longitude_str =  longitude.getText().toString();

        EditText riverBasin = (EditText) this.getActivity().findViewById(R.id.riverBasin);
        String riverBasin_str = riverBasin.getText().toString();

        Spinner buildingUse = (Spinner) this.getActivity().findViewById(R.id.buildingUse);
        String buildingUse_str = buildingUse.getSelectedItem().toString();

        EditText buildingName = (EditText) this.getActivity().findViewById(R.id.buildingName);
        String buildingName_str = buildingName.getText().toString();

        EditText barangay = (EditText) this.getActivity().findViewById(R.id.barangay);
        String barangay_str = barangay.getText().toString();

        EditText municipality = (EditText) this.getActivity().findViewById(R.id.municipality);
        String municipality_str = municipality.getText().toString();

        Spinner province = (Spinner) this.getActivity().findViewById(R.id.province);
        String province_str = province.getSelectedItem().toString();

        EditText events = (EditText) this.getActivity().findViewById(R.id.events);
        String events_str = events.getText().toString();

        EditText dateOfOccurrence = (EditText) this.getActivity().findViewById(R.id.dateOccurrence);
        String dateOfOccurrence_str = dateOfOccurrence.getText().toString();

        EditText timeOfOccurrence = (EditText) this.getActivity().findViewById(R.id.timeOccurrence);
        String timeOfOccurrence_str = timeOfOccurrence.getText().toString();

        EditText floodDepth = (EditText) this.getActivity().findViewById(R.id.floodDepth);
        String floodDepth_str =  floodDepth.getText().toString();

        Record new_record = new Record(latitude_str,longitude_str,riverBasin_str,buildingName_str,buildingUse_str,barangay_str,municipality_str,province_str,events_str,dateOfOccurrence_str,timeOfOccurrence_str,floodDepth_str);

        return new_record;
    }


}


