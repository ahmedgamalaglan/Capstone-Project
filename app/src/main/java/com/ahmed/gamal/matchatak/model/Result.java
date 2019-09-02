package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("homeTeam")
    @Expose
    private int homeTeam=-1;

    @SerializedName("awayTeam")
    @Expose
    private int awayTeam=-1;

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }
}
