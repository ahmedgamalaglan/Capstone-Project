package com.ahmed.gamal.matchatak.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.DataRepository;
import com.ahmed.gamal.matchatak.model.Match;

import java.util.List;

public class MatchesViewModel extends AndroidViewModel {
    private DataRepository repository;

    private LiveData<List<Match>> matches;
    private LiveData<Match> match;

    public MatchesViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);

    }

    public LiveData<Match> getMatchById(int teamId) {
        if (match == null) {
            match = new MutableLiveData<>();
        }
        match = repository.getMatchById(teamId);
        return match;
    }

    public LiveData<List<Match>> getCompetitionMatches(int competitionId, int season) {
        if (matches == null) {
            matches = new MutableLiveData<>();
        }
        matches = repository.getCompetitionMatchesList(competitionId, season);
        return matches;
    }
}
