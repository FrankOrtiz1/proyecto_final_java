package com.sakila.controllers;

 
import com.sakila.models.Film;
import com.sakila.data.Database;
import java.util.Map;

import java.sql.*;
import java.util.HashMap;


public class FilmController {
    public void createFilm(Film film) {
        String sql = "INSERT INTO film (film_id, title, description, release_year, language_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, film.getId());
            pstmt.setString(2, film.getTitle());
            pstmt.setString(3, film.getDescription());
            pstmt.setInt(4, film.getReleaseYear());
            pstmt.setInt(5, film.getLanguage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Film readFilm(int id) {
        String sql = "SELECT * FROM film WHERE film_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getInt("release_year"),rs.getInt("language_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateFilm(Film film) {
        String sql = "UPDATE film SET title = ?, description = ?, release_year = ? , language_id = ? WHERE film_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, film.getTitle());
            pstmt.setString(2, film.getDescription());
            pstmt.setInt(3, film.getReleaseYear());
            pstmt.setInt(4, film.getId());
            pstmt.setInt(5, film.getLanguage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFilm(int id) {
        String sql = "DELETE FROM film WHERE film_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Film> listFilms() {
        Map<Integer, Film> films = new HashMap<>();
        String sql = "SELECT * FROM film";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Film film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"), rs.getInt("release_year"),rs.getInt("language_id"));
                films.put(film.getId(), film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}
