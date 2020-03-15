package configuration;

public class DataSource {
    public static final String EARTHQUAKES_API_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/";
    public static final String ALL_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT = EARTHQUAKES_API_URL + "summary/all_month.geojson";
    public static final String ALL_SIGNIFICANT_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT = EARTHQUAKES_API_URL + "summary/significant_month.geojson";

    private DataSource() {
        throw new IllegalStateException("Configuration class");
    }

}
