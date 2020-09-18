package com.example.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter2.ViewHolder> {

    private static final String TAG = "NotesRecyclerAdapter";

    private ArrayList<Calculator> calculators = new ArrayList<>();
    private OnNoteListener mOnNoteListener;

    public RVAdapter2(ArrayList<Calculator> calculators, OnNoteListener onNoteListener) {
        this.calculators = calculators;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter2.ViewHolder holder, int position) {
        holder.bind(calculators.get(position));
    }

    @Override
    public int getItemCount() {
        return calculators.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView;
        private TextView contentTextView;

        public ViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            //timestamp = itemView.findViewById(R.id.note_timestamp);
            //title = itemView.findViewById(R.id.note_title);
            mOnNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        public void bind(Calculator calculator) {
            nameTextView.setText(calculator.name);
            contentTextView.setText(calculator.content);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}




