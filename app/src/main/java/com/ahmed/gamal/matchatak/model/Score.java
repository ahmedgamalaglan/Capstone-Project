package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("winner")
    @Expose
    private String winner;

    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("fullTime")
    @Expose
    private Result fullTime;
    @SerializedName("halfTime")
    @Expose
    private Result halfTime;
    @SerializedName("extraTime")
    @Expose
    private Result extraTime;
    @SerializedName("penalties")
    @Expose
    private Result penalties;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Result getFullTime() {
        return fullTime;
    }

    public void setFullTime(Result fullTime) {
        this.fullTime = fullTime;
    }

    public Result getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(Result halfTime) {
        this.halfTime = halfTime;
    }

    public Result getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Result extraTime) {
        this.extraTime = extraTime;
    }

    public Result getPenalties() {
        return penalties;
    }

    public void setPenalties(Result penalties) {
        this.penalties = penalties;
    }


}
