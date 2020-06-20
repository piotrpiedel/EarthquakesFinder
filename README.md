# Earthquakes finder

Program shows the nearest earthquakes from past month for given coordinates.
Earthquakes are sort by distance to given point and filtered from duplicates by place.

Application uses API to fetch earthquakes:
https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php

# App requirements
1. JAVA_HOME variable should be provided to run program;
2. Import project to your IDE and run.
3. Lombok plugin is required to properly display code.
4. Required java - 1.8;

# Java version and libraries 
Application is written using Java 8.
Libraries used in project:
- [GeoJson POJOs for Jackson](https://github.com/opendatalab-de/geojson-jackson) [1.12]
- [Jackson](https://github.com/FasterXML/jackson)
- [Lombok](https://github.com/rzwitserloot/lombok)
- [JUnit](https://junit.org/junit4/)
- [Log4j](https://logging.apache.org/log4j/2.x/)



# Short example how to use application:
1. Start program.
2. Application will print to console request:
"Enter latitude value from range [-90.0, 90.0]"
3. Provide correct coordinate value, eg. 50.049683 for Cracow 
4. Application will print to console request: 
"Enter longitude value from range [-180.0,180.0]".
5. Provide correct coordinate value, eg. 19.944544 for Cracow
5. Application will print to console request: 
"Enter number of earthquakes to display". eg. 15
6. Provide number of earthquakes to display, eg. 15
7. Program will execute request to API, sort value and print to console. <br>
"Ten nearest earthquakes from last month to given coordinates <br>
Magnitude - place (Direction from the nearest city, country) || Distance to coordinates <br>
M 3.0 - 5 km NNW of Dubrava, Croatia || 546.995633974797
....."
8. "Write q to exit program and press enter. Leave empty and press enter to continue"


