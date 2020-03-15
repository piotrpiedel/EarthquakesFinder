package client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public abstract class EarthquakesApiClient {

    protected abstract String getEarthquakesURLEndpoint();

    public List<Feature> getFeaturesFromEndpoint() throws IOException {
        List<Feature> featureList = null;
        try {
            featureList = new ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readValue(new URL(getEarthquakesURLEndpoint()), FeatureCollection.class)
                    .getFeatures();

        } catch (IOException e) {
            System.out.println("Given endpoint is not correct");
            throw e;
        }

        return featureList;
    }
}
