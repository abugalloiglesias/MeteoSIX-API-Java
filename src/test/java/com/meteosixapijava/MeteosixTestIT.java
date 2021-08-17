package com.meteosixapijava;

import com.meteosixapijava.model.NumericForecastInfoParams;
import com.meteosixapijava.model.VariableType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MeteosixTestIT {

    private Meteosix meteosix;

    @Before
    public void setup() throws IOException {
        meteosix = new Meteosix("XPk5364oe4543J0qI5sD849eOR4byVL3tQff18k3Faf7aG2SCRip3roVl9fEnznF");
    }

    @Test
    public void getSolarInfoInterfaceFindTest() {
        assertEquals(meteosix.getSolarInfoInterface().find(43.362343, -8.411540).getFeatures().size(), 1);
    }

    @Test
    public void getPlaceInterfaceFindTest() {
        assertEquals(meteosix.getPlaceInterface().find("betanzos").getFeatures().size(), 3);
    }

    @Test
    public void getNumericForecastInfoInterfaceFindByCoordsTest() {
        NumericForecastInfoParams params = new NumericForecastInfoParams();
        params.setLatitude("44");
        params.setLongitude("-8");
        params.setVariableList(Arrays.asList(VariableType.sky_state, VariableType.temperature));
        assertEquals(meteosix.getNumericForecastInfoInterface().findByCoords(44d, -8d,
                Arrays.asList(VariableType.sky_state, VariableType.temperature), null, null).getFeatures().size(), 1);
    }

}
