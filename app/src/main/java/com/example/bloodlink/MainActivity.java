package com.example.bloodlink;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bloodlink.dashboard.dashboard;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private String Token;
    private EditText editText;
    private EditText editText2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.updateButton);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MainActivity.this, forgetPassword.class);
                startActivity(intend);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    createNewUser();
                }
                catch (Exception e){
                    Log.d("createUserException", e.toString());
                }

            }
        });
    }
    private  void createNewUser() {

        final String[] Token = new String[1];

        String url = R.string.url"/api/v1/user/signup";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JSONObject jsonRequest = new JSONObject();
        try {
            jsonRequest.put("username", Long.parseLong(editText.getText().toString()));
            jsonRequest.put("password", editText2.getText().toString());
        } catch (JSONException e) {
            editText.setText(e.toString());
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonRequest,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Token[0] = response.getString("accessToken");
                    Intent intent=new Intent(MainActivity.this, dashboard.class);
                    Log.d("mainToken","hello"+ Token[0]);  // This Token has null value but why??
                    intent.putExtra("Token", Token[0]);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("volleyError", error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);



    }




}