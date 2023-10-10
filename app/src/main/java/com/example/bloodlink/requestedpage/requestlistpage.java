package com.example.bloodlink.requestedpage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodlink.R;

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
            bloodgroup=i.getStringExtra("bloodgroup");
            pints=i.getStringExtra("pints");
            location=i.getStringExtra("address");

        }

        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Ravi Khadka","45",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Sunil Bhatta","23",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Puspa Raj Joshi","28",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Suman Shah","35",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Prakash Joshi","45",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Bishal Khadaka","40",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Saroj Chy","42",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Roshan Kumar","38",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Hari Sharma","32",bloodgroup,pints,location));
        arrRequest.add(new requestlistModel(R.drawable.baseline_person_24,"Arjun Rana","35",bloodgroup,pints,location));



        RecyclerRequestAdapter adapter=new RecyclerRequestAdapter(this,arrRequest);
        recyclerView.setAdapter(adapter);

    }
}