package com.ahmed.gamal.matchatak.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.utils.DateUtil;

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.Holder> {
    private Competition competition;
    private OnSeasonClickListener clickListener;

    public SeasonsAdapter(OnSeasonClickListener listener) {
        competition = new Competition();
        this.clickListener = listener;
    }

    public void setData(Competition data) {
        competition = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.season_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return competition.getSeasons() == null ? 0 : competition.getSeasons().size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView competitionName, season;
        ConstraintLayout layout;

        Holder(@NonNull View itemView) {
            super(itemView);
            competitionName = itemView.findViewById(R.id.tv_name);
            season = itemView.findViewById(R.id.tv_season);
            layout = itemView.findViewById(R.id.list_item);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            competitionName.setText(competition.getName() + " (" + competition.getArea().getName() + ")");
            season.setText(DateUtil.seasonNum(competition.getSeasons().get(position).getStartDate(),
                    competition.getSeasons().get(position).getEndDate()));
            if (competition.getCurrentSeason() != null && competition.getCurrentSeason().getId() == competition.getSeasons().get(getAdapterPosition()).getId()) {
                layout.setBackgroundColor(Color.GREEN);
            }
        }

        @Override
        public void onClick(View view) {
            clickListener.onSeasonClicked(competition.getSeasons().get(getAdapterPosition()).getId());
        }
    }

    public interface OnSeasonClickListener {
        void onSeasonClicked(int seasonId);

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
}
