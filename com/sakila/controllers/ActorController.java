package com.sakila.controllers;

import com.sakila.models.Actor;
import com.sakila.data.Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ActorController {
    public void createActor(Actor actor) {
        String sql = "INSERT INTO actor (actor_id, first_name, last_name) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, actor.getId());
            pstmt.setString(2, actor.getFirstName());
            pstmt.setString(3, actor.getLastName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Actor readActor(int id) {
        String sql = "SELECT * FROM actor WHERE actor_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateActor(Actor actor) {
        String sql = "UPDATE actor  SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, actor.getFirstName());
            pstmt.setString(2, actor.getLastName());
            pstmt.setInt(3, actor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(int id) {
        String sql = "DELETE FROM actor  WHERE actor_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Actor> listActors() {
        Map<Integer, Actor> actors = new HashMap<>();
        String sql = "SELECT * FROM actor ";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Actor actor = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
                actors.put(actor.getId(), actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }
}
