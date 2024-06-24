# disk-store
Implement an application "Online Computer Disk Store"

Disk Types
Disks should be categorized into types: Movies, Music, Software, Games (using enum Type).

Disk Information
Each disk should contain the following information:

type - type of the disk (enum Type)
name - name of the disk
inventoryDate – inventory date (the date the disk was added to the inventory)
rating - rating of the disk
Class Hierarchy
Implement a class hierarchy that includes:

An abstract class Disk
Subclasses for each type of disk
All disk classes should implement an interface IDisk which provides methods to:

Get the type of the disk (Type getType())
Get the name of the disk (String getName())
Get the inventory date (Date getInventoryDate())
Get the rating (int getRating())
Each disk should be able to return a string with all its information (toString()).

Storage
Implement a storage (Storage) for disks based on either a List<IDisk> or a Map<Integer, IDisk> (where the key in the map is the disk ID based on the order of addition: 0, 1, 2, etc.).

The storage should implement an interface IStorage with the following functionalities:

Add a disk to the storage (void add(IDisk disk))
Get a collection of all disks (List<IDisk> getAll())
Get a disk by its name (IDisk getBy(String name))
Get a collection of disks by type (List<IDisk> getAllBy(Type type))
Get a collection of disks by rating (List<IDisk> getAllBy(int rating))
Check if a disk exists by type (boolean isExistedBy(Type type))
Check if a disk exists by name (boolean isExistedBy(String name))
Get a collection of disks by year of inventory date (List<IDisk> getAllBy(String year))
The storage should handle exceptions for cases where no disks match the given criteria.

Static Method
Outside the main() method, implement a static method that takes a Storage object with an empty collection and fills it with 20 disks.

Options for Main Method
Choose one of the following options for the main() method:

Print information about all movie disks to the console.
Implement a console user interface with options like: 3. "Enter a number if you want to:
Get information about all movie disks
... ...
To exit the program, enter 0"
This comprehensive task will help you to review and apply various Java core concepts they have learned so far, including class hierarchy, interfaces, enums, collections, and exception handling.
