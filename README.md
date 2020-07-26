# price-engine-app
Spring boot and React js implemetation of a simple price engine service
- Calculate prices for dfferent items for given number of units
- Simple amount calculator for items
- All calculations are done in server side
- Price list for 1 -50 units displayed in UI
- Dockerfile to run the project

# Installation
**Note**: This is developed on java 8, node v12.14.0 and npm 6.13.4
## Run price-engine
1. Clone the project
2. Use `./gradlew build` to install the dependencies.
3. Run `java -jar build/libs/price-engine-0.0.1-SNAPSHOT.jar` to launch the service. Service will listen on 9090 port 
## Run price-engine-ui
1. cd into price-list-ui
2. Use `npm install` to install the dependencies.
3. Run `npm start` to launch the app. This should open your browser. If not, open http://localhost:3000.
## Run price-engine as an application
1. Clone the project
2. cd into price-list-ui
3. Use `npm install` to install the dependencies.
4. Use `npm run release` to build the application and copy to service's resource directory
5. cd back to root dir of the project
6. Use `./gradlew build` to install the dependencies.
7. Run `java -jar build/libs/price-engine-0.0.1-SNAPSHOT.jar` to launch the service. Service will listen on 9090 port 
8. Go to `http://localhost:9090/`

Requires postgres db running on the application server host listening to 5432. Or change value for spring.datasource.url in application properties as you like

## Tests
Run `./gradlew test`

## Get the image from docker hub

## API

### GET /v1/items


```json
[
{"name":"Penguin-ears","itemsPerCarton":20,"priceOfACarton":175.0,"priceOfAUnit":11.375},
{"name":"Horseshoe","itemsPerCarton":5,"priceOfACarton":825.0,"priceOfAUnit":214.5}
]
```

### GET /v1/items/{name}/price?start={start}&end={end}

#### Request

Request
```
/v1/items/Penguin-ears/price?start=1&end=10
```

Response
```json
[
11.375,
22.75,
34.125,
45.5,
56.875,
68.25,
79.625,
91,
102.375,
113.75
]
```
### GET /v1/items/{name}/price/{units}
Request
```
/v1/items/Penguin-ears/price/3
```
Response
```json
34.125
```
