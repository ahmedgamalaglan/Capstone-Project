package com.ahmed.gamal.matchatak;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmed.gamal.matchatak.data.CompetitionsDao;
import com.ahmed.gamal.matchatak.data.MDataBase;
import com.ahmed.gamal.matchatak.data.TeamsDao;
import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.model.Match;
import com.ahmed.gamal.matchatak.model.Team;
import com.ahmed.gamal.matchatak.utils.ApiHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private CompetitionsDao competitionsDao;
    private TeamsDao teamsDao;

    public DataRepository(Application application) {
        competitionsDao = MDataBase.getInstance(application).competitionsDao();
        teamsDao = MDataBase.getInstance(application).teamsDao();
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

    public LiveData<List<Competition>> getCompetitionsFromDB() {
//        final MutableLiveData<List<Competition>> competitions = new MutableLiveData<>();
//        competitions.postValue(competitionsDao.getCompetitions().getValue());
        return competitionsDao.getCompetitions();
    }

    public void addCompetitionToDataBase(Competition competition) {
        new AddCompetitionToDB().execute(competition);
    }

    public LiveData<List<Team>> getTeamsFromDB() {
        final MutableLiveData<List<Team>> teams = new MutableLiveData<>();
        teams.postValue(teamsDao.getTeams().getValue());
        return teams;
    }
    public void addTeamToDataBase(Team team) {
        new AddTeamToDB().execute(team);
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

    public LiveData<Team> getTeamById(int teamId) {
        final MutableLiveData<Team> team = new MutableLiveData<>();
        ApiHelper.getClient().getTeamById(teamId).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NotNull Call<Team> call, @NotNull Response<Team> response) {
                team.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Team> call, @NotNull Throwable t) {

            }
        });
        return team;
    }

    public LiveData<List<Team>> getCompetitionTeamsList(int competitionId, int season) {
        final MutableLiveData<List<Team>> teams = new MutableLiveData<>();
        ApiHelper.getClient().getCompetitionTeamsList(competitionId, season).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(@NotNull Call<Team> call, @NotNull Response<Team> response) {
                teams.postValue(response.body() != null ? response.body().getTeams() : null);
            }

            @Override
            public void onFailure(@NotNull Call<Team> call, @NotNull Throwable t) {

            }
        });
        return teams;
    }

    public LiveData<List<Match>> getCompetitionMatchesList(int competitionId, int season) {
        final MutableLiveData<List<Match>> matches = new MutableLiveData<>();
        ApiHelper.getClient().getCompetitionMatchesList(competitionId, season).enqueue(new Callback<Match>() {
            @Override
            public void onResponse(@NotNull Call<Match> call, @NotNull Response<Match> response) {
                matches.postValue(response.body() != null ? response.body().getMatches() : null);
            }

            @Override
            public void onFailure(@NotNull Call<Match> call, @NotNull Throwable t) {

            }
        });
        return matches;
    }

    public LiveData<Match> getMatchById(int matchId) {
        final MutableLiveData<Match> match = new MutableLiveData<>();
        ApiHelper.getClient().getMatchById(matchId).enqueue(new Callback<Match>() {
            @Override
            public void onResponse(@NotNull Call<Match> call, @NotNull Response<Match> response) {
                assert response.body() != null;
                match.postValue(response.body().getMatch());
            }

            @Override
            public void onFailure(@NotNull Call<Match> call, @NotNull Throwable t) {

            }
        });
        return match;
    }

    class AddCompetitionToDB extends AsyncTask<Competition, Void, Void> {

        @Override
        protected Void doInBackground(Competition... competitions) {
            competitionsDao.insertMovie(competitions[0]);
            return null;
        }
    }

    class AddTeamToDB extends AsyncTask<Team, Void, Void> {

        @Override
        protected Void doInBackground(Team... teams) {
            teamsDao.insertMovie(teams[0]);
            return null;
        }
    }
}
