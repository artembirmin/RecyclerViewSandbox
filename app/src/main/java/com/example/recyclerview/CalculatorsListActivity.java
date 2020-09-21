package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.recyclerview.adapters.NoNameAdapter;
import com.example.recyclerview.adapters.ByGoogleAdapter;
import com.example.recyclerview.models.Calculator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorsListActivity extends AppCompatActivity implements NoNameAdapter.OnCalculatorClickListener {

    ArrayList<Calculator> calculatorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_list);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);
        initRVWithByGoogleAdapter();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CalculatorsListActivity.this, "Fab fab fab", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCalculatorClick(int position) {
        Log.d("qwerty", "onCalculatorClick: " + position);
        overridePendingTransition(R.anim.animate_swipe_left_enter, R.anim.animate_swipe_left_exit);
    }

    private void initRVWithByGoogleAdapter(){
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ByGoogleAdapter adapter = new ByGoogleAdapter(calculatorList, CalculatorsListActivity.this);
        rv.setAdapter(adapter);
        adapter.setItems(Arrays.asList(new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"), new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 2", "1233434343425544535532435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3")));
        adapter.notifyDataSetChanged();
    }

    private void initRVWithNoNameAdapter(){
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        NoNameAdapter adapter = new NoNameAdapter(calculatorList, this);
        rv.setAdapter(adapter);
        adapter.setItems(Arrays.asList(new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"), new Calculator("Калькулятор 1", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 2", "1233434343425544535532435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "1232435+433543+24*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3"),
                new Calculator("Калькулятор 3", "*-3+5*-3")));
        adapter.notifyDataSetChanged();
    }
}