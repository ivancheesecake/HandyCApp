package com.uplbphillidar1.handycapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Fragment_ViewRecords extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    TextView content;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true);

        View myInflatedView =  inflater.inflate(R.layout.fragment_view_records, container, false);

        expListView = (ExpandableListView) myInflatedView.findViewById(R.id.lvExp);
//        content = (TextView) myInflatedView.findViewById(R.id.records);

        DatabaseHelper db = new DatabaseHelper(this.getActivity());

        List<Record> records = db.getAllRecords();


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        ArrayList <ArrayList <String>> children = new  ArrayList<ArrayList<String>>();

        for(int i=0; i<records.size(); i++){

            // Add header data
            listDataHeader.add("Record #"+Integer.toString(records.get(i).getId()));

            // Add child data

            ArrayList <String> childData = new ArrayList<String>();
            childData.add("("+records.get(i).getLatitude()+","+records.get(i).getLongitude()+")");
            childData.add(records.get(i).getRiverBasin());
            childData.add(records.get(i).getBarangay());
            childData.add(records.get(i).getMunicipality());
            childData.add(records.get(i).getProvince());
            childData.add(records.get(i).getEvents());
            childData.add(records.get(i).getDateOfOccurrence());
            childData.add(records.get(i).getTimeOfOccurrence());
            childData.add(records.get(i).getFloodDepth()+"m");

            children.add(childData);

            listDataChild.put("Record #"+Integer.toString(records.get(i).getId()),children.get(i));
        }


        listAdapter = new ExpandableListAdapter(this.getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);




        return myInflatedView;
    }

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.view_records_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.deleteAll:
                deleteAllRecords();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void deleteAllRecords(){

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked

                        DatabaseHelper db = new DatabaseHelper(getActivity());
                        db.deleteAll();

                        LinearLayout recordList = (LinearLayout) getActivity().findViewById(R.id.recordList);
                        recordList.removeAllViews();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Are you sure you want to delete all records?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


//
//
    }

}
