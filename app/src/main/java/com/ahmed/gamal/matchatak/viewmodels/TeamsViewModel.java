package com.ahmed.gamal.matchatak.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.DataRepository;
import com.ahmed.gamal.matchatak.model.Team;

import java.util.List;


public class TeamsViewModel extends AndroidViewModel {
    private DataRepository repository;
    private LiveData<Team> team;
    private LiveData<List<Team>> teams;

    public TeamsViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
    }

    public LiveData<Team> getTeamById(int teamId) {
        if (team == null) {
            team = new MutableLiveData<>();
            team = repository.getTeamById(teamId);
        }
        return team;
    }

    public LiveData<List<Team>> getCompetitionTeamsList(int competitionId, int season) {
        if (teams == null) {
            teams = new MutableLiveData<>();
            teams = repository.getCompetitionTeamsList(competitionId, season);
        }
        return teams;
    }

    public LiveData<List<Team>> getFavoriteTeamsList() {
        if (teams == null) {
            teams = new MutableLiveData<>();
            teams = repository.getTeamsFromDB();
        }
        return teams;
    }

    public void addFavoriteTeam(Team team) {
        repository.addTeamToDataBase(team);
    }
}
