

package com.ahmed.gamal.matchatak.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.CompetitionsAdapter;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.ui.competition.CompetitionActivity;
import com.ahmed.gamal.matchatak.viewmodels.CompetitionsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompetitionsAdapter.OnCompetitionClickListener {


    private RecyclerView recyclerView;
    private View progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_competitions);
        progressbar = findViewById(R.id.progress_bar);
        CompetitionsViewModel viewModel = ViewModelProviders.of(this).get(CompetitionsViewModel.class);
        viewModel.getCompetitions().observe(this, competitions -> {
            setRecyclerView(competitions);
            progressbar.setVisibility(View.INVISIBLE);

        });

    }

    private void setRecyclerView(List<Competition> competitionsList) {
        CompetitionsAdapter adapter = new CompetitionsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        adapter.setData(competitionsList);
    }

    @Override
    public void OnCompetitionClick(Competition competition) {
        Intent intent = new Intent(MainActivity.this, CompetitionActivity.class);
        intent.putExtra("id", competition.getId());
        intent.putExtra("name", competition.getName());
        startActivity(intent);
    }
}
