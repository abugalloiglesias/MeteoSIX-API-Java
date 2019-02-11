package com.meteosixapijava;

public interface IMeteosix {

    String getApiKey();

    void setApiKey(String apiKey);

    PlaceInterface getPlaceInterface();

    SolarInfoInterface getSolarInfoInterface();

    NumericForecastInfoInterface getNumericForecastInfoInterface();
}
