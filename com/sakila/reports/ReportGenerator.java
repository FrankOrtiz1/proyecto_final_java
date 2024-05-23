package com.sakila.reports;

import com.sakila.models.Film;
import com.sakila.controllers.FilmController;
import com.sakila.util.CsvExporter;
import com.sakila.util.JsonExporter;

import java.util.List;
import java.util.ArrayList;

/**
 * Genera reportes y exporta datos a CSV y JSON.
 * Derechos de autor 2024.
 */
public class ReportGenerator {
    private FilmController filmController;

    public ReportGenerator(FilmController filmController) {
        this.filmController = filmController;
    }

    public void generateFilmReport() {
        List<Film> films = new ArrayList<>(filmController.listFilms().values());
        CsvExporter.exportToCsv(films, "films.csv");
        JsonExporter.exportToJson(films, "films.json");
    }

    // Otros métodos según sea necesario
}
