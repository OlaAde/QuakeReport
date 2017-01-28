package com.example.adeogo.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakesList = new ArrayList<>();
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));
        earthquakesList.add(new EarthQuake("7.2","San Franscisco", "Feb 2, 2016"));




        EarthArrayAdapter earthArrayAdapter = new EarthArrayAdapter(this,earthquakesList);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(earthArrayAdapter);

    }
}
