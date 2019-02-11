package com.meteosixapijava.model;

import java.util.List;

public class Day<V extends Variable> {

    private TimePeriod timePeriod;
    private List<V> variables;

    public Day() {
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public List<V> getVariables() {
        return variables;
    }

    public void setVariables(List<V> variables) {
        this.variables = variables;
    }
}
