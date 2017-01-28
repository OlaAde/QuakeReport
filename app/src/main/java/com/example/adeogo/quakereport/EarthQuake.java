package com.example.adeogo.quakereport;

/**
 * Created by Adeogo on 1/28/2017.
 */

public class EarthQuake {

    private String mMagnitude;

    private String mPlace;

    private String mDate;

    public EarthQuake(String Magnitude, String Place, String Date){
        mMagnitude = Magnitude;

        mPlace = Place;

        mDate = Date;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmPlace() {
        return mPlace;
    }

    public String getmDate() {
        return mDate;
    }
}
