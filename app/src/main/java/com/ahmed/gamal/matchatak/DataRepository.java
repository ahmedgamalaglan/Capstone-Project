package com.ahmed.gamal.matchatak;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.utils.ApiHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {


    public DataRepository(Application application) {
    }

    public LiveData<List<Competition>> getCompetitions() {
        final MutableLiveData<List<Competition>> competitions = new MutableLiveData<>();
        ApiHelper.getClient().getAllCompetitions().enqueue(new Callback<Competition>() {
            @Override
            public void onResponse(@NotNull Call<Competition> call, @NotNull Response<Competition> response) {
                competitions.postValue(response.body() != null ? response.body().getCompetitions() : null);
            }

            @Override
            public void onFailure(@NotNull Call<Competition> call, @NotNull Throwable t) {

            }
        });
        return competitions;
    }

    public LiveData<Competition> getCompetitionById(int id) {
        final MutableLiveData<Competition> competition = new MutableLiveData<>();
        ApiHelper.getClient().getCompetitionById(id).enqueue(new Callback<Competition>() {
            @Override
            public void onResponse(@NotNull Call<Competition> call, @NotNull Response<Competition> response) {
                competition.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Competition> call, @NotNull Throwable t) {

            }
        });
        return competition;
    }
}
