# Getting Started

Thi project is a playground project to demonstrate how to Test a Spring Kafka Consumer App with Gatling.

## Approach

Gatling will produce a plethora of events. These events are by the microservice running in the local machine.
The microservice produces Prometheus metrics. These metrics help us study how the app behaves.

## Project Structure

__app__: Simulates a microservice with a Kafka consumer.
__app-avro-schemas__: project that holds Avro schemas and generates the java classes with Avro-plugin
__app-gatling-test__: Performance Tests
__local-setup__: Docker-based configuration to start Kafka, Prometheus and Grafana.


## Run the app.

1. Compile the code and generate schemas. From root:
    ```sh
    mvn clean install
    ```
3. Start Kafka, Prometheus, Grafana. From local-setup:
    ```sh
    docker-compose up -d
    ```
4. Start microservice, from app:
    ```sh
    mvn spring-boot:run
    ```

5. Run Gatling Test, from app-gatling-test
    ```sh
    mvn gatling:test
    ```

## Grafana

Grafana is available [here](http://localhost:3000)

user: admin
password: admin

## Prometheus

Prometheus is available [here](http://localhost:9090)
