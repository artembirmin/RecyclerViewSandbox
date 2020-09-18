package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CalcViewHolder> {

    private List<Calculator> calculatorList = new ArrayList<>();
    private final AdapterView.OnItemClickListener onItemClickListener;

    public RVAdapter(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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
        return new CalcViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalcViewHolder holder, int position) {
        holder.bind(calculatorList.get(position));
    }

    @Override
    public int getItemCount() {
        return calculatorList.size();
    }

    static class CalcViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView;
        private TextView contentTextView;
        private Calculator calculator;
        private final AdapterView.OnItemClickListener onItemClickListener;

        public CalcViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener onItemClickListener) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name);
            contentTextView = (TextView) itemView.findViewById(R.id.content);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        public void bind(Calculator calculator) {
            nameTextView.setText(calculator.name);
            contentTextView.setText(calculator.content);
        }

        @Override
        public void onClick(View view) {
            //Здесь основные действия
           // Intent intent = new Intent(view.getContext(), MainActivity2.class);
           // view.getContext().startActivity(intent);
            Log.e("qwerty", "onClick: ");
        }
    }
}
