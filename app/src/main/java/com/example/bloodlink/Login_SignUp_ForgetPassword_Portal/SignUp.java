package com.example.bloodlink.Login_SignUp_ForgetPassword_Portal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.example.bloodlink.R;
import com.example.bloodlink.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.signUpTxt.setText("Sign Up");
        emailFocusListener();
        passwordFocusListener();
        conformPasswordFocusListener();
        phoneFocusListener();

    }
    //----------------------------------frontend validation--------------------------------
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


                String result = validEmail();
                if (result != null) {
                    binding.emailContainer.setHelperText(result);

                } else {
                    binding.emailContainer.setHelperText("");
                    // Clear error text if email is valid
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
                String result = validPassword();
                if (result != null) {
                    binding.passwordContainer.setHelperText(result);

                } else {
                    binding.passwordContainer.setHelperText("");
                    // Clear error text if email is valid
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
    private void conformPasswordFocusListener() {
        binding.conformPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String result = validconformPassword();
                if (result != null) {
                    binding.conformPasswordContainer.setHelperText(result);

                } else {
                    binding.conformPasswordContainer.setHelperText("");
                    // Clear error text if email is valid
                }
            }
        });
    }

    private String validconformPassword() {
        String getPasswordText=binding.passwordEditText.getText().toString().trim();
        String conformPasswordText = binding.conformPasswordEditText.getText().toString().trim();
        if(conformPasswordText.length()<8){
            return "Minimum 8 Character Password";
        }
        if(!conformPasswordText.matches(".*[A-Z].*")){
            return "Must Contain 1 Upper-case Character ";
        }
        if(!conformPasswordText.matches(".*[a-z].*")){
            return "Must Contain 1 Lower-case Character ";
        }
        if(!conformPasswordText.matches(".*[@#/$^&=+].*")){
            return "Must Contain 1 Special Character [@#/$^&=+] ";
        }
        if(!getPasswordText.equals(conformPasswordText)){
            return "Password Doesnot match ";
        }
        return null; // Return null if email is valid
    }
    private void phoneFocusListener() {
        binding.phoneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String result = validPhoneNumber();
                if (result != null) {
                    binding.phoneContainer.setHelperText(result);

                } else {
                    binding.phoneContainer.setHelperText("");
                    // Clear error text if email is valid
                }
            }
        });

    }

    private String validPhoneNumber() {
        String phoneText = binding.phoneEditText.getText().toString().trim();
        if (phoneText.length() != 10) {
            return "Minimum 10 number";
        }
        if (!phoneText.matches(".*[0-9].*")) {
            return "Must be all Digit";
        }

        return null; // Return null if email is valid
    }
    //----------------------------------------end validation-------------------------------
}