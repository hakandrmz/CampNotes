package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> cities = new ArrayList<>();

    public static List getCities(){

        cities.add("Bursa");
        cities.add("Çanakkale");
        cities.add("Kırklareli");
        cities.add("Kocaeli");
        cities.add("Tekirdağ");

        return cities;
    }

    public static void main( String[] args ) {

        List<String> myPlaces = getCities();
        System.out.println("K ile başlayan Marmara'daki iller:");

        myPlaces.stream()
                .filter((p) -> p.startsWith("K"))
                .map((p) -> p.toUpperCase())
                .sorted()
                .forEach((p) -> System.out.println(p));
    }

}