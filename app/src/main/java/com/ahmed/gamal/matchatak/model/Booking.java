package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booking {
    @SerializedName("minute")
    @Expose
    private int minute;
    @SerializedName("team")
    @Expose
    private Team team;
    @SerializedName("player")
    @Expose
    private Person player;
    @SerializedName("card")
    @Expose
    private String card;

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

    public Person getPlayer() {
        return player;
    }

    public void setPlayer(Person player) {
        this.player = player;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
