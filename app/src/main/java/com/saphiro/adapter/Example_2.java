package com.saphiro.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Example_2 extends AppCompatActivity {

    ListView lv2;
    List<String> countries2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_2);

        lv2 = (ListView) findViewById(R.id.lv2);
        countries2 = new ArrayList<>();
        countries2.add("Lào");
        countries2.add("Miến điện");
        countries2.add("Brazil");
        countries2.add("Hà Lan");
        countries2.add("Úc");
        countries2.add("Anh");
        countries2.add("Hy Lạp");
        countries2.add("Đan Mạch");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");
        countries2.add("Thổ Nhĩ Kỳ");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_layout, countries2);
        lv2.setAdapter(adapter);

    }
}
