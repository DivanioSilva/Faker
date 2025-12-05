package com.github.javafaker;

public class Vehicle {
    private final Faker faker;

    protected Vehicle(final Faker faker) {
        this.faker = faker;
    }

    public String manufacture() {
        return faker.resolve("vehicle.manufacture");
    }

    public String makes() {
        return faker.resolve("vehicle.makes");
    }

    public String colors() {
        return faker.resolve("vehicle.colors");
    }

    public String transmissions() {
        return faker.resolve("vehicle.transmissions");
    }

    public String drive_types() {
        return faker.resolve("vehicle.drive_types");
    }

    public String fuel_types() {
        return faker.resolve("vehicle.fuel_types");
    }

    public String styles() {
        return faker.resolve("vehicle.styles");
    }

    public String car_types() {
        return faker.resolve("vehicle.car_types");
    }

    public String car_options() {
        return faker.resolve("vehicle.car_options");
    }

    public String standard_specs() {
        return faker.resolve("vehicle.standard_specs");
    }

    public String doors() {
        return faker.resolve("vehicle.doors");
    }

    public String engine_sizes() {
        return faker.resolve("vehicle.engine_sizes");
    }

    public String license_plate() {
        return faker.bothify(faker.resolve("vehicle.license_plate"));
    }

    public String cylinder_engine() {
        return faker.resolve("vehicle.cylinder_engine");
    }
}
