package com.devacademy.running3;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Running3 extends Activity {

    ListView list;
    String[] dataArray;
    String[] kilometersArray;
    String km;
    Integer[] imgRunDetailsId = {
            R.drawable.image1,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    Integer imgAvgPaceId = R.drawable.image5;
    String[] txtAvgPace;
    Integer imgTotalTimeId = R.drawable.image6;
    String[] txtTotalTime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running3);

        dataArray = getResources().getStringArray(R.array.datas);
        kilometersArray = getResources().getStringArray(R.array.kilometers);
        km = getResources().getString(R.string.km);
        txtAvgPace = getResources().getStringArray(R.array.txt_avg_pace);
        txtTotalTime = getResources().getStringArray(R.array.txt_total_time);

        CustomList adapter = new
                CustomList(Running3.this, dataArray, kilometersArray, km, imgRunDetailsId, imgAvgPaceId,
                            txtAvgPace, imgTotalTimeId, txtTotalTime);

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);


    }
}
