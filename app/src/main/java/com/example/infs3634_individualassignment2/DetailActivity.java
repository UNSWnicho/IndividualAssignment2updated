package com.example.infs3634_individualassignment2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    TextView dName, dLocation, dRating, dDesc, dTimezone;
    ImageView dImage;
    ImageView dMap;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");
        Intent intent = getIntent();
        String msg = intent.getStringExtra("key");
        Holiday holiday = Holiday.findHolidays(msg);
        Log.d(TAG, "Received Message " + msg);

        Log.d(TAG, "Holiday Name: " + holiday.getName());

        // Get handle to view elements
        dName = findViewById(R.id.tvHolidayName);
        dLocation = findViewById(R.id.tvLocation);
        dRating = findViewById(R.id.tvRating);
        dTimezone = findViewById(R.id.tvTimeZone);
        dDesc = findViewById(R.id.tvShortDesc);
        dImage = findViewById(R.id.tvImage);
        dMap = findViewById(R.id.tvImage);


        // Set values
        dName.setText(holiday.getName());
        dLocation.setText(holiday.getLocation());
        dRating.setText(holiday.getRating());
        dTimezone.setText(holiday.getTime_zone());
        dDesc.setText(holiday.getDescription());
        // Detail view -> Setting both Image of location and Map image
//        dImage.setImageIcon(holiday.getImage());
//        dMap.setImageResource(holiday.getMap());

    }
}

