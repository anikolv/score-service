Running the application from source code (requires java): 
-------------

mvnw spring-boot:run

OR

mvnw clean package

java -jar target/score-service-1.0.0.jar

Endpoints:
-------------

POST http://localhost:8080/score-service/api/scoreboard/set
```json
{
        "userId": "1",
        "points": "20"
}
```

GET http://localhost:8080/score-service/api/scoreboard/get?userId=1

GET http://localhost:8080/score-service/api/scoreboard/getAll
