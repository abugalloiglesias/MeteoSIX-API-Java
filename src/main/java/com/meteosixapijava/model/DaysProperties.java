package com.meteosixapijava.model;

import java.util.List;

public class DaysProperties<V extends Variable> implements Properties {

    private List<Day<V>> days;

    public DaysProperties() {
    }

    public List<Day<V>> getDays() {
        return days;
    }

    public void setDays(List<Day<V>> days) {
        this.days = days;
    }
}
