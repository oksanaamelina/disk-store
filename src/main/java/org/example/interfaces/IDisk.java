package org.example.interfaces;

import org.example.Type;
import java.util.Date;

/**
 * The IDisk interface represents a contract for disk behavior.
 * Any class implementing this interface must provide an implementation for all that methods.
 */
public interface IDisk {
    Type getType();

    String getName();

    Date getInventoryDate();

    int getRating();
}

