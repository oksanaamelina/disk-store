package org.example.classes;

import org.example.Type;
import org.example.interfaces.IDisk;
import org.example.interfaces.IStorage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a Storage class for all computer disks. Implements IStorage interface
 */
public class Storage implements IStorage {

    /** Storage variable     */
    private List<IDisk> storage = new ArrayList<>();

    /**
     * Method to add disk to the storage
     * @param disk the disk to add
     */
    @Override
    public void add(IDisk disk) {
        storage.add(disk);
    }

    /**
     * Method to get all disks
     * @return list of IDisk type with all disks
     */
    @Override
    public List<IDisk> getAll(){
        if(storage.isEmpty()){
            throw new RuntimeException("The storage is empty. Please fill it.");
        }
        return storage;
    }

    /**
     * Method to get a disk by its name
     * @param name the search disk name
     * @return the searched disk
     */
    @Override
    public IDisk getBy(String name) {
        return storage.stream()
                .filter(disk -> disk.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No disk found with name: " + name));
    }

    /**
     * Method to get a collection of disks by type
     * @param type the search type
     * @return the list of searched disks
     */
    @Override
    public List<IDisk> getAllBy(Type type) {
        List<IDisk> resultList = storage.stream()
                .filter(disk -> disk.getType().equals(type))
                .collect(Collectors.toList());

        if (resultList.isEmpty()){
            throw new RuntimeException("We don't have any disk with this type");
        }
        return resultList;
    }

    /**
     * Method to get a collection of disks by rating
     * @param rating the number of search rating
     * @return the list of searched disks
     */
    @Override
    public List<IDisk> getAllBy(int rating) {
        if (rating < 0){
            throw new IllegalArgumentException("You entered a negative number for disk rating");
        }

        List<IDisk> resultList = storage.stream()
                .filter(disk -> disk.getRating() == rating)
                .collect(Collectors.toList());

        if (resultList.isEmpty()){
            throw new RuntimeException("We don't have any disk with this rating");
        }
        return resultList;
    }

    /**
     * Method to check if disk with search type exists in storage
     * @param type the search disk type
     * @return the boolean result
     */
    @Override
    public boolean isExistedBy(Type type) {
        try{
            getAllBy(type);
        } catch (RuntimeException e){
            return  false;
        }
        return true;
    }

    /**
     * Method to check if disk with search name exists in storage
     * @param name the search disk name
     * @return the boolean result
     */
    @Override
    public boolean isExistedBy(String name) {
        try {
            getBy(name);
        } catch (RuntimeException e){
            return false;
        }
        return true;
    }

    /**
     * Get a collection of disks by year of inventory date
     * @param year the search inventory year
     * @return  the list of searched disks
     */
    @Override
    public List<IDisk> getAllBy(String year) {
        int yearFromParam = 0;
        try {
            yearFromParam = Integer.parseInt(year);
        } catch (NumberFormatException e){
            e.getMessage();
        }

        List<IDisk> resultList = new ArrayList<>();
        for (var disk : storage) {
            if ((1900 + disk.getInventoryDate().getYear()) == yearFromParam){
                resultList.add(disk);
            }
        }
        if (resultList.isEmpty()){
            throw new RuntimeException("We don't have any disk with this inventory date");
        }
        return resultList;
    }

    /**
     * Method to fill data to the storage
     * @param store the empty storage
     */
    public static void fillData(Storage store){
        store.storage.add(new Movies("Gentlemen Prefer Blondes", new Date(120, 7, 10), 8));
        store.storage.add(new Movies("Moscow Does Not Believe in Tears", new Date(100, 8, 12), 9));
        store.storage.add(new Movies("Office Romance", new Date(115, 2, 30), 8));
        store.storage.add(new Movies("The Diamond Arm", new Date(95, 10, 11), 6));
        store.storage.add(new Movies("Love and Pigeons", new Date(100, 1, 3), 9));

        store.storage.add(new Games("Grand Theft Auto V", new Date(122, 1,3), 8));
        store.storage.add(new Games("Minecraft", new Date(115, 1,3), 7));
        store.storage.add(new Games("Disco Elysium", new Date(122, 6,20), 6));
        store.storage.add(new Games("Mass Effect 2", new Date(122, 11,30), 5));
        store.storage.add(new Games("Counter-Strike", new Date(122, 7,7), 8));

        store.storage.add(new Music("Back to Black", new Date(115, 6, 10), 8));
        store.storage.add(new Music("Chromatica", new Date(118, 1, 9), 9));
        store.storage.add(new Music("Thriller 25", new Date(100, 3, 31), 6));
        store.storage.add(new Music("Born to Die", new Date(108, 8, 19), 1));
        store.storage.add(new Music("21", new Date(122, 6, 11), 1));

        store.storage.add(new Software("Office", new Date(105, 6, 10), 9));
        store.storage.add(new Software("Database", new Date(118, 6, 10), 3));
        store.storage.add(new Software("Photoshop", new Date(120, 6, 10), 7));
        store.storage.add(new Software("Google Chrome", new Date(124, 4, 10), 6));
        store.storage.add(new Software("Skype", new Date(110, 6, 10), 2));
    }
}