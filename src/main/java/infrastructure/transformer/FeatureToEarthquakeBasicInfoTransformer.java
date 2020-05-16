package infrastructure.transformer;

import domain.model.EarthquakeBasicInfo;
import org.geojson.Feature;
import org.geojson.Point;

import java.util.List;
import java.util.stream.Collectors;

public class FeatureToEarthquakeBasicInfoTransformer {
    PointToCoordinatesTransformer pointToCoordinatesTransformer = new PointToCoordinatesTransformer();

    public List<EarthquakeBasicInfo> map(List<Feature> featureList) {
        return featureList
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }


    public EarthquakeBasicInfo map(Feature feature) {
        return new EarthquakeBasicInfo(feature.getProperty("title"),
                pointToCoordinatesTransformer.map((Point) feature.getGeometry()));
    }
}
