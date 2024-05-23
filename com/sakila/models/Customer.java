package com.sakila.models;

import java.util.Date;

public class Customer {

    // Corrected field names and types based on likely database schema
    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private int address_id;
    private Date create_date;
    private int active;

    // Updated constructor to match field names and remove unnecessary parameters
    public Customer(int customerId, int storeId, String firstName, String lastName,
                     int addressId, Date createDate) {

        this.customer_id = customerId;
        this.store_id = storeId;
        this.first_name = firstName;
        this.last_name = lastName;
        this.address_id = addressId;
        this.create_date = createDate;
        
    }

    // Getters and setters (assuming standard Java naming conventions)
    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customerId) {
        this.customer_id = customerId;
    }

    public int getStoreId() {
        return store_id;
    }

    public void setStoreId(int storeId) {
        this.store_id = storeId;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name =  lastName;
    }

    public int getAddressId() {
        return address_id;
    }

    public void setAddressId(int addressId) {
        this.address_id = addressId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return create_date;
    }

    public void setCreateDate(Date createDate) {
        this.create_date = createDate;
    }
}