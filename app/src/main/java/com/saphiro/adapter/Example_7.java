package com.saphiro.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Example_7 extends AppCompatActivity {

    ListView lv7;
    Button btnLoad;

    public static final String TABLE_NAME = "country";
    public static final String COL_ID = "_id";
    public static final String COL_ENAME = "enName";
    public static final String COL_VNAME = "viName";
    public static final String COL_FLAG = "flag";

    public static final String COL_POPULATION = "population";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_7);

        lv7 = (ListView) findViewById(R.id.lv7);
        btnLoad = (Button) findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Load File
                String path = getFilesDir().getAbsolutePath() + "/CountryDB2";
                Log.d("PATH", path);

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
                //Mở file
                SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(path, null,
                        SQLiteDatabase.OPEN_READONLY);


                String[] Column = {COL_ENAME, COL_VNAME, COL_FLAG};

                //Truy vấn
                Cursor cursor = sqLiteDatabase.query(TABLE_NAME, Column, null, null, null, null, COL_ENAME + " ASC");
                List<CountryDB> countries = null;
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
                sqLiteDatabase.close();

                //Load data lên listview
                CountryDBAdapter dbAdapter = new CountryDBAdapter(Example_7.this, R.layout.sqlite_layout, countries);
                lv7.setAdapter(dbAdapter);
            }
        });


    }


}
