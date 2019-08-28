package com.ahmed.gamal.matchatak.ui.competition;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.SeasonsAdapter;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.viewmodels.CompetitionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CompetitionActivity extends AppCompatActivity implements SeasonsAdapter.OnSeasonClickListener {

    private CompetitionViewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.rv_seasons);
        viewModel= ViewModelProviders.of(this).get(CompetitionViewModel.class);
        if (getIntent() != null && getIntent().hasExtra("id")) {
            int id=getIntent().getIntExtra("id",0);
            viewModel.getCompetitionById(id).observe(this, competition -> setSeasons(competition));
        }
        FloatingActionButton addToFavorite = findViewById(R.id.fab);
        addToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setSeasons(Competition competition) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            SeasonsAdapter adapter=new SeasonsAdapter(this);
            recyclerView.setAdapter(adapter);
            adapter.setData(competition);
    }

    @Override
    public void onSeasonClicked(int seasonId) {
        Toast.makeText(this, ""+seasonId , Toast.LENGTH_SHORT).show();
    }
}
