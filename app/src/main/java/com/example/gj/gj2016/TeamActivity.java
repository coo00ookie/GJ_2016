package com.example.gj.gj2016;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


        ImageView img_bck = (ImageView)findViewById(R.id.back);
        img_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamActivity.this, TestActivity.class);
                finish();
            }
        });

        ImageView samsungimg = (ImageView)findViewById(R.id.samsung);
        samsungimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });


        ImageView lotteimg = (ImageView)findViewById(R.id.lotte);
        lotteimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( TeamActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
