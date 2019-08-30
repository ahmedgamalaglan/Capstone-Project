package com.ahmed.gamal.matchatak.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        TextView season;
        FrameLayout frameLayout;

        Holder(@NonNull View itemView) {
            super(itemView);
            season = itemView.findViewById(R.id.tv_season);
            frameLayout = itemView.findViewById(R.id.fl_season_container);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            season.setText(DateUtil.seasonNum(competition.getSeasons().get(position).getStartDate()));
            int col = Color.rgb(255, 255 - ((position * 7) % 255), 0);
            frameLayout.setBackgroundColor(col);
            if (competition.getCurrentSeason() != null && competition.getCurrentSeason().getId() == competition.getSeasons().get(getAdapterPosition()).getId()) {
                frameLayout.setBackgroundColor(Color.GREEN);
            }
        }

        @Override
        public void onClick(View view) {
            clickListener.onSeasonClicked(competition.getId(), Integer.valueOf(DateUtil.seasonNum(competition.getSeasons().get(getAdapterPosition()).getStartDate())));
        }
    }

    public interface OnSeasonClickListener {
        void onSeasonClicked(int competitionId, int seasonYear);

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
