package com.sakila.models;

import java.sql.Date;
 
public class Rental {
    private int rental_Id;
    private Date rental_date;
    private int inventory_id;
    private int customer_id;
    private Date return_date;
    private int staff_id;
    private Date last_update;

    public Rental(int rental_Id, Date rental_date, int inventory_id, int customer_id, Date return_date, int staff_id, Date last_update) {
        this.rental_Id = rental_Id;
        this.rental_date = rental_date;
        this.inventory_id = inventory_id;
        this.customer_id = customer_id;
        this.return_date = return_date;
        this.staff_id = staff_id;
        this.last_update = last_update;
    }

    // Getters and setters
    public int getRentalId() {
        return rental_Id;
    }

    public void setRentalId(int rentalId) {
        this.rental_Id = rentalId;
    }

    public Date getRentalDate() {
        return rental_date;
    }

    public void setRentalDate(Date rentalDate) {
        this.rental_date = rentalDate;
    }

    public int getInventoryId() {
        return inventory_id;
    }

    public void setInventoryId(int inventoryId) {
        this.inventory_id = inventoryId;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customerId) {
        this.customer_id = customerId;
    }

    public Date getReturnDate() {
        return return_date;
    }

    public void setReturnDate(Date returnDate) {
        this.return_date = returnDate;
    }

    public int getStaffId() {
        return staff_id;
    }

    public void setStaffId(int staffId) {
        this.staff_id = staffId;
    }

    public Date getLastUpdate() {
        return last_update;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.last_update = lastUpdate;
    }
}
