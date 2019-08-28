

package com.ahmed.gamal.matchatak.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.CompetitionsAdapter;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.ui.competition.CompetitionActivity;
import com.ahmed.gamal.matchatak.viewmodels.CompetitionsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompetitionsAdapter.OnCompetitionClickListener {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_competitions);
        CompetitionsViewModel viewModel = ViewModelProviders.of(this).get(CompetitionsViewModel.class);
        viewModel.getCompetitions().observe(this, this::setRecyclerView);

    }

    private void setRecyclerView(List<Competition> competitionsList) {
        CompetitionsAdapter adapter = new CompetitionsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter.setData(competitionsList);
    }

    @Override
    public void OnCompetitionClick(Competition competition) {
        Intent intent = new Intent(MainActivity.this, CompetitionActivity.class);
        intent.putExtra("id", competition.getId());
        startActivity(intent);
    }
}
