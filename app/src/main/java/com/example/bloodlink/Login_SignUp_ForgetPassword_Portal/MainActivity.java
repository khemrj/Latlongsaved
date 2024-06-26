package com.example.bloodlink.Login_SignUp_ForgetPassword_Portal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bloodlink.dashboard.dashboard;
import com.example.bloodlink.databinding.ActivityMainBinding;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Ensure textView5 retains its initial text
        binding.titleTextView.setText("BloodLink");

       binding.emailContainer.setHelperText("");
       binding.passwordContainer.setHelperText("");
        emailFocusListener();
        passwordFocusListener();
//        binding.textView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intend = new Intent(MainActivity.this, forgetPassword.class);
//                startActivity(intend);
//            }
//        });
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this, dashboard.class);
//                startActivity(intent);
//            }
//        });
    }


    private void emailFocusListener() {
        binding.emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                binding.emailContainer.setHelperText(""); // Clear error message initially
                String result = validEmail();
                if (result != null) {
                    binding.emailContainer.setHelperText(result);

                }
            }
        });
    }

    private String validEmail() {
        String emailText = binding.emailEditText.getText().toString().trim();
        if (emailText.isEmpty()) {
            return "Email cannot be empty";
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address";
        }
        return null; // Return null if email is valid
    }
    private void passwordFocusListener() {
        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.passwordContainer.setHelperText(""); // Clear error message initially
                String result = validPassword();
                if (result != null) {
                    binding.passwordContainer.setHelperText(result);

                }
            }
        });
    }

    private String validPassword() {
        String passwordText = binding.passwordEditText.getText().toString().trim();
      if(passwordText.length()<8){
          return "Minimum 8 Character Password";
      }
      if(!passwordText.matches(".*[A-Z].*")){
          return "Must Contain 1 Upper-case Character ";
      }
        if(!passwordText.matches(".*[a-z].*")){
            return "Must Contain 1 Lower-case Character ";
        }
        if(!passwordText.matches(".*[@#/$^&=+].*")){
            return "Must Contain 1 Special Character [@#/$^&=+] ";
        }
        return null; // Return null if email is valid
    }
}