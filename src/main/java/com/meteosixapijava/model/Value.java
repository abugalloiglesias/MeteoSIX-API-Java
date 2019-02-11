package com.meteosixapijava.model;

import java.util.Date;

public class Value {

    private Date timeInstant;
    private String modelRun;
    private String value;
    private String moduleValue;
    private String directionValue;
    private String iconURL;

    public Value() {
    }

    public Date getTimeInstant() {
        return timeInstant;
    }

    public void setTimeInstant(Date timeInstant) {
        this.timeInstant = timeInstant;
    }

    public String getModelRun() {
        return modelRun;
    }

    public void setModelRun(String modelRun) {
        this.modelRun = modelRun;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public String getDirectionValue() {
        return directionValue;
    }

    public void setDirectionValue(String directionValue) {
        this.directionValue = directionValue;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
