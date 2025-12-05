package com.github.javafaker.app;

import au.com.anthonybruno.Gen;
import com.github.javafaker.representation.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = Faker.instance();
        Gen.start()
                .addField("username",() -> faker.name().username())
                .addField("firstName",() -> faker.name().firstName())
                .addField("lastName",() -> faker.name().lastName())
                .addField("Age", () -> faker.number().numberBetween(18, 30))
                .addField("email", () -> faker.internet().emailAddress())
                .generate(1000)
                .asCsv()
                .toFile("teste.csv");
    }
}
