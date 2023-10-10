package com.example.bloodlink.searchdonor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.databinding.ActivitySearchdonorBinding;
import com.example.bloodlink.dlist;
import com.example.bloodlink.requestedpage.requestlistpage;

public class searchdonor extends AppCompatActivity {
    ActivitySearchdonorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchdonorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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
                String pints = binding.pints.getText().toString();
                String s = binding.address.getText().toString();
                if (patient.isEmpty() && bloodgroup.isEmpty() && pints.isEmpty() && s.isEmpty()) {
                    Toast.makeText(searchdonor.this, "Please enter a field", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(searchdonor.this, dlist.class);
                    intent.putExtra("bloodgroup", bloodgroup);
                    intent.putExtra("pints", pints);
                    intent.putExtra("address", s);
                    startActivity(intent);
                }

            }

        });
    }
}



