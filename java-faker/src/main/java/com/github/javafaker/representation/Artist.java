package com.github.javafaker.representation;

public class Artist {

    private final Faker faker;

    protected Artist(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return faker.fakeValuesService().fetchString("artist.names");
    }
}
