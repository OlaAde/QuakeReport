package com.example.adeogo.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeActivity extends AppCompatActivity {
     private EarthArrayAdapter mEarthArrayAdapter;

    private static final String USGS_StringUrl = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);


        mEarthArrayAdapter = new EarthArrayAdapter(this, new ArrayList<EarthQuake>());
        ListView listView = (ListView) findViewById(R.id.list);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        listView.setAdapter(mEarthArrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                // String Url = earthquakesList.get(position).getmUrl();

                EarthQuake currentEarthQuake = mEarthArrayAdapter.getItem(position);

                String Url = currentEarthQuake.getmUrl();
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
                startActivity(webIntent);
            }
        });
        EarthQuakeAsyncTask earthQuakeAsyncTask = new EarthQuakeAsyncTask();
        earthQuakeAsyncTask.execute(USGS_StringUrl);
    }

    private class EarthQuakeAsyncTask extends AsyncTask<String, Void, List<EarthQuake>> {

        @Override
        protected List<EarthQuake> doInBackground(String... urls) {

            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length <  1 || urls[0]== null) {
                return null;
            }
            List<EarthQuake> arrayList = QueryUtils.extractEarthquakes(urls[0]);

            return arrayList;
        }
        @Override
        protected void onPostExecute (List<EarthQuake> arrayList){
            // Create a new adapter that takes the list of earthquakes as input
            //Сразу сделает все.
            mEarthArrayAdapter.clear();
            if (arrayList != null && !arrayList.isEmpty())
            {
                mEarthArrayAdapter.addAll();
            }


        }

    }
}
