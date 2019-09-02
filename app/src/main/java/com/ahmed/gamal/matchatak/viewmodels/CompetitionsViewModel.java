package com.ahmed.gamal.matchatak.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.DataRepository;
import com.ahmed.gamal.matchatak.model.Competition;

import java.util.List;

public class CompetitionsViewModel extends AndroidViewModel {

    private DataRepository repository;
    private LiveData<List<Competition>> competitions;

    public CompetitionsViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
    }

    public LiveData<List<Competition>> getCompetitions() {
        if (competitions == null) competitions = new MutableLiveData<>();
        competitions = repository.getCompetitions();
        return competitions;
    }

    public LiveData<List<Competition>> getCompetitionsFromDatabase() {
        if (competitions == null) competitions = new MutableLiveData<>();
        competitions = repository.getCompetitionsFromDB();
        return competitions;
    }

    public void addCompetitionToDatabase(Competition competition) {
        repository.addCompetitionToDataBase(competition);
    }

}
