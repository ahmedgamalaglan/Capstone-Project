package com.ahmed.gamal.matchatak.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.DataRepository;
import com.ahmed.gamal.matchatak.model.Competition;

public class CompetitionViewModel extends AndroidViewModel {

    private DataRepository repository;
    private LiveData<Competition> competition;
    public CompetitionViewModel(@NonNull Application application) {
        super(application);
        repository=new DataRepository(application);
        competition=new MutableLiveData<>();
    }

    public LiveData<Competition> getCompetitionById(int id){
        if (competition==null) competition=new MutableLiveData<>();
        competition = repository.getCompetitionById(id);
        return competition;
    }


}
