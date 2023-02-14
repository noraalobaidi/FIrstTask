package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView data;
    String url;
    TextView rateConvertor;
    String rateURL;
    String APIkey="CUDJOz7iGPwQXHOQVJ8BSBIOQyxj5iX2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rateConvertor =findViewById(R.id.rateConvertor);

        rateURL="https://api.apilayer.com/fixer/convert?to=KWD&from=USD&amount=10&apikey="+APIkey;

        JsonObjectRequest RATErequest= new JsonObjectRequest(Request.Method.GET,rateURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String conversionAmount= response.getString("result");
                    rateConvertor.setText(conversionAmount);

                }
                catch(Exception error){

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(RATErequest);


    }
}
