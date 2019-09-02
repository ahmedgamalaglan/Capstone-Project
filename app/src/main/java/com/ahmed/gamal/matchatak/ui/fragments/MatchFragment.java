package com.ahmed.gamal.matchatak.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Match;
import com.ahmed.gamal.matchatak.model.Person;
import com.ahmed.gamal.matchatak.viewmodels.MatchesViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;


public class MatchFragment extends BottomSheetDialogFragment {
    private static final String ID = "id";
    private TextView status, homeTeam, homeTeamResult, awayTeam, awayTeamResult,stadium;
    private LinearLayout referees;

    public MatchFragment() {
    }

    public static MatchFragment newInstance(int matchId) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putInt(ID, matchId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MatchesViewModel viewModel = ViewModelProviders.of(this).get(MatchesViewModel.class);
        if (getArguments() != null) {
            int id = getArguments().getInt(ID);
            viewModel.getMatchById(id).observe(this, match -> {
                if (match != null) {
                    setMatchToView(match);
                }
            });
        }
    }

    private void setMatchToView(Match match) {
        status.setText(match.getStatus());
        homeTeam.setText(match.getHomeTeam().getName());
        homeTeamResult.setText(String.valueOf(match.getScore().getFullTime().getHomeTeam()));
        awayTeam.setText(match.getAwayTeam().getName());
        awayTeamResult.setText(String.valueOf(match.getScore().getFullTime().getAwayTeam()));
        stadium.setText(match.getVenue());
        addRefereeView(referees, match.getReferees());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        status = view.findViewById(R.id.tv_status);
        homeTeam = view.findViewById(R.id.tv_home_team);
        homeTeamResult = view.findViewById(R.id.tv_home_team_result);
        awayTeam = view.findViewById(R.id.tv_away_team);
        awayTeamResult = view.findViewById(R.id.tv_away_team_result);
        stadium=view.findViewById(R.id.tv_stadium);
        referees = view.findViewById(R.id.ll_referees_container);
        return view;
    }

    private void addRefereeView(ViewGroup viewGroup, List<Person> referees) {

        for (Person value : referees) {
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setPadding(15, 0, 15, 5);
            textView.setText(value.getName());
            viewGroup.addView(textView);
        }
    }
}
