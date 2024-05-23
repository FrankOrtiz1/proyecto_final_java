package com.sakila.util;

import com.google.gson.Gson;
import com.sakila.models.Film;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

 
public class JsonExporter {
    public static void exportToJson(List<Film> films, String filename) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(films, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
