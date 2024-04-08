package com.example.bloodlink.searchdonor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.databinding.ActivitySearchdonorBinding;
import com.example.bloodlink.dlist;
import com.example.bloodlink.requestedpage.requestlistpage;

import java.util.ArrayList;

public class searchdonor extends AppCompatActivity {
    ActivitySearchdonorBinding binding;
    ArrayList<String>arrbloodGroup=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchdonorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrbloodGroup.add("A+");
        arrbloodGroup.add("AB+");
        arrbloodGroup.add("AB-");
        arrbloodGroup.add("B+");
        arrbloodGroup.add("B-");
        arrbloodGroup.add("O-");
        arrbloodGroup.add("O+");

        ArrayAdapter<String> bloodAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrbloodGroup);
        binding.bloodgroup.setAdapter(bloodAdapter);
        binding.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                if(binding.checkBox.isChecked())
//                {
//                    String s=binding.address.getText().toString();
//                }
//                else{
//                    String address=binding.address.getText().toString();
//                }
//                Intent intend=new Intent(searchdonor.this, dlist.class);
//                if(binding.checkBox.isChecked())
//                {
//                    String address=binding.address.getText().toString();
//                }
//                else{
//                    String address=binding.address.getText().toString();
//                }

                String patient = binding.patientName.getText().toString();
                String bloodgroup = binding.bloodgroup.getText().toString();
                String pint = binding.pint.getText().toString();
                String s = binding.address.getText().toString();
                if (patient.isEmpty() && bloodgroup.isEmpty() && pint.isEmpty() && s.isEmpty()) {
                    Toast.makeText(searchdonor.this, "Please enter a field", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(searchdonor.this, dlist.class);
                    intent.putExtra("bloodgroup", bloodgroup);
                    intent.putExtra("pints", pint);
                    intent.putExtra("address", s);
                    startActivity(intent);
                }

            }

        });
    }
}



