package com.sakila.controllers;

import com.sakila.models.Rental;
import com.sakila.data.Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RentalController {
    public void createRental(Rental rental) {
        String sql = "INSERT INTO rental (rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rental.getRentalId());
            pstmt.setDate(2, rental.getRentalDate());
            pstmt.setInt(3, rental.getInventoryId());
            pstmt.setInt(4, rental.getCustomerId());
            pstmt.setDate(5, rental.getReturnDate());
            pstmt.setInt(6, rental.getStaffId());
            pstmt.setDate(7, rental.getLastUpdate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Rental readRental(int rentalId) {
        String sql = "SELECT * FROM rental WHERE rental_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Rental(
                        rs.getInt("rental_id"),
                        rs.getDate("rental_date"),
                        rs.getInt("inventory_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("return_date"),
                        rs.getInt("staff_id"),
                        rs.getDate("last_update")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRental(Rental rental) {
        String sql = "UPDATE rental SET rental_date = ?, inventory_id = ?, customer_id = ?, return_date = ?, staff_id = ?, last_update = ? WHERE rental_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, rental.getRentalDate());
            pstmt.setInt(2, rental.getInventoryId());
            pstmt.setInt(3, rental.getCustomerId());
            pstmt.setDate(4, rental.getReturnDate());
            pstmt.setInt(5, rental.getStaffId());
            pstmt.setDate(6, rental.getLastUpdate());
            pstmt.setInt(7, rental.getRentalId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRental(int rentalId) {
        String sql = "DELETE FROM rental WHERE rental_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rentalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Rental> listRentals() {
        Map<Integer, Rental> rentals = new HashMap<>();
        String sql = "SELECT * FROM rental";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Rental rental = new Rental(
                        rs.getInt("rental_id"),
                        rs.getDate("rental_date"),
                        rs.getInt("inventory_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("return_date"),
                        rs.getInt("staff_id"),
                        rs.getDate("last_update")
                );
                rentals.put(rental.getRentalId(), rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }
}
