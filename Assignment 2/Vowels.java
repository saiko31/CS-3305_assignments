// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  2
// IDE Name:    IntelliJ IDEA

import java.util.Scanner;

public class Vowels{
// Global variable for user string
    private static String userString = null;

    //  Method used to validate user's input, it returns a validated string
    private static String inputValidation(){
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        String userInput = null;

//      User Input Validation Loop
        do{
            try{
                userInput = sc.nextLine();//Reads the string and assigns it to a variable
                validInput = true; // Changes the flag to true to end the loop
            }
            catch (Exception e){
                System.out.println("Invalid Format. Please try again: ");
                sc.next();
            }
        }while(!validInput);

        return userInput;

    }
//    Option 1. Prompts the user to enter a String
    private static void readInput(){
        System.out.println("Please enter a string: "); // Prompts the user for a string
        userString = inputValidation(); // Validates the input
    }

//    Option 2. Verifies that a string has been entered, then prints it and call the method countVowels() to count the number of vowels in the string
    private static void computeVowels(){
        if(userString == null){
            System.out.println("Please enter a String first."); // Prompts the user to type a string first.
            return;
        }
        System.out.println("You entered the string: " + userString); // Prints the string
        System.out.printf("%-24s%d%n", "Number of vowels: ",countVowels(userString)); // Calls recursive method
    }



    public static void main(String[] args){
        String menuOption;
        boolean exitMenu  = false; // Flag variable used to exit menu loop

//    Main Menu Loop
        while(!exitMenu){
            System.out.println("\n---------MAIN MENU---------"); // Printing main menu;
            System.out.print("""
                    1. Read input string
                    2. Compute number of vowels
                    3. Exit program
                    
                    Enter option number:\s""");

            menuOption = inputValidation();

            switch (menuOption){
                case "1":
                    readInput();
                    break;
                case "2":
                    computeVowels();
                    break;
                case "3":
                    System.out.println("Terminating program...");
                    exitMenu = true; // Breaks loop
                    break;
                default:
                    System.out.println("Please enter a valid option.\n");
            }

        }

    }


//  Recursive method that counts vowels in a string
    private static int countVowels(String userInput){
        if(userInput.isEmpty()){ // Base case, if the string is empty or null it returns 0
            return 0;
        }
        char first = userInput.charAt(0); // Checks the first character of the string
        int count = 0;                      // Vowel counter
        if ("aeiouAEIOU".contains(String.valueOf(first))) { //Check if the value of first is in string aeiouAEIOU; if the case, adds 1 to the counter
            count = 1;
        }

        return count + countVowels(userInput.substring(1)); // Creates a substring without the first char and calls the method again. Count is added to the recursive result;

    }
}