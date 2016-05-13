package com.saphiro.adapter;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Example_6 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv6;
    List<String> files;
    TextView path;
    String filepath;
    File filedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_6);

        lv6 = (ListView) findViewById(R.id.lv6);
        lv6.setOnItemClickListener(this);
        path = (TextView) findViewById(R.id.path);
        filepath = Environment.getExternalStorageDirectory().getPath();

        getFolder(filepath);
    }


//        if (filedir.isDirectory()){
//            File[] filedirs = filedir.listFiles();
//            for (int i = 0; i<filedirs.length; i++){
//                files.add(filedirs[i].getName());
//            }
//        }

//        String[] dir = filedir.list();
//        for (int i=0; i<dir.length; i++){
//            files.add(dir[i]);
//        }


    public void getFolder(String filepath) {

        path.setText(filepath);
        files = new ArrayList<>();
        files.add("../");


        filedir = new File(filepath);
        for (String e : filedir.list()) {
            if (filedir.isDirectory() && !filedir.isHidden() && filedir.canRead()) {
                files.add(e);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, files);
        lv6.setAdapter(adapter);


    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        File file = new File(files.get(position));
//        if (file.isDirectory() && !file.isHidden() && file.canRead()) {
//            getFolder(file.getAbsolutePath());}
//    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        String itemclicked;
        File file = new File(filedir.getPath());


        if (files.get(position).equals("../")) {
            itemclicked = file.getParent();
        } else {
            itemclicked = filedir + "/" + files.get(position);
        }
        // String itemclicked = filepath+"/Music";
        Toast.makeText(Example_6.this, itemclicked, Toast.LENGTH_SHORT).show();


//        File file = new File(files.get(position));
//        if (file.isDirectory() && !file.isHidden() && file.canRead()) {
//            getFolder(file.getAbsolutePath());}

        if (filedir.isDirectory()) {
            getFolder(itemclicked);
        } else {

        }
    }
}
