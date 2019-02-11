package com.meteosixapijava.model;

public class Feature<P extends Properties> {

    private String type;
    private Geometry geometry;
    private P properties;

    public Feature() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public P getProperties() {
        return properties;
    }

    public void setProperties(P properties) {
        this.properties = properties;
    }

}
