package org.example.interfaces;

import org.example.Type;
import java.util.List;

/**
 * The IStorage interface represents a contract for storage behavior.
 * Any class implementing this interface must provide an implementation for all that methods.
 */
public interface IStorage {

    void add(IDisk disk);

    List<IDisk> getAll();

    IDisk getBy(String name);

    List<IDisk> getAllBy(Type type);

    List<IDisk> getAllBy(int rating);

    boolean isExistedBy(Type type);

    boolean isExistedBy(String name);

    List<IDisk> getAllBy(String year);
}