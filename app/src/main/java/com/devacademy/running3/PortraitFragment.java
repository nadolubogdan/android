package com.devacademy.running3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bobo on 14.12.2015.
 */
public class PortraitFragment extends Fragment {

    private String[] dataArray;
    private String[] kilometersArray;
    private String km;
    private ArrayList<Integer> imgRunDetailsIdArray;
    private Integer imgAvgPaceId;
    private String[] txtAvgPace;
    private Integer imgTotalTimeId;
    private String[] txtTotalTime;
    private String[] elementInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_portrait, container, false);

        Bundle args = getArguments();

        if (args != null) {

            dataArray = args.getStringArray(Running3.KEY_DataArray);
            kilometersArray = args.getStringArray(Running3.KEY_KilometersArray);
            km = args.getString(Running3.KEY_km);
            imgRunDetailsIdArray = args.getIntegerArrayList(Running3.KEY_IMAGES);
            imgAvgPaceId = args.getInt(Running3.KEY_imgAvgPaceId);
            txtAvgPace = args.getStringArray(Running3.KEY_txtAvgPace);
            imgTotalTimeId = args.getInt(Running3.KEY_imgTotalTimeId);
            txtTotalTime = args.getStringArray(Running3.KEY_txtTotalTime);
            elementInfo = args.getStringArray(Running3.KEY_elementInfo);

        }
        Integer[] imgRunDetailsId = new Integer[imgRunDetailsIdArray.size()];
        imgRunDetailsId = imgRunDetailsIdArray.toArray(imgRunDetailsId);

        CustomList adapter = new
                CustomList(getActivity(), dataArray, kilometersArray, km, imgRunDetailsId, imgAvgPaceId,
                txtAvgPace, imgTotalTimeId, txtTotalTime);

        ListView list = (ListView) view.findViewById(R.id.list);
        if (list != null) {
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent (getActivity(), DetailFrame.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(DetailFrame.BUNDLE_DATA, elementInfo[position]);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            });
        }

        return view;

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //can't do this here
//        TextView infoTextView = (TextView) getView().findViewById(R.id.fragment_portrait_info_textview);
//        infoTextView.setText(value);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //put some stuff in here
        //outState.putString("KEY_NAME", "value");
    }

}
