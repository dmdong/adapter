package com.saphiro.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button example1, example2, example3, example4, example5, example6, example7, example8;
    //View.OnClickListener view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        example1 = (Button) findViewById(R.id.ex1);
        example2 = (Button) findViewById(R.id.ex2);
        example3 = (Button) findViewById(R.id.ex3);
        example4 = (Button) findViewById(R.id.ex4);
        example5 = (Button) findViewById(R.id.ex5);
        example6 = (Button) findViewById(R.id.ex6);
        example7 = (Button) findViewById(R.id.ex7);
        example8 = (Button) findViewById(R.id.ex8);
        //example1 = new Button(this);
        example1.setOnClickListener(this);
        example2.setOnClickListener(this);
        example3.setOnClickListener(this);
        example4.setOnClickListener(this);
        example5.setOnClickListener(this);
        example6.setOnClickListener(this);
        example7.setOnClickListener(this);
        example8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ex1:
                Intent intent = new Intent(getApplicationContext(), Example_1.class);
                startActivity(intent);
                break;
            case R.id.ex2:
                Intent intent1 = new Intent(getApplicationContext(), Example_2.class);
                startActivity(intent1);
                break;
            case R.id.ex3:
                Intent intent2 = new Intent(getApplicationContext(), Example_3.class);
                startActivity(intent2);
                break;

            case R.id.ex4:
                Intent intent3 = new Intent(getApplicationContext(), Example_4.class);
                startActivity(intent3);
                break;

            case R.id.ex5:
                Intent intent4 = new Intent(getApplicationContext(), Example_5.class);
                startActivity(intent4);
                break;

            case R.id.ex6:
                Intent intent5 = new Intent(getApplicationContext(), Example_6.class);
                startActivity(intent5);
                break;

            case R.id.ex7:
                Intent intent7 = new Intent(this, Example_7.class);
                startActivity(intent7);
                break;
            case R.id.ex8:
                Intent intent8 = new Intent(this, Example_8.class);
                startActivity(intent8);
                break;
        }


    }
}
