package com.meteosixapijava;

import com.meteosixapijava.model.NumericForecastInfoParams;
import com.meteosixapijava.model.Result;
import com.meteosixapijava.model.VariableType;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Meteosix meteosix = new Meteosix("XPk5364oe4543J0qI5sD849eOR4byVL3tQff18k3Faf7aG2SCRip3roVl9fEnznF");

        Result solarInfo = meteosix.getSolarInfoInterface().find(43.362343, -8.411540);

        Result resultPlace = meteosix.getPlaceInterface().find("betanzos");
        NumericForecastInfoParams params = new NumericForecastInfoParams();
        params.setLatitude("44");
        params.setLongitude("-8");
        params.setVariableList(Arrays.asList(VariableType.sky_state, VariableType.temperature));
        Result resultNumericForecastInfo = meteosix.getNumericForecastInfoInterface().findByCoords(
                44d, -8d, Arrays.asList(VariableType.sky_state, VariableType.temperature), null, null);
    }
}
