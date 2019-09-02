package com.ahmed.gamal.matchatak.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Team;
import com.ahmed.gamal.matchatak.viewmodels.TeamsViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TeamFragment extends BottomSheetDialogFragment {

    private static final String ID = "teamId";
    private TextView teamName, stadium, website, phone, email, clubColors;

    public TeamFragment() {
    }

    public static TeamFragment newInstance(int teamId) {
        TeamFragment fragment = new TeamFragment();
        Bundle args = new Bundle();
        args.putInt(ID, teamId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TeamsViewModel viewModel = ViewModelProviders.of(this).get(TeamsViewModel.class);
        if (getArguments() != null) {
            int id = getArguments().getInt(ID);
            viewModel.getTeamById(id).observe(this, this::setTeamToView);
        }
    }

    private void setTeamToView(Team team) {
        stadium.setText(team.getVenue());
        teamName.setText(team.getName());
        phone.setText(team.getPhone());
        email.setText(team.getEmail());
        website.setText(team.getWebsite());
        clubColors.setText(team.getClubColors());

        getChildFragmentManager().beginTransaction().addToBackStack("")
                .replace(R.id.fl_player_container, PlayerFragment.newInstance(team.getSquad())).commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        stadium = view.findViewById(R.id.tv_stadium);
        phone = view.findViewById(R.id.tv_phone);
        email = view.findViewById(R.id.tv_email);
        clubColors = view.findViewById(R.id.tv_club_colors);
        website = view.findViewById(R.id.tv_website);
        teamName = view.findViewById(R.id.tv_team_name);
        return view;
    }


}
