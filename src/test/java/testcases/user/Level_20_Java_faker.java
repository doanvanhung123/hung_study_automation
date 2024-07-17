package testcases.user;

import actions.commons.BaseTest;

import com.github.javafaker.Faker;


public class Level_20_Java_faker extends BaseTest {


    public static void main(String[] args) {
        Faker faker = new Faker();
        faker.business().creditCardType();
    }
}
