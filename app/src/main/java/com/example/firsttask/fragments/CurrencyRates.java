package com.example.firsttask.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.firsttask.MainActivity;
import com.example.firsttask.MyViewPagerAdapter;
import com.example.firsttask.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;


public class CurrencyRates extends Fragment {


    TextView conversionResult;



    TextInputEditText coversionAmountInputField;

    String rateURL;
    String APIkey="CUDJOz7iGPwQXHOQVJ8BSBIOQyxj5iX2";

    String from="";
    String to="";

    String[] countries = { "KWD", "AED", "BHD", "EUR", "GBP", "KRW", "OMR", "QAR", "SAR", "TRY", "USD"};

    AutoCompleteTextView autoCompleteTextFrom;
    ArrayAdapter<String> adapterItemsFrom;

    AutoCompleteTextView autoCompleteTextTo;
    ArrayAdapter<String> adapterItemsTo;

    Button btn;

    public CurrencyRates() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_currency_rates, container, false);
        coversionAmountInputField  = (TextInputEditText)view.findViewById(R.id.conversionAmount);
        autoCompleteTextFrom=view.findViewById(R.id.auto_complete_text_from);
        adapterItemsFrom=new ArrayAdapter<String>(getContext(),R.layout.list_item,countries);
        autoCompleteTextFrom.setAdapter(adapterItemsFrom);
        btn=view.findViewById(R.id.buttonConvert);
        autoCompleteTextFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected=parent.getItemAtPosition(position).toString();
                from=itemSelected;


            }
        });
        autoCompleteTextTo=view.findViewById(R.id.auto_complete_text_to);
        adapterItemsTo=new ArrayAdapter<String>(getContext(),R.layout.list_item,countries);
        autoCompleteTextTo.setAdapter(adapterItemsTo);
        autoCompleteTextTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelected=parent.getItemAtPosition(position).toString();
                to=itemSelected;


            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                convertRate(view);
            }
        });

        return  view;
    }

        public void convertRate(View view) {
        System.out.println("conversion button clicked");
        conversionResult =view.findViewById(R.id.conversionResult);

//        coversionAmountInputField  = view.findViewById(R.id.conversionAmount);
        System.out.println("value got from input field ....................."+coversionAmountInputField);
        String givenAmount = coversionAmountInputField.getText().toString();
            System.out.println("value got from input field ....................."+givenAmount);

//        DE89370400440532013000
        rateURL="https://api.apilayer.com/fixer/convert?to="+to+"&from="+from+"&amount="+givenAmount+"&apikey="+APIkey;
        JsonObjectRequest RATErequest= new JsonObjectRequest(Request.Method.GET, rateURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String conversionAmount = response.getString("result");
                    conversionResult.setText(conversionAmount);

                } catch (Exception error) {

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            Volley.newRequestQueue(getContext()).add(RATErequest);
//        }, new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        Volley.newRequestQueue(this).add(RATErequest);


        }

}


