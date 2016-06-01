package com.saphiro.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertCountry extends AppCompatActivity {

    EditText edtCountryEn;
    EditText edtCountryVi;
    Button btnSubmit;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_country);
        edtCountryEn = (EditText) findViewById(R.id.edtCountryEn);
        edtCountryVi = (EditText) findViewById(R.id.edtCountryVi);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        final Intent intent = getIntent();
        if (intent.getBooleanExtra("Update", false)) {
            btnUpdate.setVisibility(View.VISIBLE);
            edtCountryEn.setHint("Tên tiếng Anh cần đổi");
            edtCountryVi.setHint("tên mới");
        } else if (intent.getBooleanExtra("Insert", false)) {
            btnSubmit.setVisibility(View.VISIBLE);
        }


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putString("countryEn", edtCountryEn.getText().toString());
                bundle.putString("countryVi", edtCountryVi.getText().toString());
                intent.putExtras(bundle);
                setResult(1122, intent);
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                if (!edtCountryEn.getText().equals("") && !edtCountryVi.getText().equals("")) {
                    bundle.putString("countryEn", edtCountryEn.getText().toString());
                    bundle.putString("countryUpdate", edtCountryVi.getText().toString());
                }
                if (!bundle.isEmpty()) {
                    intent.putExtras(bundle);
                    setResult(1123, intent);
                    finish();
                }


            }
        });


    }
}
