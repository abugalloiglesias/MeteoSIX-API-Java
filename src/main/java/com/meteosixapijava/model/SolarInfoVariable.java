package com.meteosixapijava.model;

import java.util.Date;

public class SolarInfoVariable implements Variable {

    private String name;
    private Date sunrise;
    private Date midday;
    private Date sunset;
    private String duration;

    public SolarInfoVariable() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getMidday() {
        return midday;
    }

    public void setMidday(Date midday) {
        this.midday = midday;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
