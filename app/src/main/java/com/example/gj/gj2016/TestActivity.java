package com.example.gj.gj2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class TestActivity extends AppCompatActivity {
    ViewFlipper flipper;
    float x;
    int curIdx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getMatchInformation getter = new getMatchInformation();
        getter.parseData("A", "B");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        curIdx = 0;
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        flipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction())
                    {
                        case MotionEvent.ACTION_DOWN :

                           x = event.getX();
                           break;

                       case MotionEvent.ACTION_UP:
                           if(x+5 > event.getX() && x-5 < event.getX())
                           {
                               if(curIdx == 2) {
                                   Intent intent = new Intent(TestActivity.this, TeamActivity.class);
                                   startActivity(intent);
                               }
                               break;
                           }
                           if(x <= event.getX()) {
                               flipper.showPrevious();
                               curIdx--;
                               if(curIdx <0) curIdx = 2;
                           }
                           else if(x > event.getX()) {
                               flipper.showNext();
                               curIdx++;
                               if(curIdx >2) curIdx = 0;
                           }
                           break;

                   }
                   return true;
               }});
    }
}