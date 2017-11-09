package com.uplbphillidar1.handycapp;

/**
 * Created by Admin on 6/14/2016.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_RECORD = "records";                    //Table names

    private static final String KEY_ID = "id";                //Column names
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_RIVERBASIN = "riverBasin";
    private static final String KEY_BUILDINGNAME = "buildingName";
    private static final String KEY_BUILDINGUSE = "buildingUse";
    private static final String KEY_BARANGAY = "barangay";
    private static final String KEY_MUNICIPALITY = "municipality";
    private static final String KEY_PROVINCE = "province";
    private static final String KEY_EVENTS = "events";
    private static final String KEY_DATEOFOCCURRENCE = "dateOfOccurrence";
    private static final String KEY_TIMEOFOCCURRENCE = "timeOfOccurrence";
    private static final String KEY_FLOODDEPTH = "floodDepth";

    private static final int DATABASE_VERSION = 5;

    // Version 5
    // Added River Basin

    private static final String DATABASE_NAME = "RecordsDB";

    public DatabaseHelper(Context context) {                //constructor for DatabaseHelper
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
     * Creation of the database
     *
     * */
    public void onCreate(SQLiteDatabase db) {


//        String CREATE_RECORD_TABLE = "CREATE TABLE records ( " +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//
//                "latitude TEXT, " +
//                "longitude TEXT, " +
//                "buildingName TEXT, " +
//                "buildingUse TEXT, " +
//                "barangay TEXT, " +
//                "events TEXT, " +
//                "dateOfOccurrence TEXT, " +
//                "timeOfOccurrence TEXT, " +
//                "floodDepth TEXT " +
//
//                ")";

        String CREATE_RECORD_TABLE = "CREATE TABLE records ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +

                "latitude TEXT, " +
                "longitude TEXT, " +
                "riverBasin TEXT, "+
                "buildingName TEXT, " +
                "buildingUse TEXT, " +
                "barangay TEXT, " +
                "municipality TEXT, "+
                "province TEXT, "+
                "events TEXT, " +
                "dateOfOccurrence TEXT, " +
                "timeOfOccurrence TEXT, " +
                "floodDepth TEXT " +

                ")";

        db.execSQL(CREATE_RECORD_TABLE);

        Log.d("HEY","I JUST CREATED A TABLE");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS records");
        this.onCreate(db);
    }

    /*
    * Function that adds a record to the table "record"
    *
    * */
    public void addRecord(Record record) {

        Log.d("HEY","I JUST ADDEFD A RECORD");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LATITUDE, record.getLatitude());
        values.put(KEY_LONGITUDE, record.getLongitude());
        values.put(KEY_RIVERBASIN, record.getRiverBasin());
        values.put(KEY_BUILDINGNAME, record.getBuildingName());
        values.put(KEY_BUILDINGUSE, record.getBuildingUse());
        values.put(KEY_BARANGAY, record.getBarangay());
        values.put(KEY_MUNICIPALITY, record.getMunicipality());
        values.put(KEY_PROVINCE,record.getProvince());
        values.put(KEY_EVENTS, record.getEvents());
        values.put(KEY_DATEOFOCCURRENCE, record.getDateOfOccurrence());
        values.put(KEY_TIMEOFOCCURRENCE, record.getTimeOfOccurrence());
        values.put(KEY_FLOODDEPTH, record.getFloodDepth());

        db.insert(TABLE_RECORD, null, values);

        db.close();

    }

    public void deleteAll(){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_RECORD,null,null);
        db.close();
    }

    /*
     * Function for retrieving all rows from the table "record" that has a specific projectId
     *
     * */
    public List<Record> getAllRecords() {
        Log.d("Current Records","");
        List<Record> records = new LinkedList<Record>();

        String query = "SELECT  * FROM " + TABLE_RECORD + " ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Record record = null;
        if (cursor.moveToFirst()) {

            do {
                record = new Record();
                record.setId(Integer.parseInt((cursor.getString(0))));
                record.setLatitude(cursor.getString(1));
                record.setLongitude(cursor.getString(2));
                record.setRiverBasin(cursor.getString(3));
                record.setBuildingName(cursor.getString(4));
                record.setBuildingUse(cursor.getString(5));
                record.setBarangay(cursor.getString(6));
                record.setMunicipality(cursor.getString(7));
                record.setProvince(cursor.getString(8));
                record.setEvents(cursor.getString(9));
                record.setDateOfOccurrence(cursor.getString(10));
                record.setTimeOfOccurrence(cursor.getString(11));
                record.setFloodDepth(cursor.getString(12));

                records.add(record);
            } while (cursor.moveToNext());
        }
        db.close();
        return records;
    }

}
