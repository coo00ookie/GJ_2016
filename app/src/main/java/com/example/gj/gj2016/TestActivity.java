package com.example.gj.gj2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getMatchInformation getter = new getMatchInformation();
        getter.parseData("A", "B");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //sArOdiN
        //가
    }
}
