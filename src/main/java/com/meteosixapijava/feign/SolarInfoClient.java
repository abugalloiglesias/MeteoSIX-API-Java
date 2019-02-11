package com.meteosixapijava.feign;

import com.meteosixapijava.model.DaysProperties;
import com.meteosixapijava.model.Result;
import com.meteosixapijava.model.SolarInfoVariable;
import feign.Param;
import feign.RequestLine;

public interface SolarInfoClient {

    @RequestLine("GET ?coords={coords}&API_KEY={apiKey}")
    Result<DaysProperties<SolarInfoVariable>> find(@Param("coords") String coords, @Param("apiKey") String apiKey);

}
