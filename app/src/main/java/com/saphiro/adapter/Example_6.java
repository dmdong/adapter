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
    List<String> explorer;
    TextView path;
    File filedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_6);

        lv6 = (ListView) findViewById(R.id.lv6);
        if (lv6 != null) {
            lv6.setOnItemClickListener(this);
        }
        path = (TextView) findViewById(R.id.path);
        String root = Environment.getExternalStorageDirectory().getPath();
        getFolder(root);
    }

    public void getFolder(String filepath) {
        path.setText(filepath);
        explorer = new ArrayList<>();
        explorer.add("../");

        filedir = new File(filepath);
        //        for (String e : filedir.list()) {
//            File toAdd = new File(e);
//            if ((toAdd.isDirectory() || toAdd.isFile()) && !toAdd.isHidden() && toAdd.canRead()) {
//                explorer.add(e);
//            }
//        }
        for (String e : filedir.list()) {
            explorer.add(e);
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
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, explorer);
        lv6.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        String itemclicked;
        if (explorer.get(position).equals("../")) {
            itemclicked = filedir.getParent();
        } else {
            itemclicked = filedir + "/" + explorer.get(position);
        }

        Toast.makeText(Example_6.this, itemclicked, Toast.LENGTH_SHORT).show();
        File clicked = new File(itemclicked);
        if (clicked.isDirectory()) {
            if (clicked.getParentFile() != null) {
                getFolder(itemclicked);
            } else view.setEnabled(false);
        } else view.setEnabled(false);

//        File file = new File(files.get(position));
//        if (file.isDirectory() && !file.isHidden() && file.canRead()) {
//            getFolder(file.getAbsolutePath());}
    }
}
