package com.c1ctech.pagingexampleusingroom.db;

import com.c1ctech.pagingexampleusingroom.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseCreater {

    private String[] countryName = new String[]{"Afghanistan", "Albania", "Bahamas", "Bahrain", "Cambodia", "Cameroon", "Denmark", "Dominica", "Egypt",
            "Eritrea", "Figi", "France", "Gabon", "Georgia", "Hungary", "India", "Jamaica", "Lebanon", "Vietnam", "Uzbekistan"};



    public List<Country> getRandomCountryList() {
        List<Country> countries = new ArrayList<>();
        int countryRange = countryName.length;
        Country country;

        Random random = new Random();
        for (int i = 1; i <= 250; i++) {

            country = new Country();
            country.countryName = countryName[random.nextInt(countryRange)];


            countries.add(country);
        }
        return countries;
    }
}
