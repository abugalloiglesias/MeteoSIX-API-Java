package com.meteosixapijava;

import com.meteosixapijava.feign.NumericForecastInfoClient;
import com.meteosixapijava.model.DaysProperties;
import com.meteosixapijava.util.DateUtils;
import com.meteosixapijava.config.Config;
import com.meteosixapijava.feign.PlaceClient;
import com.meteosixapijava.model.Result;
import com.meteosixapijava.model.ValuesVariable;
import com.meteosixapijava.model.VariableType;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.util.Date;
import java.util.List;

public class NumericForecastInfoInterface {

    private final String apiKey;

    private NumericForecastInfoClient numericForecastInfoClient;

    public NumericForecastInfoInterface(String apiKey) {
        this.apiKey = apiKey;
    }

    private NumericForecastInfoClient getNumericForecastInfoClient() {
        if (numericForecastInfoClient == null) {
            numericForecastInfoClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .logger(new Slf4jLogger(PlaceClient.class))
                    .logLevel(Logger.Level.FULL)
                    .target(NumericForecastInfoClient.class, Config.METEOSIX_BASE_URL + "getNumericForecastInfo");
        }
        return numericForecastInfoClient;
    }

    public Result<DaysProperties<ValuesVariable>> findByLocationId(String locationId, List<VariableType> variableList, Date startTime, Date endTime) {
        if (startTime != null && endTime != null) {
            return getNumericForecastInfoClient().findByLocationIdInTimeRange(
                    locationId, concatenateVariables(variableList), DateUtils.formatDateInGaliciaTimeZone(startTime),
                    DateUtils.formatDateInGaliciaTimeZone(endTime), apiKey);
        } else {
            return getNumericForecastInfoClient().findByLocationId(locationId, concatenateVariables(variableList), apiKey);
        }
    }

    public Result<DaysProperties<ValuesVariable>> findByCoords(double latitude, double longitude, List<VariableType> variableList, Date startTime, Date endTime) {
        if (startTime != null && endTime != null) {
            return getNumericForecastInfoClient().findByCoordsInTimeRange(
                    longitude + "," + latitude, concatenateVariables(variableList),
                    DateUtils.formatDateInGaliciaTimeZone(startTime), DateUtils.formatDateInGaliciaTimeZone(endTime), apiKey);
        } else {
            return getNumericForecastInfoClient().findByCoords(longitude + "," + latitude, concatenateVariables(variableList), apiKey);
        }
    }

    private String concatenateVariables(List<VariableType> variableList) {
        StringBuilder result = new StringBuilder();
        if (variableList != null) {
            for (int i = 0; i < variableList.size(); i++) {
                VariableType variable = variableList.get(i);
                if (i > 0) {
                    result.append(",");
                }
                result.append(variable.toString());
            }
        }
        return result.toString();
    }

}
