package com.saphiro.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Example_3 extends AppCompatActivity {

    ListView lv3;
    List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_3);

        lv3 = (ListView) findViewById(R.id.lv3);

        countries = new ArrayList<>();
        countries.add(new Country("Vietnam", "Việt Nam"));
        countries.add(new Country("Vietnam", "Việt Nam"));
        countries.add(new Country("Laos", "Lào"));
        countries.add(new Country("Japan", "Nhật Bản"));
        countries.add(new Country("USA", "Mỹ"));
        countries.add(new Country("Korea", "Hàn Quốc"));
        countries.add(new Country("China", "Trung Quốc"));
        countries.add(new Country("Mexico", "Mê hi cô"));
        countries.add(new Country("India", "Ấn Độ"));
        countries.add(new Country("Italia", "Ý"));
        countries.add(new Country("French", "Pháp"));
        countries.add(new Country("Taiwan", "Đài Loan"));
        countries.add(new Country("Thailand", "Thái Lan"));

        CountryAdapter countryAdapter = new CountryAdapter(this, countries, R.layout.item_layout_2);
        lv3.setAdapter(countryAdapter);
    }
}
