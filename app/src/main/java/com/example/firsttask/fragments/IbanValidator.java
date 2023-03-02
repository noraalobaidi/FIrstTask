package com.example.firsttask.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.firsttask.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;


public class IbanValidator extends Fragment {

    TextView ibanValidation;


    TextInputEditText ibanInputField;


    String ibanURL;

    String APIkey="CUDJOz7iGPwQXHOQVJ8BSBIOQyxj5iX2";


    Button btn;
    public IbanValidator() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_iban_validator, container, false);
        ibanInputField  = (TextInputEditText) view.findViewById(R.id.valueIBAN);
        btn=view.findViewById(R.id.buttonCheckIBAN);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkIBAN(view);
            }
        });
        return view;
    }

        public void checkIBAN(View view) {
        System.out.println("button clicked");
        ibanValidation =view.findViewById(R.id.ibanValidation);

        String givenIBAN = ibanInputField.getText().toString();
//        DE89370400440532013000
        ibanURL="https://api.apilayer.com/bank_data/iban_validate?iban_number="+givenIBAN+"&apikey="+APIkey;
        JsonObjectRequest IBANrequest= new JsonObjectRequest(Request.Method.GET, ibanURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String IBANvalidtag = response.getString("valid");
                    if (IBANvalidtag.equalsIgnoreCase("true")) {
                        ibanValidation.setText("Valid IBAN");
                    } else {
                        ibanValidation.setText("Invalid IBAN");
                    }

                    System.out.println("buttonnn clicked" + IBANvalidtag);

                } catch (Exception error) {

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            Volley.newRequestQueue(getContext()).add(IBANrequest);
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        Volley.newRequestQueue(this).add(IBANrequest);
        }
}