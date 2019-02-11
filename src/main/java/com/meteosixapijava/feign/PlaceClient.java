package com.meteosixapijava.feign;

import com.meteosixapijava.model.PlaceProperties;
import com.meteosixapijava.model.Result;
import feign.Param;
import feign.RequestLine;

public interface PlaceClient {

    @RequestLine("GET ?location={location}&API_KEY={apiKey}")
    Result<PlaceProperties> find(@Param("location") String location, @Param("apiKey") String apiKey);

}
