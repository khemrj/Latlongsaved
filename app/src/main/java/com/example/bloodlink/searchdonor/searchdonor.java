package com.example.bloodlink.searchdonor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
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
        binding.patientNameContainer.setHelperText("");
        binding.pintContainer.setHelperText("");
        binding.addressContainer.setHelperText("");
        patientNameFocusListener();
        pintFocusListener();
        addressFocusListener();

        arrbloodGroup.add("A+");
        arrbloodGroup.add("AB+");
        arrbloodGroup.add("AB-");
        arrbloodGroup.add("B+");
        arrbloodGroup.add("B-");
        arrbloodGroup.add("O-");
        arrbloodGroup.add("O+");

        ArrayAdapter<String> bloodAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrbloodGroup);
        binding.bloodgroup.setAdapter(bloodAdapter);
        binding.btn.setOnClickListener(new View.OnClickListener() {

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

                String patient = binding.patientNameEditText.getText().toString();
                String bloodgroup = binding.bloodgroup.getText().toString();
                String pint = binding.pintEditText.getText().toString();
                String s = binding.addressEditText.getText().toString();
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
    private void patientNameFocusListener() {
        binding.patientNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                String result = validpatientName();
                if (result != null) {
                    binding.patientNameContainer.setHelperText(result);

                } else {
                    binding.patientNameContainer.setHelperText("");
                    // Clear error text if email is valid
                }
            }
        });
    }
    private String validpatientName() {
        String patientNameText = binding.patientNameEditText.getText().toString().trim();
        if (patientNameText.isEmpty()) {
            return "Patient name cannot be empty";
        }
        return null; // Return null if email is valid
    }
    private void pintFocusListener() {
        binding.pintEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String result = validPint();
                if (result != null) {
                    binding.pintContainer.setHelperText(result);

                } else {
                    binding.pintContainer.setHelperText("");
                    // Clear error text if email is valid
                }
            }
        });

    }

    private String validPint() {
        String pintNumber = binding.pintEditText.getText().toString().trim();
        if (pintNumber.length()>3) {
            return "Less than 3 pint is valid";
        }
        return null; // Return null if email is valid
    }
    private void addressFocusListener() {
        binding.addressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                String result = validAddress();
                if (result != null) {
                    binding.addressContainer.setHelperText(result);

                } else {
                    binding.addressContainer.setHelperText("");
                    // Clear error text if email is valid
                }
            }
        });
    }
    private String validAddress() {
        String addressText = binding.addressEditText.getText().toString().trim();
        if (addressText.isEmpty()) {
            return "Please enter your address";
        }
        return null; // Return null if email is valid
    }
}



