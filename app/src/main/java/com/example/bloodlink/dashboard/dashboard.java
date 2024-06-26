package com.example.bloodlink.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bloodlink.MainActivity;
import com.example.bloodlink.R;
import com.example.bloodlink.databinding.ActivityDashboardBinding;
import com.example.bloodlink.donorpage.donorPage;
import com.example.bloodlink.myprofile.myprofile;
import com.example.bloodlink.searchdonor.searchdonor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dashboard extends AppCompatActivity {
ActivityDashboardBinding binding;
    ImageButton notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try{
            Intent intent1 = getIntent();
            String Token = intent1.getStringExtra("Token");
            Log.d("Malware",Token);
            Demo(Token);
        }
        catch (Exception e){
            Log.e("MYAPP", "exception: " + e.getMessage());
        }

        notify = findViewById(R.id.notification);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this, donorPage.class);
                startActivity(i);
            }
        });

        ImageSlider imageSlider=binding.imageSlider;
        ArrayList<SlideModel>slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bl1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.b2, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);


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

               //startActivity(intent);

           }
       });

    }
    public void Demo( String Token){
        String url = "http://192.168.1.69:8085/api/v1/user/users";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, new JSONArray(),new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for( int i = 0; i<response.length();i++) {
                        JSONObject objectResponse = response.getJSONObject(i);
                        Toast.makeText(getApplicationContext(),objectResponse.getString("username"),Toast.LENGTH_LONG).show();
                        Log.d("Volleyresponse", objectResponse.getString("username"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("Error234",e.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("volleyError", error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();

                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer "+Token);

                return headers;
            }
        };

        requestQueue.add(jsonObjectRequest);

    }
}