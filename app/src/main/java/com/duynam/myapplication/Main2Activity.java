package com.duynam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.duynam.myapplication.adapter.CountryAdapter;
import com.duynam.myapplication.model.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_signup;
    private Spinner spn_country;
    private List<Country> countryList;
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();

        countryList = new ArrayList<>();
        countryList.add(new Country(getResources().getString(R.string.eng), R.drawable.eng));
        countryList.add(new Country(getResources().getString(R.string.kr), R.drawable.kr));
        countryList.add(new Country(getResources().getString(R.string.hi), R.drawable.hi));

        adapter = new CountryAdapter(this, countryList);
        spn_country.setAdapter(adapter);
        spn_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    setLocale("en");
                }else if (position == 1){
                    setLocale("ko");
                    recreate();
                }else {
                    setLocale("hi");
                    recreate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });

    }

    private void setLocale(String cou){
        Locale locale = new Locale(cou);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    }

    private void initView(){
        tv_signup = findViewById(R.id.tv_signup);
        spn_country = findViewById(R.id.spn_country);
    }

}
