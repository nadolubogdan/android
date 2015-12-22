package com.devacademy.running3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by bobo on 22.12.2015.
 */
public class DetailFrame extends AppCompatActivity {

    public static final String BUNDLE_DATA = "bundle_data";

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_frame_layout);

        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty() && bundle != null) {

            ((TextView)findViewById(R.id.detail_for_portrait)).setText(bundle.getString(BUNDLE_DATA));

        }

    }

}
