package infrastructure.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.exception.IncorrectEndpoint;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static application.configuration.DataSource.ALL_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT;

public class EarthquakesApiClient {

    public List<Feature> getFeaturesFromEndpoint(String earthquakesEndpointUrl) throws IncorrectEndpoint {
        List<Feature> featureList;
        try {
            featureList = new ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readValue(new URL(earthquakesEndpointUrl), FeatureCollection.class)
                    .getFeatures();

        } catch (IOException e) {
            System.out.println("Given endpoint is not correct");
            throw new IncorrectEndpoint("Given endpoint is not correct");
        }

        return featureList;
    }

    public List<Feature> getAllEarthquakesFromPastMonthApiClient() throws IncorrectEndpoint {
        return getFeaturesFromEndpoint(ALL_EARTHQUAKES_FROM_PAST_MONTH_ENDPOINT);
    }
}