package com.saphiro.adapter;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class Example_5 extends AppCompatActivity {

    ListView lv5;
    List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_5);

        lv5 = (ListView) findViewById(R.id.lv5);

        countries = new ArrayList<>();
        countries.add(new Country("Vietnam", "Việt Nam", R.drawable.flag_vi));
        countries.add(new Country("Vietnam", "Việt Nam", R.drawable.flag_vi));
        countries.add(new Country("Laos", "Lào", R.drawable.flag_fr));
        countries.add(new Country("Japan", "Nhật Bản", R.drawable.flag_jp));
        countries.add(new Country("USA", "Mỹ", R.drawable.flag_us));
        countries.add(new Country("Korea", "Hàn Quốc", R.drawable.flag_us));
        countries.add(new Country("China", "Trung Quốc", R.drawable.flag_th));
        countries.add(new Country("Mexico", "Mê hi cô", R.drawable.flag_in));
        countries.add(new Country("India", "Ấn Độ", R.drawable.flag_in));
        countries.add(new Country("Italia", "Ý", R.drawable.flag_in));
        countries.add(new Country("French", "Pháp", R.drawable.flag_fr));
        countries.add(new Country("Taiwan", "Đài Loan", R.drawable.flag_pt));
        countries.add(new Country("Thailand", "Thái Lan", R.drawable.flag_th));

        CountryAdapter3 adapter3 = new CountryAdapter3(this, countries, R.layout.item_layout_3);
        lv5.setAdapter(adapter3);


    }


}
