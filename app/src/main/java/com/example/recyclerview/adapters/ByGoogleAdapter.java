package com.example.recyclerview.adapters;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.CalculatorActivity;
import com.example.recyclerview.R;
import com.example.recyclerview.models.Calculator;

import java.util.ArrayList;
import java.util.Collection;

public class ByGoogleAdapter extends RecyclerView.Adapter<ByGoogleAdapter.CalcViewHolder> {

    private ArrayList<Calculator> calculatorList;
    Activity activity;

    public ByGoogleAdapter(ArrayList<Calculator> calculatorList, Activity activity) {
        this.calculatorList = calculatorList;
        this.activity = activity;
    }

    public void setItems(Collection<Calculator> calculators){
        calculatorList.addAll(calculators);
        notifyDataSetChanged(); //Дает адаптеру знать об изменении списка элементов и что надо перерисовать
    }

    public void clearItems(){
        calculatorList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CalcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CalcViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalcViewHolder holder, int position) {
        holder.bind(calculatorList.get(position));
    }

    @Override
    public int getItemCount() {
        return calculatorList.size();
    }

    class CalcViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView contentTextView;

        public CalcViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            contentTextView = itemView.findViewById(R.id.content);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("qwerty", "onClick: новый"  + getAdapterPosition());
                    Intent intent = new Intent(view.getContext(), CalculatorActivity.class);
                    view.getContext().startActivity(intent);
                    activity.overridePendingTransition(R.anim.animate_swipe_left_enter, R.anim.animate_swipe_left_exit);
                }
            });
        }

        public void bind(Calculator calculator) {
            nameTextView.setText(calculator.getName());
            contentTextView.setText(calculator.getContent());
        }


    }
}
