

package com.ahmed.gamal.matchatak.ui.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.CompetitionsAdapter;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.ui.activities.competition.CompetitionActivity;
import com.ahmed.gamal.matchatak.viewmodels.CompetitionsViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CompetitionsAdapter.OnCompetitionClickListener {


    private RecyclerView recyclerView;
    private View progressbar;
    private CompetitionsViewModel viewModel;
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        recyclerView = findViewById(R.id.rv_competitions);
        progressbar = findViewById(R.id.progress_bar);
        viewModel = ViewModelProviders.of(this).get(CompetitionsViewModel.class);
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
    public void addToFavorites(Competition competition) {
        viewModel.addCompetitionToDatabase(competition);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, competition.getName());
        firebaseAnalytics.logEvent("competitions", bundle);
        Toast.makeText(this, "This Competition Was Marked As Favorite", Toast.LENGTH_LONG).show();

    }

    @Override
    public void OnCompetitionClick(Competition competition) {
        Intent intent = new Intent(MainActivity.this, CompetitionActivity.class);
        intent.putExtra("id", competition.getId());
        intent.putExtra("name", competition.getName());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.main) {
            FirebaseAuth.getInstance().signOut();
            finish();
        }
        if (item.getItemId() == R.id.add_to_fav) {
            progressbar.setVisibility(View.VISIBLE);
            viewModel.getCompetitionsFromDatabase().observe(MainActivity.this, competitions -> {
                setRecyclerView(competitions);
                progressbar.setVisibility(View.INVISIBLE);
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
