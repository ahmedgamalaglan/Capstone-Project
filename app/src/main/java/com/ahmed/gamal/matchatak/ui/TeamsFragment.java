package com.ahmed.gamal.matchatak.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Team;
import com.ahmed.gamal.matchatak.viewmodels.TeamsViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeamsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeamsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamsFragment extends Fragment {


    private TeamsViewModel viewModel;
    private static String ID = "id";
    private static String SEASON = "season";

    private OnFragmentInteractionListener mListener;

    public TeamsFragment() {
    }

    public static TeamsFragment newInstance(int competitionId, int season) {
        TeamsFragment fragment = new TeamsFragment();
        Bundle args = new Bundle();
        args.putInt(ID, competitionId);
        args.putInt(SEASON, season);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(TeamsViewModel.class);
        if (getArguments() != null) {
            int competitionId = getArguments().getInt(ID);
            int season = getArguments().getInt(SEASON);
            viewModel.getCompetitionTeamsList(competitionId,season).observe(this, teams -> {
                if (teams != null)
                    setTeamsToView(teams);
            });
        }
    }

    private void setTeamsToView(List<Team> teams) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }

    public void onButtonPressed(Team team) {
        if (mListener != null) {
            mListener.onFragmentInteraction(team);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Team team);
    }
}
