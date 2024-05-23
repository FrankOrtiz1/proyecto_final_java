package com.sakila.controllers;

import com.sakila.models.Customer;
import com.sakila.data.Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerController {

   
    public void createCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (customer_id, store_id, first_name, last_name, address_id, create_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customer.getCustomerId()); // Assuming customer_id is auto-generated
            pstmt.setInt(2, customer.getStoreId());
            pstmt.setString(3, customer.getFirstName());
            pstmt.setString(4, customer.getLastName());
            pstmt.setInt(5, customer.getAddressId());
            pstmt.setDate(6, new java.sql.Date(customer.getCreateDate().getTime())); // Convert to SQL Date
            pstmt.executeUpdate();
        }
    }

 
    public Customer readCustomer(int id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("customer_id"),
                        rs.getInt("store_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("address_id"),
                        rs.getDate("create_date")
                );
            }
        }
        return null;
    }

  
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, address_id = ? WHERE customer_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customer.getStoreId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setInt(4, customer.getAddressId());
            pstmt.setInt(5, customer.getCustomerId());
            pstmt.executeUpdate();
        }
    }

    
    public void deleteCustomer(int customer_id) throws SQLException {
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customer_id);
            pstmt.executeUpdate();
        }
    }

  
    public Map<Integer, Customer> listCustomers() throws SQLException {
        Map<Integer, Customer> customers = new HashMap<>();
        String sql = "SELECT * FROM customer";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getInt("store_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("address_id"),
                        rs.getDate("create_date")
                );
                customers.put(customer.getCustomerId(), customer);
            }
        }
        return customers;
    }
}