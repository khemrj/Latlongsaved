package com.example.bloodlink.donorpage;

import android.widget.ImageButton;

public class DonorModel {
    String acceptButtonText;

    int img;
    boolean acceptButtonVisible; //yo ta visible grna lagi ho
    String name ,bloodgroup,location , pints, age,imageButton;
    public DonorModel(int img, String name, String age, String bloodgroup,String pints ,String location) {
        // Initialize other properties as before
        this.img = img;
        this.name = name;
        this.age = age;
        this.bloodgroup=bloodgroup;
        this.pints=pints;
        this.location=location;
       // this.acceptButtonVisible = true;// Set the button initially visible yo t button visible garna lagi ho but hamilai button cahiyo
// Initialize other properties as before
        this.acceptButtonText = "Accept"; // Initial button text

    }
    //yo hamro visibility ko lagi  ho
//    public boolean isAcceptButtonVisible() {
//        return acceptButtonVisible;
//    }
//    public void setAcceptButtonVisible(boolean acceptButtonVisible) {
//        this.acceptButtonVisible = acceptButtonVisible;
//    }

    public String getAcceptButtonText() {
        return acceptButtonText;
    }


    public void setAcceptButtonText(String acceptButtonText) {
        this.acceptButtonText = acceptButtonText;
    }
}


