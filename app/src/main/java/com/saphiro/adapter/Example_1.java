package com.saphiro.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Example_1 extends AppCompatActivity {

    ListView lv;
    List<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_1);

        lv = (ListView) findViewById(R.id.lv1);
        countries = new ArrayList<>();
        countries.add("Việt Nam");
        countries.add("Mỹ");
        countries.add("Pháp");
        countries.add("Nhật");
        countries.add("Hàn");
        countries.add("Thái");
        countries.add("Cam");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        lv.setAdapter(adapter);

    }

}
