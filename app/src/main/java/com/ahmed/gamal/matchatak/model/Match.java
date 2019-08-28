package com.ahmed.gamal.matchatak.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Match {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("competition")
    @Expose
    private Competition competition;
    @SerializedName("utcDate")
    @Expose
    private String utcDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("minute")
    @Expose
    private Object minute;
    @SerializedName("attendance")
    @Expose
    private int attendance;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("matchday")
    @Expose
    private Object matchday;
    @SerializedName("stage")
    @Expose
    private String stage;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("homeTeam")
    @Expose
    private Team homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private Team awayTeam;
    @SerializedName("goals")
    @Expose
    private List<Goal> goals;
    @SerializedName("bookings")
    @Expose
    private List<Booking> bookings;
    @SerializedName("substitutions")
    @Expose
    private List<Substitution> substitutions;
    @SerializedName("referees")
    @Expose
    private List<Person> referees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMinute() {
        return minute;
    }

    public void setMinute(Object minute) {
        this.minute = minute;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Object getMatchday() {
        return matchday;
    }

    public void setMatchday(Object matchday) {
        this.matchday = matchday;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(List<Substitution> substitutions) {
        this.substitutions = substitutions;
    }

    public List<Person> getReferees() {
        return referees;
    }

    public void setReferees(List<Person> referees) {
        this.referees = referees;
    }
}
