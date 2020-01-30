package configuration;

public class DataSource {

    private DataSource() {
        throw new IllegalStateException("Configuration class");
    }

    public static final String EARTHQUAKES_API_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/";
    public static final String MONTH_ALL_EARTHQUAKES_URL = EARTHQUAKES_API_URL + "summary/all_month.geojson";
    public static final String MONTH_SIGNIFICANT_EARTHQUAKES_URL = EARTHQUAKES_API_URL + "summary/significant_month.geojson";
}
