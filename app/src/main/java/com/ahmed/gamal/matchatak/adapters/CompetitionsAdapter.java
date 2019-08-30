package com.ahmed.gamal.matchatak.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.Const;
import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Competition;
import com.squareup.picasso.Picasso;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compertition_list_row, parent, false);
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
        TextView name, area;
        ImageView image;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            image = itemView.findViewById(R.id.iv_image);
            area = itemView.findViewById(R.id.tv_area_name);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            Picasso.get().load(Const.getImageUrl(competitions.get(position).getId())).into(image);
            name.setText(competitions.get(position).getName());
            area.setText(competitions.get(position).getArea().getName());
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
