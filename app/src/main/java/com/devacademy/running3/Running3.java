package com.devacademy.running3;

import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Running3 extends FragmentActivity {

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
    ArrayList<Integer> imgRunDetailsIdArray = new ArrayList<Integer>(Arrays.asList(imgRunDetailsId));
    Integer imgAvgPaceId = R.drawable.image5;
    String[] txtAvgPace;
    Integer imgTotalTimeId = R.drawable.image6;
    String[] txtTotalTime;
    String[] elementInfo;

    public static final String KEY_DataArray = "KEY_DataArray";
    public static final String KEY_KilometersArray = "KEY_KilometersArray";
    public static final String KEY_km = "KEY_km";
    public static final String KEY_IMAGES = "KEY_IMAGES";
    public static final String KEY_imgAvgPaceId = "KEY_imgAvgPaceId";
    public static final String KEY_txtAvgPace = "KEY_txtAvgPace";
    public static final String KEY_imgTotalTimeId = "KEY_imgTotalTimeId";
    public static final String KEY_txtTotalTime = "KEY_txtTotalTime";
    public static final String KEY_elementInfo = "KEY_elmentInfo";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running3);
        initLayout(savedInstanceState);

        dataArray = getResources().getStringArray(R.array.datas);
        kilometersArray = getResources().getStringArray(R.array.kilometers);
        km = getResources().getString(R.string.km);
        txtAvgPace = getResources().getStringArray(R.array.txt_avg_pace);
        txtTotalTime = getResources().getStringArray(R.array.txt_total_time);
        elementInfo = getResources().getStringArray(R.array.list_elements_information);

        CustomList adapter = new
                CustomList(Running3.this, dataArray, kilometersArray, km, imgRunDetailsId, imgAvgPaceId,
                            txtAvgPace, imgTotalTimeId, txtTotalTime);

        list = (ListView) findViewById(R.id.list);
        if (list != null) {
            list.setAdapter(adapter);
        }

    }

    protected void initLayout(Bundle savedInstanceState) {
        if (findViewById(R.id.activity_main_fragment_container) != null) {
            //we don't want to get overlapping fragments
            if (savedInstanceState != null) {

                manageScreenOrientation();

            } else {
                manageScreenOrientation();

//                PortraitFragment portraitFragment = new PortraitFragment();
//                portraitFragment.setArguments(getIntent().getExtras());
//
//                getSupportFragmentManager().beginTransaction().
//                        add(R.id.activity_main_fragment_container, portraitFragment).commit();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

    }

    private void manageScreenOrientation() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            switchToPortrait();
        } else {
            switchToLandscape();
        }
    }

    private void switchToPortrait() {

        PortraitFragment portraitFragment = new PortraitFragment();

        Bundle args = new Bundle();
        args.putStringArray(KEY_DataArray, getResources().getStringArray(R.array.datas));
        args.putStringArray(KEY_KilometersArray, getResources().getStringArray(R.array.kilometers));
        args.putString(KEY_km, "km");
        args.putIntegerArrayList(KEY_IMAGES, imgRunDetailsIdArray);
        args.putInt(KEY_imgAvgPaceId, imgAvgPaceId);
        args.putStringArray(KEY_txtAvgPace, getResources().getStringArray(R.array.txt_avg_pace));
        args.putInt(KEY_imgTotalTimeId, imgTotalTimeId);
        args.putStringArray(KEY_txtTotalTime, getResources().getStringArray(R.array.txt_total_time));
        args.putStringArray(KEY_elementInfo, getResources().getStringArray(R.array.list_elements_information));
        portraitFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_fragment_container, portraitFragment)
        //        .addToBackStack(null)
                .commit();
    }

    private void switchToLandscape() {

        LandscapeFragment landscapeFragment = new LandscapeFragment();

        Bundle args = new Bundle();
        args.putStringArray(KEY_DataArray, getResources().getStringArray(R.array.datas));
        args.putStringArray(KEY_KilometersArray, getResources().getStringArray(R.array.kilometers));
        args.putString(KEY_km, "km");
        args.putIntegerArrayList(KEY_IMAGES, imgRunDetailsIdArray);
        args.putInt(KEY_imgAvgPaceId, imgAvgPaceId);
        args.putStringArray(KEY_txtAvgPace, getResources().getStringArray(R.array.txt_avg_pace));
        args.putInt(KEY_imgTotalTimeId, imgTotalTimeId);
        args.putStringArray(KEY_txtTotalTime, getResources().getStringArray(R.array.txt_total_time));
        args.putStringArray(KEY_elementInfo, getResources().getStringArray(R.array.list_elements_information));
        landscapeFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_fragment_container, landscapeFragment)
        //        .addToBackStack(null)
                .commit();
    }

}
