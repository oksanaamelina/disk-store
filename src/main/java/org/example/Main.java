package org.example;

import org.example.classes.Storage;
import org.example.interfaces.IDisk;
import java.util.List;
import java.util.Scanner;

/**
 * Class to demonstrate homework solution
 */
public class Main {
    /**
     * Main method to demonstrate creating and using Storage, Disk objects.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Storage storage = new Storage();
        Storage.fillData(storage);

        // Print information about all movie disks to the console.
        printResult(storage.getAllBy(Type.MOVIE));

        // Implementing a console user interface
        try (Scanner console = new Scanner(System.in)) {
            System.out.println("Enter a number if you want to: " +
                    "\n 1 - get information about all movie disks " +
                    "\n 2 - get information about all games disks " +
                    "\n 3 - get information about all music disks " +
                    "\n 0 - exit the program");
            System.out.print("Your choice is ");
            while (true) {
                if (console.hasNext()) {
                    try {
                        int number = Integer.parseInt(console.nextLine());
                        switch (number) {
                            case 1:
                                printResult(storage.getAllBy(Type.MOVIE));
                                break;
                            case 2:
                                printResult(storage.getAllBy(Type.GAME));
                                break;
                            case 3:
                                printResult(storage.getAllBy(Type.MUSIC));
                                break;
                            case 0:
                                return;
                            default:
                                System.out.println("You entered an invalid number. Please, try again.");
                        }
                        System.out.print("Your choice is ");
                    } catch (NumberFormatException e) {
                        System.out.println("You entered invalid data. Please, try again.");
                        System.out.print("Your choice is ");
                    }
                }
            }
        }
    }

    /**
     * Method to print each list element
     *
     * @param list the list of disks to print
     */
    public static void printResult(List<IDisk> list) {
        list.forEach(System.out::println);
    }
}