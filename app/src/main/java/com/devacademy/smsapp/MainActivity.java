package com.devacademy.smsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sms_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                smsIntent.setType("vnd.android-dir/mms-sms");

                Intent chooser = Intent.createChooser(smsIntent, "Sms apps available:");
                if (smsIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(MainActivity.this, "Nu aveti client de sms", Toast.LENGTH_LONG).show();
                }

            }
        });

        findViewById(R.id.gallety_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent galleryIntent = new Intent(Intent.ACTION_VIEW);
                galleryIntent.setType("image/*");

                Intent chooser = Intent.createChooser(galleryIntent, "Gallery apps:");
                if (galleryIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                } else {
                    Toast.makeText(MainActivity.this, "Nu aveti applicatii pentru galerier", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
