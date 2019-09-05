package com.ahmed.gamal.matchatak.ui.fragments;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
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
import java.util.Objects;


public class MatchFragment extends BottomSheetDialogFragment {
    private static final String ID = "id";
    private TextView status, homeTeam, homeTeamResult, awayTeam, awayTeamResult, stadium;
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
        updateMyWidgets(Objects.requireNonNull(getActivity()), match);

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
        stadium = view.findViewById(R.id.tv_stadium);
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

    public static void updateMyWidgets(Context context, Match match) {
        Intent updateIntent = new Intent();
        Bundle bundle = new Bundle();
        updateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        bundle.putString("status", match.getStatus());
        bundle.putString("homeTeam", match.getHomeTeam().getName());
        bundle.putString("awayTeam", match.getAwayTeam().getName());
        bundle.putString("homeTeamResult", match.getScore().getFullTime().getHomeTeam() == -1 ? "" : String.valueOf(match.getScore().getFullTime().getHomeTeam()));
        bundle.putString("awayTeamResult", match.getScore().getFullTime().getAwayTeam() == -1 ? "" : String.valueOf(match.getScore().getFullTime().getAwayTeam()));
        updateIntent.putExtra("bundle", bundle);
        context.sendBroadcast(updateIntent);
    }
}
