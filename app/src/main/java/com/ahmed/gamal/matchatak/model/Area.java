package com.ahmed.gamal.matchatak.model;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Area {


    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("ensignUrl")
    @Expose
    private String ensignUrl;
    @SerializedName("parentAreaId")
    @Expose
    private int parentAreaId;
    @SerializedName("parentArea")
    @Expose
    private String parentArea;

    public Area(String name) {
        this.name = name;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEnsignUrl() {
        return ensignUrl;
    }

    public void setEnsignUrl(String ensignUrl) {
        this.ensignUrl = ensignUrl;
    }

    public int getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(int parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getParentArea() {
        return parentArea;
    }

    public void setParentArea(String parentArea) {
        this.parentArea = parentArea;
    }
}

