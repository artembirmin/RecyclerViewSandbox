package com.example.calculatorslist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.r0adkll.slidr.Slidr;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("qwerty", "onCreate: Main2");
        setContentView(R.layout.activity_calculator);
        Slidr.attach(this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.animate_swipe_right_enter, R.anim.animate_swipe_right_exit);
    }
}