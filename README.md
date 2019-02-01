# HERE MAPS DEMO APPLICATION

This project aims to consume Here's Traffic API. We've been told that API follows OAUTH2 standard.

### Documentation
Base documentation of Here's Traffic Rest API can be found [here](https://developer.here.com/documentation/traffic/topics/what-is.html).

### Rest API
Base URL is `https://data.traffic.api.here.com/` and we're trying to consume the following Rest Methods (please, see HereMethods.java): 
* [HTTP GET] datex/2.3/flow/content.xml
* [HTTP GET] datex/2.3/incident/content.xml 

### What's working
Currently we're able to make request to Here's Traffic Rest API.

### What it isn't working
Everything seems correct right now.

### Before getting hands on
You should make a copy of IngartekConsulting.properties.sample file and edit every property within. The resulting name of the file should be IngartekConsulting.properties. Otherwise, edit HereConfig.java file.

### Running the App
We're developing that project in Eclipse, in its latest stable version. Simply run HereMapsDemoApplication.java file as a Spring Boot app.

### Building JAR
Place yourself in the root and type in your terminal `$ mvn clean package -DskipTests`. Afterwards, move to `target` directory and run it that way `java -jar ./HereMapsDemo-1.0.0-SNAPSHOT.jar`.