package com.uplbphillidar1.handycapp;


import android.*;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fragment_Export extends android.app.Fragment {

    public static View inflatedView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        inflatedView = inflater.inflate(R.layout.fragment_export, container, false);

        Button button = (Button) inflatedView.findViewById(R.id.createcsv_button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                EditText filename_et = (EditText) inflatedView.findViewById(R.id.filename);
                String filename = filename_et.getText().toString();

                createCSV(filename);
                Toast.makeText(getActivity(),"Successfully created the CSV file.",Toast.LENGTH_LONG).show();
            }
        });




        return inflatedView;

    }

    public void createCSV(String filename) {


        DatabaseHelper db = new DatabaseHelper(getActivity());
        List<Record> records = db.getAllRecords();

        String outstring = "id,latitude,longitude,riverBasin,buildingName,buildingUse,barangay,municipality,province,events,dateOfOccurrence,timeOfOccurrence,floodDepth\n";

        for (int i = 0; i < records.size(); i++) {

            outstring += Integer.toString(
                    records.get(i).getId()) + "," +
                    records.get(i).getLatitude() + "," +
                    records.get(i).getLongitude() + "," +
                    records.get(i).getRiverBasin() + "," +
                    records.get(i).getBuildingName() + "," +
                    records.get(i).getBuildingUse() + "," +
                    records.get(i).getBarangay() + "," +
                    records.get(i).getMunicipality() + "," +
                    records.get(i).getProvince() + "," +
                    records.get(i).getEvents() + "," +
                    records.get(i).getDateOfOccurrence() + "," +
                    records.get(i).getTimeOfOccurrence() +","+
                    records.get(i).getFloodDepth() +"\n";

        }


        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {


            } else {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            }
        } else {

            try {

                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/handycapp_csv/";
                new File(path).mkdir();
                File file = new File(path + filename);
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write((outstring + System.getProperty("line.separator")).getBytes());
            } catch (Exception e) {
                e.printStackTrace();

            }


        }
    }
}


