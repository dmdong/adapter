package com.saphiro.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example_8 extends AppCompatActivity implements View.OnClickListener {

    ListView lv7;
    Button btnLoad;
    Button btnInsert;
    Button btnDelete;
    Button btnUpdate;

    public static final String TABLE_NAME = "country";
    public static final String COL_ID = "_id";
    public static final String COL_ENAME = "enName";
    public static final String COL_VNAME = "viName";
    public static final String COL_FLAG = "flag";

    public static final String COL_POPULATION = "population";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_8);

        lv8 = (ListView) findViewById(R.id.lv8);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnDelete = (Button) findViewById(R.id.btnDel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnLoad.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoad) {

        } else if (v.getId() == R.id.btnDel) {

        } else if (v.getId() == R.id.btnUpdate) {

        } else if (v.getId() == R.id.btnInsert) {

        }
    }
}
