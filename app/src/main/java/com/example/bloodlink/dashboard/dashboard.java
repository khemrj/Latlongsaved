package com.example.bloodlink.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.databinding.ActivityDashboardBinding;
import com.example.bloodlink.myprofile.myprofile;
import com.example.bloodlink.searchdonor.searchdonor;

public class dashboard extends AppCompatActivity {
ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.requested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this, searchdonor.class);
                startActivity(intent);
            }
        });
       binding.person.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(dashboard.this, myprofile.class);
               startActivity(intent);
           }
       });

    }
}