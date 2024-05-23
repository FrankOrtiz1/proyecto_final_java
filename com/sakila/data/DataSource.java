package com.sakila.data;

import com.sakila.models.*;

import java.util.HashMap;
import java.util.Map;

 
public class DataSource {
    private static Map<Integer, Film> films = new HashMap<>();
    private static Map<Integer, Actor> actors = new HashMap<>();
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static Map<Integer, Rental> rentals = new HashMap<>();

    // Métodos para acceder a los datos simulados
    public static Map<Integer, Film> getFilms() {
        return films;
    }

    public static Map<Integer, Actor> getActors() {
        return actors;
    }

    public static Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public static Map<Integer, Rental> getRentals() {
        return rentals;
    }
}
