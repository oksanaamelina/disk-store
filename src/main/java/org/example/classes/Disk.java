package org.example.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.example.Type;

/**
 * Represents an abstract Disk class with name, inventory date, rating and type
 */
public abstract class Disk {

    /** The name of the disk */
    protected String name;

    /** The date the disk was added to the inventory*/
    protected Date inventoryDate;

    /** The type of the disk */
    protected int rating;

    /** The rating of the disk*/
    protected Type type;

    /**
     * The constructor for Disk class
     * @param name the name of the disk
     * @param inventoryDate the date the disk was added to the inventory
     * @param rating the rating of the disk
     * @param type the type of disk
     */
    public Disk(String name, Date inventoryDate, int rating, Type type) {
        this.name = name;
        this.inventoryDate = validateDate(inventoryDate);
        this.rating = validateRating(rating);
        this.type = type;
    }

    /**
     * Method to validate date before using in constructor
     * @param date the date to validate
     * @return the date for constructor
     */
    private Date validateDate(Date date) {
        if (date.after(new Date())) {
            throw new IllegalArgumentException("Inventory date cannot be in the future.");
        }
        return date;
    }

    /**
     * Method to validate integer value for rating
     * @param rating number to check
     * @return the number for constructor
     */
    private int validateRating(int rating) {
        if (rating < 0) {
            throw new IllegalArgumentException("Rating cannot be negative.");
        }
        return rating;
    }


    /** Method to get all information about disk
     * @return the string with disk information
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Disk with type: " + type + ", name: '" + name + '\'' + ", inventoryDate: " + formatter.format(inventoryDate) + ", rating: " + rating;
    }
}
