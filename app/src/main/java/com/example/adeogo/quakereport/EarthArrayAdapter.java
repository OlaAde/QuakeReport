package com.example.adeogo.quakereport;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Adeogo on 1/28/2017.
 */

public class EarthArrayAdapter extends ArrayAdapter<EarthQuake> {
    double mMagnitude;
    String mFormattedMagnitude;

    public EarthArrayAdapter(Activity context, ArrayList<EarthQuake> quakeArrayList) {
        super(context, 0, quakeArrayList);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_list_item, parent, false);

            EarthQuake currentEarthQuake = getItem(position);

            TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

            mMagnitude = currentEarthQuake.getmMagnitude();

            DecimalFormat formatter = new DecimalFormat("0.00");

           mFormattedMagnitude = formatter.format(mMagnitude);

            // Set the proper background color on the magnitude circle.
            // Fetch the background from the TextView, which is a GradientDrawable.
            GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();



            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(currentEarthQuake.getmMagnitude());

            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

            magnitudeTextView.setText(mFormattedMagnitude);

            TextView place1 = (TextView) listItemView.findViewById(R.id.place1);

            TextView place2 = (TextView) listItemView.findViewById(R.id.place2);

            String location = currentEarthQuake.getmPlace();

            if (location.contains("of"))
            {
                String[] splittedParts = location.split("(?<= of)");

                String part1 = splittedParts[0];

                String part2 = splittedParts[1];

                place1.setText(part1);

                place2.setText(part2);

            }
            else {
                place1.setText(R.string.near_the);

                place2.setText(location);
            }

            TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

            TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);

            long mTime = currentEarthQuake.getmTime();

            Date dateObject = new Date(mTime);

            SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");

            SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

            String dateString = dateFormatter.format(dateObject);

            String timeString = timeFormatter.format(dateObject);

            dateTextView.setText(dateString);

            timeTextView.setText(timeString);

        }
        return listItemView;
    }
}
