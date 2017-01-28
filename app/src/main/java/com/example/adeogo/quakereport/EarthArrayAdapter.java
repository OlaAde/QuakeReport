package com.example.adeogo.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adeogo on 1/28/2017.
 */

public class EarthArrayAdapter extends ArrayAdapter<EarthQuake> {

    public EarthArrayAdapter(Activity context, ArrayList<EarthQuake> quakeArrayList) {
        super(context, 0, quakeArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list_item, parent, false);

            EarthQuake currentEarthQuake = getItem(position);

            TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

            magnitude.setText(currentEarthQuake.getmMagnitude());


            TextView place = (TextView) listItemView.findViewById(R.id.place);

            place.setText(currentEarthQuake.getmPlace());


            TextView date = (TextView) listItemView.findViewById(R.id.date);

            date.setText(currentEarthQuake.getmDate());
        }
        return listItemView;
    }
}
