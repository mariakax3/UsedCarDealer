# Used Car Dealer System
The aim of the project was to create a used car dealer system in the form of the window app. Application was built on purpose of Obejct-oriented programming laboratories at the university. The project's purpose was to get acquainted with creating Graphical User Interface. Application was created in Polish language.
## Implementation
The application was written in Java language according to its paradigms such as inheritance, polymorphism and encapsulation. GUI was created with Java Swing.
## Functionalities
Application allows to manage the second-hand car fleet. Fleet is divided into two categories: passenger cars and truck. The user can add a car to the database, specifying its parameters that are reasonable in terms of the car type. The other panel shows the fleet with the most important features of a specific car. While browsing the fleet, the user can reserve a car which signs it as occupied
## Project tree
1. `Main.java` - class creates all pane necessary for the correct work of the application
2. `Car.java` - an abstract superclass for each type of car, contains general fields and abstract functions
3. `PassengerCar.java`, `Truck.java` - sublasses of a Car class, each of them contains field specific for its type and definitions of functions from superclass
4. `Fleet.java` - class stores vector of a whole fleet, allows to print whole fleet, read and save data to .txt file so that entered data are not lost after exiting the application
5. `FleetRepository.java`, `FileDataSource.java` - classes responsible for saving and reading data from .txt file; FleetRepository passes array of objects to FileDataSource which has direct contact with database file
6. `FormExceptions.java` - contains definitions of exceptions necessary for avoiding fatal errors
7. `Validators.java` - contains definions of function responsible for data validation
8. `HomePanel.java` - application start panel
9. `SellPassengerCar.java`, `SellTruck.java` - panels responsible for adding a car to the fleet, entering data and checking its correctness
10. `BuyPassengerCar.java`, `BuyTruck.java` - panels responsible for presenting the fleet
11. `UI.java` - class responsible for setting up whole GUI 
## Class diagram
![Used Car Dealer System UML Diagram](https://github.com/mariakax3/UsedCarDealer/blob/master/UsedCarDealer.jpg?raw=true)
## How the app could look
Due to limited time and main goal of the project, which was to get to know Java and Java Swing, the application is not as complex as it could be. There is no action after reserving car. There is potential to develop it by adding e.g. the form for the reserving person's data or introducing version for an admin - authorised by login and password - and for a client.
