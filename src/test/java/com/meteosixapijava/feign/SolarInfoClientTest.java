package com.meteosixapijava.feign;

import com.meteosixapijava.model.*;
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

public class SolarInfoClientTest {

    private SolarInfoClient solarInfoClient;

    @Before
    public void setup() throws IOException {
        try (InputStream input = getClass().getResourceAsStream("/getSolarInfo.json")) {
            solarInfoClient = Feign.builder()
                    .client(new MockClient()
                            .ok(HttpMethod.GET,
                                    "/?coords=-8,44&API_KEY=API_KEY",
                                    toByteArray(input)))
                    .decoder(new JacksonDecoder())
                    .target(new MockTarget<>(SolarInfoClient.class));
        }
    }

    @Test
    public void findTest() {
        Result result =
                solarInfoClient.find("-8,44", "API_KEY");
        assertNotNull(result);
        assertNotNull(result.getFeatures());
        assertEquals(1, result.getFeatures().size());
        Feature feature = (Feature) result.getFeatures().get(0);
        assertNotNull(feature.getProperties());
        DaysProperties properties = (DaysProperties) feature.getProperties();
        assertNotNull(properties.getDays());
        assertEquals(5, properties.getDays().size());
        Day day = (Day) properties.getDays().get(0);
        assertNotNull(day.getTimePeriod());
        TimePeriod timePeriod = day.getTimePeriod();
        assertNotNull(timePeriod.getBegin());
        assertNotNull(timePeriod.getBegin().getTimeInstant());
        assertEquals(1550185200000L, timePeriod.getBegin().getTimeInstant().getTime());
        assertNotNull(timePeriod.getEnd());
        assertNotNull(timePeriod.getEnd().getTimeInstant());
        assertEquals(1550271599000L, timePeriod.getEnd().getTimeInstant().getTime());
        assertNotNull(day.getVariables());
        assertEquals(1, day.getVariables().size());
        SolarInfoVariable variable = (SolarInfoVariable) day.getVariables().get(0);
        assertEquals("solar", variable.getName());
        assertNotNull(variable.getSunrise());
        assertEquals(1550215889000L, variable.getSunrise().getTime());
        assertNotNull(variable.getMidday());
        assertEquals(1550234768000L, variable.getMidday().getTime());
        assertNotNull(variable.getSunset());
        assertEquals(1550253648000L, variable.getSunset().getTime());
        assertEquals("10h 29m", variable.getDuration());
    }

}
