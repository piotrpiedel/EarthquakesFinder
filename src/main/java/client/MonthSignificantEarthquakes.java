package client;

import static configuration.DataSource.MONTH_SIGNIFICANT_EARTHQUAKES_URL;

public class MonthSignificantEarthquakes extends EarthquakesApiClient {
    @Override
    public String getEarthquakesURLEndpoint() {
        return MONTH_SIGNIFICANT_EARTHQUAKES_URL;
    }
}
