package client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.net.URL;

public abstract class EarthquakesApiClient {
    protected abstract String getEarthquakesURLEndpoint();

    public FeatureCollection getEarthquakes() {
        FeatureCollection featureCollection = null;
        try {
            featureCollection = new ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readValue(new URL(getEarthquakesURLEndpoint()), FeatureCollection.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureCollection;
    }
}
