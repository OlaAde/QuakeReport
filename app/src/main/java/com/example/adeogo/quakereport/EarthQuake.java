package com.example.adeogo.quakereport;

/**
 * Created by Adeogo on 1/28/2017.
 */

public class EarthQuake {

    private double mMagnitude;

    private String mPlace;

    private long mTime;

    private String mUrl;

    public EarthQuake(double Magnitude, String Place, long Time, String Url){
        mMagnitude = Magnitude;

        mPlace = Place;

        mTime = Time;

        mUrl = Url;

    }

    public double getmMagnitude() {
        return mMagnitude;
    }
    public String getmUrl() {
        return mUrl;
    }

    public String getmPlace() {
        return mPlace;
    }

    public long getmTime() {
        return mTime;
    }
}
