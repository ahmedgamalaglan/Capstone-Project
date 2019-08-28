package com.ahmed.gamal.matchatak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.model.Competition;

import java.util.ArrayList;
import java.util.List;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.MyHolder> {

    private List<Competition> competitions;
    private OnCompetitionClickListener clickListener;

    public CompetitionsAdapter(OnCompetitionClickListener listener) {
        competitions = new ArrayList<>();
        clickListener = listener;
    }

    public void setData(List<Competition> competitions) {
        this.competitions = competitions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return competitions == null ? 0 : competitions.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView, textView2;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            textView2 = itemView.findViewById(android.R.id.text2);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            textView.setText(competitions.get(position).getName());
            textView2.setText(competitions.get(position).getArea().getName());
        }

        @Override
        public void onClick(View view) {
            clickListener.OnCompetitionClick(competitions.get(getAdapterPosition()));
        }
    }

    public interface OnCompetitionClickListener {
        void OnCompetitionClick(Competition competition);
    }
}
