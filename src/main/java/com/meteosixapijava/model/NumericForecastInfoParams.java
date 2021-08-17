package com.meteosixapijava.model;

import java.util.List;

public class NumericForecastInfoParams {

    private String locationId;
    private String latitude;
    private String longitude;
    private List<VariableType> variableList;

    public NumericForecastInfoParams() {
    }



    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<VariableType> getVariableList() {
        return variableList;
    }

    public void setVariableList(List<VariableType> variableList) {
        this.variableList = variableList;
    }
}
