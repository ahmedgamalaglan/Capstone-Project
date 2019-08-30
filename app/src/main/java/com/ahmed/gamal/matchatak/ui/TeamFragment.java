package com.ahmed.gamal.matchatak.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.model.Team;
import com.ahmed.gamal.matchatak.viewmodels.TeamsViewModel;

public class TeamFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private static final String ID="teamId";
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.team_list_row, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
