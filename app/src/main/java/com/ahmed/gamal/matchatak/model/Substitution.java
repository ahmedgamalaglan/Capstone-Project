package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Substitution {
    @SerializedName("minute")
    @Expose
    private int minute;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("playerOut")
    @Expose
    private Person playerOut;
    @SerializedName("playerIn")
    @Expose
    private Person playerIn;

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getPlayerOut() {
        return playerOut;
    }

    public void setPlayerOut(Person playerOut) {
        this.playerOut = playerOut;
    }

    public Person getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(Person playerIn) {
        this.playerIn = playerIn;
    }
}
