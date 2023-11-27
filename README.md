# ICS372-Project

How is the code structured? Where are the classes that satisfy the code implementation?
- All packages and java code are in the src/main/java/com/example/mainscreen
- The Abstract classes, the normal classes and the interfaces  are all saved in their package folders
- The one abstract class we're supposed to implement is saved in the AbstractClasses package folder
- The one interface we're supposed to implement is saved in the Interface folder. 
- The 2 classes we're supposed to implement are saved in the Classes folder. We did more than 2 classes. 

Functional requirements: 
- User is allowed to first create an account by registering it.
- User has to register properly. 
  - username has to be at least 4 characters
  - password has to be at least 8 character
  - First name, last name, and home address can't be blank
  - Has to use a proper email
- Once registered. User can go back to main screen and enter username and password. 
  - if improper username is entered user has a pop up appears telling user they entered improper username and password
- Once user enters their username and password the next screen is showed. 

Non-functional requirements:
- Security
  - Username and Password error handling
  - Registration form error handling
- Easy to use
- Code is maintainable 
- Easy to support
- Readable

How does one run the application?
- The JavaFx application is ran through the HelloApplication class which will show the main screen of our app
- The MainScreen.fxml contains all the mainscren xml code for our app. It's in the resources folder under com.example.mainscreen

Final Functtional Requirements:
-User registration before logging into the system
-Registering an account correctly
-Main screen login page with correct username and password
-Selection of a reason for the user’s hospital visit
-Date/time selection for the users appointment before confirming
-Blocking the user if requirements are not met

Final Non-Functonal Requirements:
-Security
-Usability
-Portability
-Data Integrity 