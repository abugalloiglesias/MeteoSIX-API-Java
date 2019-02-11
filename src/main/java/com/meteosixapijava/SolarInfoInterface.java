package com.meteosixapijava;

import com.meteosixapijava.feign.SolarInfoClient;
import com.meteosixapijava.model.SolarInfoVariable;
import com.meteosixapijava.config.Config;
import com.meteosixapijava.feign.PlaceClient;
import com.meteosixapijava.model.DaysProperties;
import com.meteosixapijava.model.Result;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class SolarInfoInterface {

    private final String apiKey;

    private SolarInfoClient solarInfoClient;

    public SolarInfoInterface(String apiKey) {
        this.apiKey = apiKey;
    }

    private SolarInfoClient getSolarInfoClient() {
        if (solarInfoClient == null) {
            solarInfoClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .logger(new Slf4jLogger(PlaceClient.class))
                    .logLevel(Logger.Level.FULL)
                    .target(SolarInfoClient.class, Config.METEOSIX_BASE_URL + "getSolarInfo");
        }
        return solarInfoClient;
    }

    public Result<DaysProperties<SolarInfoVariable>> find(double latitude, double longitude) {
        return getSolarInfoClient().find(longitude + "," + latitude, apiKey);
    }

}
