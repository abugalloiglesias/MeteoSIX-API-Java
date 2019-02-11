package com.meteosixapijava.model;

public class TimePeriod {

    private TimeInstant begin;
    private TimeInstant end;

    public TimePeriod() {
    }

    public TimeInstant getBegin() {
        return begin;
    }

    public void setBegin(TimeInstant begin) {
        this.begin = begin;
    }

    public TimeInstant getEnd() {
        return end;
    }

    public void setEnd(TimeInstant end) {
        this.end = end;
    }
}
