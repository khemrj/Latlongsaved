package com.example.bloodlink.donorpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.MapsActivity;
import com.example.bloodlink.R;
import com.example.bloodlink.dashboard.dashboard;

public class location extends AppCompatActivity {
    public ImageButton imageButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor_row);


        imageButton = findViewById(R.id.locationPin);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(location.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }
}