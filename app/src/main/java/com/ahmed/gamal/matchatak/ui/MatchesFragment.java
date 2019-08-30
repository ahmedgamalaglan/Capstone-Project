package com.ahmed.gamal.matchatak.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.MatchesAdapter;
import com.ahmed.gamal.matchatak.model.Match;
import com.ahmed.gamal.matchatak.viewmodels.MatchesViewModel;

import java.util.List;

public class MatchesFragment extends Fragment {

    private static final String ID = "id";
    private static final String SEASON = "season";
    private FrameLayout progressbar;
    private RecyclerView recyclerView;

    public static MatchesFragment newInstance(int competitionId, int season) {

        MatchesFragment fragment = new MatchesFragment();
        Bundle args = new Bundle();
        args.putInt(ID, competitionId);
        args.putInt(SEASON, season);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.matches_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_matches);
        progressbar = view.findViewById(R.id.progress_bar);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MatchesViewModel viewModel = ViewModelProviders.of(this).get(MatchesViewModel.class);
        if (getArguments() != null) {
            int id = getArguments().getInt(ID);
            int season = getArguments().getInt(SEASON);
            viewModel.getCompetitionMatches(id, season).observe(this, this::setMatchesToUi);

        }
    }

    private void setMatchesToUi(List<Match> matches) {
        MatchesAdapter adapter = new MatchesAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setData(matches);
        progressbar.setVisibility(View.INVISIBLE);
    }
}
