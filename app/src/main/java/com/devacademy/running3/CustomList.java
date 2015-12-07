package com.devacademy.running3;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by bobo on 04.12.2015.
 */
public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] dataArray;
    private final String[] kilometersArray;
    private final String km;
    private final Integer[] imgRunDetailsId;
    private final Integer imgAvgPaceId;
    private final String[] txtAvgPace;
    private final Integer imgTotalTimeId;
    private final String[] txtTotalTime;

    public CustomList (Activity context, String[] dataArray, String[] kilometersArray, String km,
                       Integer[] imgRunDetailsId, Integer imgAvgPaceId, String[] txtAvgPace,
                       Integer imgTotalTimeId, String[] txtTotalTime) {

        super (context, R.layout.list_single, dataArray);
        this.context = context;
        this.dataArray = dataArray;
        this.kilometersArray = kilometersArray;
        this.km = km;
        this.imgRunDetailsId = imgRunDetailsId;
        this.imgAvgPaceId = imgAvgPaceId;
        this.txtAvgPace = txtAvgPace;
        this.imgTotalTimeId = imgTotalTimeId;
        this.txtTotalTime = txtTotalTime;

    }

    public View getView (int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View myView;
        if (position != 1) {
            myView = inflater.inflate(R.layout.list_single, null, true);

            TextView dataView = (TextView) myView.findViewById(R.id.data);
            TextView kilometersView = (TextView) myView.findViewById(R.id.kilometers);
            TextView kmView = (TextView) myView.findViewById(R.id.km);
            ImageView imgRunDetailsView = (ImageView) myView.findViewById(R.id.img_run_details);
            ImageView imgAvgPaceView = (ImageView) myView.findViewById(R.id.img_avg_pace);
            TextView txtAvgPaceView = (TextView) myView.findViewById(R.id.txt_avg_pace);
            ImageView imgTotalTimeView = (ImageView) myView.findViewById(R.id.img_total_time);
            TextView txtTotalTimeView = (TextView) myView.findViewById(R.id.txt_total_time);

            dataView.setText(dataArray[position]);
            kilometersView.setText(kilometersArray[position]);
            kmView.setText(km);
            imgRunDetailsView.setImageResource(imgRunDetailsId[position]);
            imgAvgPaceView.setImageResource(imgAvgPaceId);
            txtAvgPaceView.setText(txtAvgPace[position]);
            imgTotalTimeView.setImageResource(imgTotalTimeId);
            txtTotalTimeView.setText(txtTotalTime[position]);
        } else {
            myView = inflater.inflate(R.layout.header2, null, true);
        }
        return myView;

    }

}
