package com.ahmed.gamal.matchatak.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.adapters.PlayersAdapter;
import com.ahmed.gamal.matchatak.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PlayerFragment extends Fragment {

    private static final String PLAYERS_kEY = "column-count";
    private List<Person> players;

    public PlayerFragment() {
    }


    public static PlayerFragment newInstance(List<Person> playerList) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(PLAYERS_kEY, (ArrayList<? extends Parcelable>) playerList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            players = getArguments().getParcelableArrayList(PLAYERS_kEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = view.findViewById(R.id.rv_players);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            PlayersAdapter adapter=new PlayersAdapter();
            recyclerView.setAdapter(adapter);
            adapter.setData(players);
        }
        return view;
    }

}
