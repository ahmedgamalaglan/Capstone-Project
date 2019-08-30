package com.ahmed.gamal.matchatak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Match;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.Holder> {

    private List<Match> matches;

    public MatchesAdapter() {
    }

    public void setData(List<Match> data) {
        this.matches = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.match_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return matches == null ? 0 : matches.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView homeTeam, awayTeam, matchDate;


        Holder(@NonNull View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.tv_home_team);
            awayTeam = itemView.findViewById(R.id.tv_away_team);
            matchDate = itemView.findViewById(R.id.tv_match_date);
        }

        void bind(int position) {
            Match match = matches.get(position);
            homeTeam.setText(match.getHomeTeam().getName());
            awayTeam.setText(match.getAwayTeam().getName());
            matchDate.setText(match.getUtcDate());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
