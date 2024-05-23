package com.sakila.util;

import com.sakila.models.Film;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

 
public class CsvExporter {
    public static void exportToCsv(List<Film> films, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("ID,Title,Description,ReleaseYear\n");
            for (Film film : films) {
                writer.append(String.valueOf(film.getId())).append(",")
                      .append(film.getTitle()).append(",")
                      .append(film.getDescription()).append(",")
                      .append(String.valueOf(film.getReleaseYear())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
