package org.example.classes;

import java.util.Date;
import org.example.interfaces.IDisk;
import org.example.Type;

/**
 * The Games class extends Disk and implements the IDisk interface.
 */
public class Games extends Disk implements IDisk {

    /**
     * The constructor for Games class
     * @param name the name of the game
     * @param inventoryDate the date the game was added to the inventory
     * @param rating the rating of the game
     */
    public Games(String name, Date inventoryDate, int rating){
        super(name, inventoryDate, rating, Type.GAME);
    }

    /**
     * Method to get type of the disk
     * @return the disk type
     */
    @Override
    public Type getType() {
        return this.type;
    }

    /**
     * Method to get name of the disk
     * @return the string with name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Method to get the inventory date
     * @return the date the game was added to the inventory
     */
    @Override
    public Date getInventoryDate() {
        return this.inventoryDate;
    }

    /**
     * Method to get rating of the disk
     * @return numerical representation of rating
     */
    @Override
    public int getRating() {
        return this.rating;
    }
}