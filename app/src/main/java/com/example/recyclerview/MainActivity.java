package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Calculator> calculatorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter adapter = new RVAdapter(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("qwerty", "onItemClick: ");
            }
        });
        rv.setAdapter(adapter);
        adapter.setItems(Arrays.asList(new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"), new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 2", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "1232435+433543+24*-3+5*-3")));
    }
}