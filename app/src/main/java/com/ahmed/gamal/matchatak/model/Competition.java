package com.ahmed.gamal.matchatak.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Competition {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("emblemUrl")
    @Expose
    private Object emblemUrl;
    @SerializedName("plan")
    @Expose
    private String plan;
    @SerializedName("currentSeason")
    @Expose
    private Season currentSeason;
    @SerializedName("numberOfAvailableSeasons")
    @Expose
    private int numberOfAvailableSeasons;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getEmblemUrl() {
        return emblemUrl;
    }

    public void setEmblemUrl(Object emblemUrl) {
        this.emblemUrl = emblemUrl;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Season currentSeason) {
        this.currentSeason = currentSeason;
    }

    public int getNumberOfAvailableSeasons() {
        return numberOfAvailableSeasons;
    }

    public void setNumberOfAvailableSeasons(int numberOfAvailableSeasons) {
        this.numberOfAvailableSeasons = numberOfAvailableSeasons;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
