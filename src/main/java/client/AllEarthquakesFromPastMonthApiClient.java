package client;

import static configuration.DataSource.ALL_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT;

public class AllEarthquakesFromPastMonthApiClient extends EarthquakesApiClient {
    @Override
    public String getEarthquakesURLEndpoint() {
        return ALL_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT;
    }
}
