package com.meteosixapijava.feign;

import com.meteosixapijava.model.DaysProperties;
import com.meteosixapijava.model.Result;
import com.meteosixapijava.model.ValuesVariable;
import feign.Param;
import feign.RequestLine;

public interface NumericForecastInfoClient {

    @RequestLine("GET ?coords={coords}&variables={variables}&API_KEY={apiKey}")
    Result<DaysProperties<ValuesVariable>> findByCoords(@Param("coords") String coords, @Param("variables") String variables, @Param("apiKey") String apiKey);

    @RequestLine("GET ?coords={coords}&variables={variables}&startTime={startTime}&endTime={endTime}&API_KEY={apiKey}")
    Result<DaysProperties<ValuesVariable>> findByCoordsInTimeRange(@Param("coords") String coords, @Param("variables") String variables,
                                                                   @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("apiKey") String apiKey);

    @RequestLine("GET ?locationIds={locationIds}&variables={variables}&API_KEY={apiKey}")
    Result<DaysProperties<ValuesVariable>> findByLocationId(@Param("locationIds") String coords, @Param("variables") String variables, @Param("apiKey") String apiKey);

    @RequestLine("GET ?locationIds={locationIds}&variables={variables}&startTime={startTime}&endTime={endTime}&API_KEY={apiKey}")
    Result<DaysProperties<ValuesVariable>> findByLocationIdInTimeRange(@Param("locationIds") String locationIds, @Param("variables") String variables,
                                                                       @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("apiKey") String apiKey);

}
