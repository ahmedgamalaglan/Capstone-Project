package com.ahmed.gamal.matchatak.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "teams")
public class Team {

    @Ignore
    @SerializedName("teams")
    @Expose
    private List<Team> teams;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @Ignore
    @SerializedName("coach")
    @Expose
    private Person coach;
    @Ignore
    @SerializedName("captain")
    @Expose
    private Person captain;
    @Ignore
    @SerializedName("lineup")
    @Expose
    private List<Person> lineup;
    @Ignore
    @SerializedName("bench")
    @Expose
    private List<Person> bench;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("tla")
    @Expose
    private String tla;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("founded")
    @Expose
    private int founded;
    @SerializedName("clubColors")
    @Expose
    private String clubColors;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;
    @Ignore
    @SerializedName("squad")
    @Expose
    private List<Person> squad = null;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getCoach() {
        return coach;
    }

    public void setCoach(Person coach) {
        this.coach = coach;
    }

    public Person getCaptain() {
        return captain;
    }

    public void setCaptain(Person captain) {
        this.captain = captain;
    }

    public List<Person> getLineup() {
        return lineup;
    }

    public void setLineup(List<Person> lineup) {
        this.lineup = lineup;
    }

    public List<Person> getBench() {
        return bench;
    }

    public void setBench(List<Person> bench) {
        this.bench = bench;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Person> getSquad() {
        return squad;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public void setSquad(List<Person> squad) {
        this.squad = squad;
    }
}
