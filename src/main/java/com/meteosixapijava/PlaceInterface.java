package com.meteosixapijava;

import com.meteosixapijava.config.Config;
import com.meteosixapijava.feign.PlaceClient;
import com.meteosixapijava.model.PlaceProperties;
import com.meteosixapijava.model.Result;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class PlaceInterface {

    private final String apiKey;

    private PlaceClient placeClient;

    public PlaceInterface(String apiKey) {
        this.apiKey = apiKey;
    }

    private PlaceClient getPlaceClient() {
        if (placeClient == null) {
            placeClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .logger(new Slf4jLogger(PlaceClient.class))
                    .logLevel(Logger.Level.FULL)
                    .target(PlaceClient.class, Config.METEOSIX_BASE_URL + "findPlaces");
        }
        return placeClient;
    }

    public Result<PlaceProperties> find(String location) {
        return getPlaceClient().find(location, apiKey);
    }
}
