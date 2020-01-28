import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static configuration.DataSource.MONTHS_ALL_URL;

public class Main {
    public static void main(String[] args) throws IOException {

        URL allMonthsUrl = null;
        try {
            allMonthsUrl = new URL(MONTHS_ALL_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            FeatureCollection featureCollection =
                    new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(allMonthsUrl, FeatureCollection.class);
            featureCollection.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

