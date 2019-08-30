package com.ahmed.gamal.matchatak.utils;

import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.model.Match;
import com.ahmed.gamal.matchatak.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServices {

    @GET("competitions?plan=TIER_ONE")
    Call<Competition> getAllCompetitions();


    @GET("competitions/{id}")
    Call<Competition> getCompetitionById(@Path("id") int id);


    @GET("teams/{id}")
    Call<Team> getTeamById(@Path("id") int teamId);

    @GET("competitions/{id}/teams")
    Call<Team> getCompetitionTeamsList(@Path("id") int competitionId,@Query("season") int season);

    @GET("matches/{id}")
    Call<Match> getMatchById(@Path("id") int teamId);

    @GET("competitions/{id}/matches")
    Call<Match> getCompetitionMatchesList(@Path("id") int competitionId,@Query("season") int season );


}