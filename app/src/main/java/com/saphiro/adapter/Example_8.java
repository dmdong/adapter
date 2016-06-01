package com.saphiro.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.RowId;
import java.util.ArrayList;
import java.util.List;

public class Example_8 extends AppCompatActivity implements View.OnClickListener {

    ListView lv8;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1122: {
                if (resultCode == 1122) {
                    Long random = SystemClock.currentThreadTimeMillis();
                    Bundle bundle = data.getExtras();
                    ContentValues newValue = new ContentValues();
                    newValue.put(COL_ENAME, bundle.getString("countryEn"));
                    newValue.put(COL_VNAME, bundle.getString("countryVi"));
                    newValue.put(COL_FLAG, random);

                    SQLiteDatabase dbInsert = OpenDB();
                    dbInsert.insert(TABLE_NAME, null, newValue);
                    List<CountryDB> countries = new ArrayList<>();
                    String[] Column = {COL_ID, COL_ENAME, COL_VNAME, COL_FLAG};
                    countries = LoadData(dbInsert, countries, Column);

                    CountryDBAdapter dbAdapter = new CountryDBAdapter(Example_8.this, R.layout.sqlite_layout2, countries);
                    lv8.setAdapter(dbAdapter);

                }
            }
            break;
            case 1123: {
                if (resultCode == 1123) {
                    Bundle bundle = data.getExtras();
                    ContentValues newValue = new ContentValues();
                    newValue.put(COL_ENAME, bundle.getString("countryUpdate"));
                    String toChange = COL_ENAME + "=? ";
                    String[] where = {bundle.getString("countryEn")};

                    SQLiteDatabase dbUpdate = OpenDB();
                    dbUpdate.update(TABLE_NAME, newValue, toChange, where);
                    List<CountryDB> countries = new ArrayList<>();
                    String[] Column = {COL_ID, COL_ENAME, COL_VNAME, COL_FLAG};
                    countries = LoadData(dbUpdate, countries, Column);

                    CountryDBAdapter dbAdapter = new CountryDBAdapter(Example_8.this, R.layout.sqlite_layout2, countries);
                    lv8.setAdapter(dbAdapter);

                }
            }
            break;
        }


    }

    @Override
    public void onClick(View v) {

        String[] Column = {COL_ID, COL_ENAME, COL_VNAME, COL_FLAG};
        List<CountryDB> countries = new ArrayList<>();

        if (v.getId() == R.id.btnLoad) {
            SQLiteDatabase sqlitedb = OpenDB();
            //Truy vấn
            countries = LoadData(sqlitedb, countries, Column);
            //Load data lên listview
            CountryDBAdapter dbAdapter = new CountryDBAdapter(Example_8.this, R.layout.sqlite_layout2, countries);
            lv8.setAdapter(dbAdapter);

        } else if (v.getId() == R.id.btnDel) {
            SQLiteDatabase dbDel = OpenDB();
            Cursor cursor = dbDel.query(TABLE_NAME, null, null, null, null, null, null);
            cursor.moveToLast();

            String lastRow = cursor.getString(cursor.getColumnIndex(COL_ENAME));
            dbDel.delete(TABLE_NAME, COL_ENAME + "='" + lastRow + "'", null);
            countries = LoadData(dbDel, countries, Column);
            CountryDBAdapter dbAdapter = new CountryDBAdapter(Example_8.this, R.layout.sqlite_layout2, countries);
            lv8.setAdapter(dbAdapter);

        } else if (v.getId() == R.id.btnUpdate) {
            Intent intent = new Intent(getApplicationContext(), InsertCountry.class);
            intent.putExtra("Update", true);
            startActivityForResult(intent, 1123);


        } else if (v.getId() == R.id.btnInsert) {
//            Long random = SystemClock.currentThreadTimeMillis();
//            ContentValues newValue = new ContentValues();
//            newValue.put(COL_ENAME, random);
//            newValue.put(COL_VNAME, random);
//            newValue.put(COL_FLAG, random);


            Intent intent = new Intent(getApplicationContext(), InsertCountry.class);
            intent.putExtra("Insert", true);
            startActivityForResult(intent, 1122);


        }
    }

    SQLiteDatabase OpenDB() {
        String path = getFilesDir().getAbsolutePath() + "/CountryDB2";
        File file = new File(path);
        if (!file.exists()) {
            AssetManager assetManager = getAssets();
            try {
                BufferedInputStream fis = new BufferedInputStream(assetManager.open("CountryDB2"));
                FileOutputStream fos = openFileOutput("CountryDB2", Context.MODE_PRIVATE);
                byte[] buffer = new byte[512];
                int length = 0;
                while ((length = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, length);
                }

                fis.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    ;

    List<CountryDB> LoadData(SQLiteDatabase database, List<CountryDB> countries, String[] Column) {

        Cursor cursor = database.query(TABLE_NAME, Column, null, null, null, null, COL_ID + " DESC");

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                countries = new ArrayList<>();
                do {
                    CountryDB country = new CountryDB();
                    country.setViName(cursor.getString(cursor.getColumnIndex(COL_VNAME)));
                    country.setEnName(cursor.getString(cursor.getColumnIndex(COL_ENAME)));
                    country.setFlag(cursor.getString(cursor.getColumnIndex(COL_FLAG)));

                    countries.add(country);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        database.close();
        return countries;
    }

    ;
}
