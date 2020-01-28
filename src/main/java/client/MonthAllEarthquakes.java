package client;

import static configuration.DataSource.MONTH_ALL_EARTHQUAKES_URL;

public class MonthAllEarthquakes extends EarthquakesApiClient {
    @Override
    public String getEarthquakesURLEndpoint() {
        return MONTH_ALL_EARTHQUAKES_URL;
    }
}
