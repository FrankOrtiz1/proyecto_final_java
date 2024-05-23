package com.sakila.reports;

import com.sakila.models.Film;
import com.sakila.models.Rental;
import com.sakila.controllers.FilmController;
import com.sakila.controllers.RentalController;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Calcula estadísticas específicas del sistema.
 * Derechos de autor 2024.
 */
public class Statistics {
    private FilmController filmController;
    private RentalController rentalController;

    public Statistics(FilmController filmController, RentalController rentalController) {
        this.filmController = filmController;
        this.rentalController = rentalController;
    }

    public int totalFilms() {
        return filmController.listFilms().size();
    }

    public double averageFilmReleaseYear() {
        List<Film> films = new ArrayList<>(filmController.listFilms().values());
        return films.stream().mapToInt(Film::getReleaseYear).average().orElse(0);
    }

    public int rentalsAging(Date date) {
        List<Rental> rentals = new ArrayList<>(rentalController.listRentals().values());
        return (int) rentals.stream().filter(r -> r.getRentalDate().before(date)).count();
    }

    // Otros métodos según sea necesario
}
