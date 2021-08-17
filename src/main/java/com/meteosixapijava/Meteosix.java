package com.meteosixapijava;

public class Meteosix implements IMeteosix {

    private String apiKey;

    private PlaceInterface placeInterface;

    private SolarInfoInterface solarInfoInterface;

    private NumericForecastInfoInterface numericForecastInfoInterface;

    public Meteosix(String apiKey) {
        setApiKey(apiKey);
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public void setApiKey(String apiKey) {
        if (apiKey == null) {
            throw new IllegalArgumentException("API key must not be null");
        }
        this.apiKey = apiKey;
    }

    @Override
    public PlaceInterface getPlaceInterface() {
        if (placeInterface == null) {
            placeInterface = new PlaceInterface(apiKey);
        }
        return placeInterface;
    }

    @Override
    public SolarInfoInterface getSolarInfoInterface() {
        if (solarInfoInterface == null) {
            solarInfoInterface = new SolarInfoInterface(apiKey);
        }
        return solarInfoInterface;
    }

    @Override
    public NumericForecastInfoInterface getNumericForecastInfoInterface() {
        if (numericForecastInfoInterface == null) {
            numericForecastInfoInterface = new NumericForecastInfoInterface(apiKey);
        }
        return numericForecastInfoInterface;
    }
}
