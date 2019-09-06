package com.ahmed.gamal.matchatak.ui.activities.competition;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.ahmed.gamal.matchatak.Const;
import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.PagerAdapter;
import com.ahmed.gamal.matchatak.adapters.SeasonsAdapter;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.model.Team;
import com.ahmed.gamal.matchatak.ui.fragments.MatchFragment;
import com.ahmed.gamal.matchatak.ui.fragments.TeamFragment;
import com.ahmed.gamal.matchatak.utils.DateUtil;
import com.ahmed.gamal.matchatak.viewmodels.CompetitionViewModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class CompetitionActivity extends AppCompatActivity implements SeasonsAdapter.OnSeasonClickListener, TeamsFragment.OnTeamsInteractionListener, MatchesFragment.OnMatchFragmentInteractionListener {

    private RecyclerView recyclerView;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private View progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
        Toolbar toolbar = findViewById(R.id.toolbar);

        ImageView imageView = findViewById(R.id.iv_bar_background);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.rv_seasons);
        viewPager = findViewById(R.id.vp_viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        progressbar = findViewById(R.id.progress_bar);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        CompetitionViewModel viewModel = ViewModelProviders.of(this).get(CompetitionViewModel.class);
        if (getIntent() != null && getIntent().hasExtra("id")) {
            int id = getIntent().getIntExtra("id", 0);
            String name = getIntent().getStringExtra("name");
            Picasso.get().load(Const.getImageUrl(id)).into(imageView);
            collapsingToolbarLayout.setTitle(name);

            viewModel.getCompetitionById(id).observe(this, competition -> {
                        if (competition != null) {
                            setSeasons(competition);
                            pagerAdapter = new PagerAdapter(getSupportFragmentManager(), competition.getId(), Integer.valueOf(DateUtil.seasonNum(competition.getSeasons().get(0).getStartDate())));
                            viewPager.setAdapter(pagerAdapter);
                            tabLayout.setupWithViewPager(viewPager);

                        }
                        progressbar.setVisibility(View.INVISIBLE);

                    }
            );
        }

    }


    private void setSeasons(Competition competition) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        SeasonsAdapter adapter = new SeasonsAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(competition);
    }

    @Override
    public void onSeasonClicked(int competitionId, int seasonId) {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), competitionId, seasonId);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onMatchClick(int matchId) {

        MatchFragment.newInstance(matchId).show(getSupportFragmentManager(),"");

    }

    @Override
    public void onTeamInteraction(int teamId) {
        TeamFragment.newInstance(teamId).show(getSupportFragmentManager(),"");

    }
}
