package com.ahmed.gamal.matchatak.utils;

import com.ahmed.gamal.matchatak.model.Competition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServices {

    @GET("competitions?plan=TIER_ONE")
    Call<Competition> getAllCompetitions();


    @GET("competitions/{id}")
    Call<Competition> getCompetitionById(@Path("id") int id);


}