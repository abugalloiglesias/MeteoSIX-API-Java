package com.meteosixapijava.feign;

import com.meteosixapijava.model.Feature;
import com.meteosixapijava.model.PlaceProperties;
import com.meteosixapijava.model.Result;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import feign.mock.MockTarget;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static feign.Util.toByteArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaceClientTest {

    private PlaceClient placeClient;

    @Before
    public void setup() throws IOException {
        try (InputStream input = getClass().getResourceAsStream("/findPlaces.json")) {
            placeClient = Feign.builder()
                    .client(new MockClient()
                            .ok(HttpMethod.GET,
                                    "/?location=ourense&API_KEY=API_KEY",
                                    toByteArray(input)))
                    .decoder(new JacksonDecoder())
                    .target(new MockTarget<>(PlaceClient.class));
        }
    }

    @Test
    public void findTest() {
        Result result =
                placeClient.find("ourense", "API_KEY");
        assertNotNull(result);
        assertNotNull(result.getFeatures());
        assertEquals(3, result.getFeatures().size());
        Feature feature = (Feature) result.getFeatures().get(0);
        assertNotNull(feature.getProperties());
        PlaceProperties properties = (PlaceProperties) feature.getProperties();
        assertEquals("71953", properties.getId());
        assertEquals("Ourense", properties.getName());
        assertEquals("OURENSE", properties.getMunicipality());
        assertEquals("Ourense", properties.getProvince());
        assertEquals("locality", properties.getType());
    }

}
