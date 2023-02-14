package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    TextView ibanValidation;
    TextView rateConvertor;

    TextInputEditText ibanInputField;
    String ibanURL;
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
    public void checkIBAN(View view) {
        System.out.println("button clicked");
        ibanValidation =findViewById(R.id.ibanValidation);
        ibanInputField  = (TextInputEditText) findViewById(R.id.valueIBAN);
        String givenIBAN = ibanInputField.getText().toString();
//        DE89370400440532013000
        ibanURL="https://api.apilayer.com/bank_data/iban_validate?iban_number="+givenIBAN+"&apikey="+APIkey;
        JsonObjectRequest IBANrequest= new JsonObjectRequest(Request.Method.GET, ibanURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String IBANvalidtag= response.getString("valid");
                    ibanValidation.setText(IBANvalidtag);
                    System.out.println("buttonnn clicked"+IBANvalidtag);

                }
                catch(Exception error){

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(IBANrequest);
    }
}
