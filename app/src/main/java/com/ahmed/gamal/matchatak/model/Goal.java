package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goal {
    @SerializedName("minute")
    @Expose
    private int minute;
    @SerializedName("extraTime")
    @Expose
    private Object extraTime;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("scorer")
    @Expose
    private Person scorer;
    @SerializedName("assist")
    @Expose
    private Person assist;

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Object getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(Object extraTime) {
        this.extraTime = extraTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getScorer() {
        return scorer;
    }

    public void setScorer(Person scorer) {
        this.scorer = scorer;
    }

    public Person getAssist() {
        return assist;
    }

    public void setAssist(Person assist) {
        this.assist = assist;
    }

}