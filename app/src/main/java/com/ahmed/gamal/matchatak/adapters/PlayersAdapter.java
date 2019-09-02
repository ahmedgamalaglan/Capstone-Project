package com.ahmed.gamal.matchatak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Person;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder> {

    private List<Person> mValues;

    public PlayersAdapter() {
    }

    public void setData(List<Person> personList) {
        mValues = personList;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.playerName.setText(mValues.get(position).getName());
        String num = String.valueOf(mValues.get(position).getShirtNumber());
        if (num.equalsIgnoreCase("0"))
            holder.playerNum.setText("");
        holder.playerNum.setText(num);

    }

    @Override
    public int getItemCount() {
        return mValues == null ? 0 : mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView playerNum, playerName;

        ViewHolder(View view) {
            super(view);
            playerName = view.findViewById(R.id.player_name);
            playerNum = view.findViewById(R.id.player_number);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
