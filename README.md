# MeteoSIX-API-Java
## Introduction
This is a Java API which wraps the [MeteoSIX](https://www.meteogalicia.gal/web/proxectos/meteosix.action) API.
## Usage
To use the API just construct an instance of the class com.meteosixapijava.Meteosix and request the interfaces which you need to work with.
For example, to get the solar info for an specific location:
```
Meteosix meteosix = new Meteosix("YOUR_API_KEY");
Result solarInfo = meteosix.getSolarInfoInterface().find(LATITUDE, LONGITUDE);
```
To find a place by its name:
```
Meteosix meteosix = new Meteosix("YOUR_API_KEY");
Result resultPlace = meteosix.getPlaceInterface().find("PLACE_NAME");
```
To get the forecast for a specific location (variables sky state and temperature):
```
Meteosix meteosix = new Meteosix("YOUR_API_KEY");
NumericForecastInfoParams params = new NumericForecastInfoParams();
params.setLatitude("LATITUDE");
params.setLongitude("LONGITUDE");
params.setVariableList(Arrays.asList(VariableType.sky_state, VariableType.temperature));
Result resultNumericForecastInfo = meteosix.getNumericForecastInfoInterface().findByCoords(44d, -8d, Arrays.asList(VariableType.sky_state, VariableType.temperature), null, null);
```
