package com.example.bloodlink.becomeadonor;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.R;
import com.example.bloodlink.dashboard.dashboard;

import java.util.Calendar;

public class becomeadonor extends AppCompatActivity {
    DatePickerDialog.OnDateSetListener setListener;
    TextView dob;
    CheckBox checkBox;
    EditText fullName, bloodGroup, address, lastdonatedtime, gender;
    Button button, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becomeadonor);
        dob = findViewById(R.id.dob);
        fullName = findViewById(R.id.fullName);
        bloodGroup = findViewById(R.id.bloodGroup);
        address = findViewById(R.id.address);
        lastdonatedtime = findViewById(R.id.lastdonatedtime);
        gender = findViewById(R.id.gender);

        checkBox = findViewById(R.id.checkBox);
        button = findViewById(R.id.button);
        cancel = findViewById(R.id.cancel);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        becomeadonor.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our edit text.
                        // dob.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        dob.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                    }
                },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


        //checkbox ko lagi
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the checkbox is checked
                if (checkBox.isChecked()) {
                    // Check if all EditText fields are filled
                    //  int dayOfMonth = 0;
                    // int monthOfYear=0;
                    // int year = 0;
                    //String D= dob.getText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year).toString();
                    // int s=Integer.parseInt(D);
                    String dobText = dob.getText().toString().trim(); // Trim to remove leading/trailing spaces
                    if (isEditTextFilled(fullName) &&
                            isEditTextFilled(bloodGroup) &&
                            isEditTextFilled(address) &&
                            !dobText.isEmpty() &&
                            isEditTextFilled(lastdonatedtime) &&
                            isEditTextFilled(gender)) {
                        // ------All fields are filled, show success message OR DATABASE HALNU
                        Toast.makeText(becomeadonor.this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
                        // Clear all EditText fields
                        fullName.getText().clear();
                        bloodGroup.getText().clear();
                        address.getText().clear();
                        lastdonatedtime.getText().clear();
                        gender.getText().clear();
                        dob.setText("");
                    } else {
                        // At least one field is empty, show an error message
                        Toast.makeText(becomeadonor.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Checkbox is not checked, show a message
                    Toast.makeText(becomeadonor.this, "Please check the 'Become a Donor' checkbox.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(becomeadonor.this, dashboard.class);
                startActivity(intent);
            }
        });
    }

    // Helper function to check if an EditText is filled
    private boolean isEditTextFilled(EditText editText) {
        return editText.getText() != null && !editText.getText().toString().isEmpty();
    }
}


