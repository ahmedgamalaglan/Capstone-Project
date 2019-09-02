package com.ahmed.gamal.matchatak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Team;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsHolder> {


    private List<Team> teams;
    private OnTeamClickListener onTeamClickListener;
    public void setData(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }

    public TeamsAdapter(OnTeamClickListener onTeamClickListener) {
        this.onTeamClickListener = onTeamClickListener;
    }

    @NonNull
    @Override
    public TeamsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_row, parent, false);
        return new TeamsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return teams == null ? 0 : teams.size();
    }

    class TeamsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView addToFav;
        TextView name, year, mobile, website;

         TeamsHolder(@NonNull View itemView) {
            super(itemView);
            addToFav = itemView.findViewById(R.id.iv_add_to_fav);
            name = itemView.findViewById(R.id.tv_name);
            year = itemView.findViewById(R.id.tv_founded);
            mobile = itemView.findViewById(R.id.tv_mobile);
            website = itemView.findViewById(R.id.tv_website);
            itemView.setOnClickListener(this);
        }

         void bind(int position) {
            Team team = teams.get(position);
            name.setText(team.getName());
            year.setText(String.valueOf(team.getFounded()));
            mobile.setText(team.getPhone());
            website.setText(team.getWebsite());
            addToFav.setOnClickListener(view -> {});
        }

        @Override
        public void onClick(View view) {
            onTeamClickListener.onTeamClick(teams.get(getAdapterPosition()).getId());
        }
    }

    public interface OnTeamClickListener{
        void onTeamClick(int teamId);
    }
}
