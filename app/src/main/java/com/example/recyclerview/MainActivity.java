package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RVAdapter.OnCalculatorClickListener {

    ArrayList<Calculator> calculatorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        initRV();

    }

    @Override
    public void onCalculatorClick(int position) {

        Log.d("qwerty", "onCalculatorClick: " + position);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    private void initRV(){
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter adapter = new RVAdapter(calculatorList, this);
        rv.setAdapter(adapter);
        adapter.setItems(Arrays.asList(new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"), new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 2", "1233434343425544535532435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "1232435+433543+24*-3+5*-3")));
        adapter.notifyDataSetChanged();
    }
}