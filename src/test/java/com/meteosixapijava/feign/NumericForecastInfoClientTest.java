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

public class NumericForecastInfoClientTest {

    private NumericForecastInfoClient numericForecastInfoClient;

    @Before
    public void setup() throws IOException {
        try (InputStream findByCoordsInput = getClass().getResourceAsStream("/findByCoords.json");
             InputStream findByCoordsInTimeRangeInput = getClass().getResourceAsStream("/findByCoordsInTimeRange.json");
             InputStream findByLocationIdInput = getClass().getResourceAsStream("/findByLocationId.json");
             InputStream findByLocationIdInTimeRangeInput = getClass().getResourceAsStream("/findByLocationIdInTimeRange.json")) {
            numericForecastInfoClient = Feign.builder()
                    .client(new MockClient()
                            .ok(HttpMethod.GET,
                                    "/?coords=-8,44&variables=sky_state,temperature&API_KEY=API_KEY",
                                    toByteArray(findByCoordsInput))
                            .ok(HttpMethod.GET,
                                    "/?coords=-8,44&variables=sky_state,temperature&startTime=2019-02-15T12:00:00&endTime=2019-02-15T16:00:00&API_KEY=API_KEY",
                                    toByteArray(findByCoordsInTimeRangeInput))
                            .ok(HttpMethod.GET,
                                    "/?locationIds=42917&variables=sky_state,temperature&API_KEY=API_KEY",
                                    toByteArray(findByLocationIdInput))
                            .ok(HttpMethod.GET,
                                    "/?locationIds=42917&variables=sky_state,temperature&startTime=2019-02-15T12:00:00&endTime=2019-02-15T16:00:00&API_KEY=API_KEY",
                                    toByteArray(findByLocationIdInTimeRangeInput)))
                    .decoder(new JacksonDecoder())
                    .target(new MockTarget<>(NumericForecastInfoClient.class));
        }
    }

    @Test
    public void findByCoordsTest() {
        Result result =
                numericForecastInfoClient.findByCoords("-8,44", "sky_state,temperature", "API_KEY");
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
        assertEquals(1550069572000L, timePeriod.getBegin().getTimeInstant().getTime());
        assertNotNull(timePeriod.getEnd());
        assertNotNull(timePeriod.getEnd().getTimeInstant());
        assertEquals(1550098799000L, timePeriod.getEnd().getTimeInstant().getTime());
        assertNotNull(day.getVariables());
        assertEquals(2, day.getVariables().size());
        ValuesVariable variable = (ValuesVariable) day.getVariables().get(0);
        assertEquals("sky_state", variable.getName());
        assertEquals("WRF", variable.getModel());
        assertEquals("04km", variable.getGrid());
        assertNotNull(variable.getValues());
        assertEquals(8, variable.getValues().size());
        Value value = variable.getValues().get(0);
        assertEquals(1550070000000L, value.getTimeInstant().getTime());
        assertEquals("SUNNY", value.getValue());
        assertEquals("http://servizos.meteogalicia.es:80/apiv3/images/weather/sky-state/day/despexado.png", value.getIconURL());
    }

    @Test
    public void findByCoordsInTimeRangeTest() {
        Result result =
                numericForecastInfoClient.findByCoordsInTimeRange("-8,44", "sky_state,temperature",
                        "2019-02-15T12:00:00", "2019-02-15T16:00:00", "API_KEY");
        assertNotNull(result);
        assertNotNull(result.getFeatures());
        assertEquals(1, result.getFeatures().size());
        Feature feature = (Feature) result.getFeatures().get(0);
        assertNotNull(feature.getProperties());
        DaysProperties properties = (DaysProperties) feature.getProperties();
        assertNotNull(properties.getDays());
        assertEquals(1, properties.getDays().size());
        Day day = (Day) properties.getDays().get(0);
        assertNotNull(day.getTimePeriod());
        TimePeriod timePeriod = day.getTimePeriod();
        assertNotNull(timePeriod.getBegin());
        assertNotNull(timePeriod.getBegin().getTimeInstant());
        assertEquals(1550228400000L, timePeriod.getBegin().getTimeInstant().getTime());
        assertNotNull(timePeriod.getEnd());
        assertNotNull(timePeriod.getEnd().getTimeInstant());
        assertEquals(1550242800000L, timePeriod.getEnd().getTimeInstant().getTime());
        assertNotNull(day.getVariables());
        assertEquals(2, day.getVariables().size());
        ValuesVariable variable = (ValuesVariable) day.getVariables().get(0);
        assertEquals("sky_state", variable.getName());
        assertEquals("WRF", variable.getModel());
        assertEquals("04km", variable.getGrid());
        assertNotNull(variable.getValues());
        assertEquals(5, variable.getValues().size());
        Value value = variable.getValues().get(0);
        assertEquals(1550228400000L, value.getTimeInstant().getTime());
        assertEquals("SUNNY", value.getValue());
        assertEquals("http://servizos.meteogalicia.es:80/apiv3/images/weather/sky-state/day/despexado.png", value.getIconURL());
    }

    @Test
    public void findByLocationIdTest() {
        Result result =
                numericForecastInfoClient.findByLocationId("42917", "sky_state,temperature", "API_KEY");
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
        assertEquals(1550230208000L, timePeriod.getBegin().getTimeInstant().getTime());
        assertNotNull(timePeriod.getEnd());
        assertNotNull(timePeriod.getEnd().getTimeInstant());
        assertEquals(1550271599000L, timePeriod.getEnd().getTimeInstant().getTime());
        assertNotNull(day.getVariables());
        assertEquals(2, day.getVariables().size());
        ValuesVariable variable = (ValuesVariable) day.getVariables().get(0);
        assertEquals("sky_state", variable.getName());
        assertEquals("WRF", variable.getModel());
        assertEquals("04km", variable.getGrid());
        assertNotNull(variable.getValues());
        assertEquals(11, variable.getValues().size());
        Value value = variable.getValues().get(0);
        assertEquals(1550232000000L, value.getTimeInstant().getTime());
        assertEquals("HIGH_CLOUDS", value.getValue());
        assertEquals("http://servizos.meteogalicia.es:80/apiv3/images/weather/sky-state/day/nubesaltas.png", value.getIconURL());
    }

    @Test
    public void findByLocationIdInTimeRangeTest() {
        Result result =
                numericForecastInfoClient.findByLocationIdInTimeRange("42917", "sky_state,temperature",
                        "2019-02-15T12:00:00", "2019-02-15T16:00:00", "API_KEY");
        assertNotNull(result);
        assertNotNull(result.getFeatures());
        assertEquals(1, result.getFeatures().size());
        Feature feature = (Feature) result.getFeatures().get(0);
        assertNotNull(feature.getProperties());
        DaysProperties properties = (DaysProperties) feature.getProperties();
        assertNotNull(properties.getDays());
        assertEquals(1, properties.getDays().size());
        Day day = (Day) properties.getDays().get(0);
        assertNotNull(day.getTimePeriod());
        TimePeriod timePeriod = day.getTimePeriod();
        assertNotNull(timePeriod.getBegin());
        assertNotNull(timePeriod.getBegin().getTimeInstant());
        assertEquals(1550228400000L, timePeriod.getBegin().getTimeInstant().getTime());
        assertNotNull(timePeriod.getEnd());
        assertNotNull(timePeriod.getEnd().getTimeInstant());
        assertEquals(1550242800000L, timePeriod.getEnd().getTimeInstant().getTime());
        assertNotNull(day.getVariables());
        assertEquals(2, day.getVariables().size());
        ValuesVariable variable = (ValuesVariable) day.getVariables().get(0);
        assertEquals("sky_state", variable.getName());
        assertEquals("WRF", variable.getModel());
        assertEquals("04km", variable.getGrid());
        assertNotNull(variable.getValues());
        assertEquals(5, variable.getValues().size());
        Value value = variable.getValues().get(0);
        assertEquals(1550228400000L, value.getTimeInstant().getTime());
        assertEquals("HIGH_CLOUDS", value.getValue());
        assertEquals("http://servizos.meteogalicia.es:80/apiv3/images/weather/sky-state/day/nubesaltas.png", value.getIconURL());
    }
}
