package com.uplbphillidar1.handycapp;

/**
 * Created by Admin on 6/14/2016.
 */
public class Record {

    private int id;
    private String latitude;
    private String longitude;
    private String riverBasin;
    private String buildingName;
    private String buildingUse;
    private String barangay;
    private String municipality;
    private String province;
    private String events;
    private String dateOfOccurrence;
    private String timeOfOccurrence;
    private String floodDepth;

    public Record(){

        this.latitude = "0.0";
        this.longitude = "0.0";
        this.riverBasin = "";
        this.buildingName = "";
        this.buildingUse = "";
        this.barangay = "";
        this.municipality="";
        this.province = "";
        this.events = "";
        this.dateOfOccurrence = "";
        this.timeOfOccurrence = "";
        this.floodDepth = "0.0";


    }

    public Record(String latitude, String longitude, String riverBasin, String buildingName, String buildingUse, String barangay, String municipality, String province, String events, String dateOfOccurrence, String timeOfOccurrence, String floodDepth) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.riverBasin = riverBasin;
        this.buildingName = buildingName;
        this.buildingUse = buildingUse;
        this.barangay = barangay;
        this.municipality = municipality;
        this.province = province;
        this.events = events;
        this.dateOfOccurrence = dateOfOccurrence;
        this.timeOfOccurrence = timeOfOccurrence;
        this.floodDepth = floodDepth;
    }

    public Record(int id, String latitude, String longitude, String riverBasin,String buildingName, String buildingUse, String municipality, String province, String barangay, String events, String dateOfOccurrence, String timeOfOccurrence, String floodDepth) {

        super();

        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.riverBasin = riverBasin;
        this.buildingName = buildingName;
        this.buildingUse = buildingUse;
        this.barangay = barangay;
        this.municipality = municipality;
        this.province = province;
        this.events = events;
        this.dateOfOccurrence = dateOfOccurrence;
        this.timeOfOccurrence = timeOfOccurrence;
        this.floodDepth = floodDepth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingUse() {
        return buildingUse;
    }

    public void setBuildingUse(String buildingUse) {
        this.buildingUse = buildingUse;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getDateOfOccurrence() {
        return dateOfOccurrence;
    }

    public void setDateOfOccurrence(String dateOfOccurrence) {
        this.dateOfOccurrence = dateOfOccurrence;
    }

    public String getTimeOfOccurrence() {
        return timeOfOccurrence;
    }

    public void setTimeOfOccurrence(String timeOfOccurrence) {
        this.timeOfOccurrence = timeOfOccurrence;
    }

    public String getFloodDepth() {return floodDepth;}

    public void setFloodDepth(String floodDepth) {
        this.floodDepth = floodDepth;
    }

    public String getRiverBasin(){return this.riverBasin;}

    public void setRiverBasin(String riverBasin){
        this.riverBasin = riverBasin;
    }

    public String getMunicipality(){return this.municipality;}

    public void setMunicipality(String municipality){this.municipality = municipality;}

    public String getProvince(){return this.province;}

    public void setProvince(String province){
        this.province = province;
    }








}

