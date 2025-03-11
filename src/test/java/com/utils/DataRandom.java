package com.utils;

import net.datafaker.Faker;

public class DataRandom {
    public String getName(){
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public String getEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String getAddress(){
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }
}
