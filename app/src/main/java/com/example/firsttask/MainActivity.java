package com.example.firsttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    TextView ibanValidation;
    TextView conversionResult;

    TextInputEditText ibanInputField;

    TextInputEditText coversionAmountInputField;
    String ibanURL;
    String rateURL;
    String APIkey="CUDJOz7iGPwQXHOQVJ8BSBIOQyxj5iX2";

    String from="";
    String to="";

    String[] countries = { "KWD", "AED", "BHD", "EUR", "GBP", "KRW", "OMR", "QAR", "SAR", "TRY", "USD"};

    AutoCompleteTextView autoCompleteTextFrom;
    ArrayAdapter<String> adapterItemsFrom;

    AutoCompleteTextView autoCompleteTextTo;
    ArrayAdapter<String> adapterItemsTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.view_pager);
        myViewPagerAdapter= new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
//        conversionResult =findViewById(R.id.rateConvertor);

//        autoCompleteTextFrom=findViewById(R.id.auto_complete_text_from);
//        adapterItemsFrom=new ArrayAdapter<String>(this,R.layout.list_item,countries);
//        autoCompleteTextFrom.setAdapter(adapterItemsFrom);
//        autoCompleteTextFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String itemSelected=parent.getItemAtPosition(position).toString();
//                from=itemSelected;
//
//
//            }
//        });
//        autoCompleteTextTo=findViewById(R.id.auto_complete_text_to);
//        adapterItemsTo=new ArrayAdapter<String>(this,R.layout.list_item,countries);
//        autoCompleteTextTo.setAdapter(adapterItemsTo);
//        autoCompleteTextTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String itemSelected=parent.getItemAtPosition(position).toString();
//                to=itemSelected;
//
//
//            }
//        });
    }
//    public void checkIBAN(View view) {
//        System.out.println("button clicked");
//        ibanValidation =findViewById(R.id.ibanValidation);
//        ibanInputField  = (TextInputEditText) findViewById(R.id.valueIBAN);
//        String givenIBAN = ibanInputField.getText().toString();
//        DE89370400440532013000
//        ibanURL="https://api.apilayer.com/bank_data/iban_validate?iban_number="+givenIBAN+"&apikey="+APIkey;
//        JsonObjectRequest IBANrequest= new JsonObjectRequest(Request.Method.GET, ibanURL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try{
//                    String IBANvalidtag= response.getString("valid");
//                    if(IBANvalidtag.equalsIgnoreCase("true"))
//                    {
//                        ibanValidation.setText("Valid IBAN");
//                    }
//                    else
//                    {
//                        ibanValidation.setText("Invalid IBAN");
//                    }
//
//                    System.out.println("buttonnn clicked"+IBANvalidtag);
//
//                }
//                catch(Exception error){
//
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        Volley.newRequestQueue(this).add(IBANrequest);
//    }

//    public void convertRate(View view) {
//        System.out.println("conversion button clicked");
//        conversionResult =findViewById(R.id.conversionResult);
//
//        coversionAmountInputField  = (TextInputEditText) findViewById(R.id.conversionAmount);
//        String givenAmount = coversionAmountInputField.getText().toString();
//
////        DE89370400440532013000
//        rateURL="https://api.apilayer.com/fixer/convert?to="+to+"&from="+from+"&amount="+givenAmount+"&apikey="+APIkey;
//        JsonObjectRequest RATErequest= new JsonObjectRequest(Request.Method.GET,rateURL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try{
//                    String conversionAmount= response.getString("result");
//                    conversionResult.setText(conversionAmount);
//
//                }
//                catch(Exception error){
//
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        Volley.newRequestQueue(this).add(RATErequest);
//
//
//    }

}
