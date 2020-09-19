package com.example.recyclerview;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("qwerty", "onCreate: Main2");
        setContentView(R.layout.activity_calculator);

       SlidrInterface slidr = Slidr.attach(this);
       //slidr.unlock();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.animate_swipe_right_enter, R.anim.animate_swipe_right_exit);      //  overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}