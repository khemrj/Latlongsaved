package com.example.bloodlink.requestedpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;

import java.util.ArrayList;

public class requestlistpage extends AppCompatActivity {
    ArrayList<requestlistModel>arrRequest=new ArrayList<>();
    private String bloodgroup;
private  String pints;
private String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestlistpage);
        RecyclerView recyclerView=findViewById(R.id.recyclerrequestedlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent i=getIntent();
        if(i!=null){
            bloodgroup=i.getStringExtra("bg");
            pints=i.getStringExtra("p");
            location=i.getStringExtra("l");
        }

        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Puran Joshi","45",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Suman Shah","23",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Roshan Bhatta","28","AB-","1","Dhangadhi"));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Puran Joshi","35","AB-","1","Attariya"));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Puran Joshi","45","AB-","1","Attariya"));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Puran Joshi","45","AB-","1","Mihendranagar"));


        RecyclerRequestAdapter adapter=new RecyclerRequestAdapter(this,arrRequest);
        recyclerView.setAdapter(adapter);

    }
}