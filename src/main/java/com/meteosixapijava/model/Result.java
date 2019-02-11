package com.meteosixapijava.model;

import java.util.List;

public class Result<P extends Properties> {

    private List<Feature<P>> features;

    public Result() {
    }

    public List<Feature<P>> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature<P>> features) {
        this.features = features;
    }
}
