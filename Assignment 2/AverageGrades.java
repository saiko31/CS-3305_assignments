// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  2
// IDE Name:    IntelliJ IDEA

import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageGrades{

//    Global variables to store class size and grades array
    private static int classSize = 0;
    private static int[] classGrades = null;



    //  Method used to validate user's input, it returns a validated int. Used to validate menu option input and class size input (Option 1).
    private static int inputValidation(){
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int userInput = 0;

//      User Input Validation Loop
        do{
            try{
                userInput = sc.nextInt();//Reads the int and assigns it to a variable
                validInput = true; // Changes the flag to true to end the loop
            }
            catch (Exception e){
                System.out.println("Invalid Format. Please try again: ");
                sc.next();
            }
        }while(!validInput);

        return userInput;

    }


//  Option 2. Prompts the user to enter grades for the class
    private static void readClassGrades(Scanner scanner){
//        Verifies if a class size has been entered, if not it prompts the user to do it first.
        if(classSize <= 0){
            System.out.println("Option unavailable. Please enter a class size first.\n");
            return;
        }

        classGrades = new int[classSize];   //Declares grades array the size of the class
        System.out.printf("Please enter %d grades (0-100):\n", classSize);

         for(int i = 0; i < classGrades.length; i++){
             while(true){
                 System.out.print("Please enter grade for student #" + (i+1) + ": ");
                 try{
                     int grade  = scanner.nextInt();
                     if(grade >= 0 && grade <= 100){
                         classGrades[i] = grade;
                         break; // Exit while loop
                     }
                     System.out.println("Please enter a grade between 0 and 100."); // If user types and int bigger than 100
                 }catch(InputMismatchException e){
                     System.out.println("Please enter a valid integer.");
                     scanner.nextLine();
                 }
             }
         }

    }


//    Option 3. Displays class size and grades, and then it calculates average using findAverage() method.
    private static void computeAverage(){
        if(classSize <=0 || classGrades == null){
            System.out.println("Please enter class size and grades first (Options 1 & 2).");
            return;
        }

        System.out.printf("%-25s%d%n", "You entered class size:", classSize);
//        System.out.println("You entered class size:\t"+ classSize );
        System.out.printf("%-25s", "You entered grades:");
        for (int grade : classGrades) {
            System.out.printf("%d ", grade);
        }
        System.out.println();

        System.out.printf("%-25s%.2f%n", "Class average:", findAverage(classGrades, 0.0, classSize - 1));
        System.out.println();


    }




    //  Recursive method that finds the average grade
    private static double findAverage(int[] grades, double sum, int index){
        if(index < 0){
            return sum / grades.length; // Once index reaches zero (no more grades), divides sums between the class size
        }
        sum += grades[index]; // adds the value in grades[index] into sum

        return findAverage(grades, sum, index-1); // Recursively calls the method subtracting 1 to index to get the previous number

    }





    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int menuOption;
        boolean exitMenu  = false; // Flag variable used to exit menu loop

//    Main Menu Loop

        while(!exitMenu){
            System.out.println("\n---------MAIN MENU---------"); // Printing main menu;
            System.out.print("""
                    1. Read class size
                    2. Read class grade
                    3. Compute class average
                    4. Exit program
                    
                    Enter option number:\s""");

            menuOption = inputValidation();

            switch (menuOption){
                case 1:
                    System.out.print("Please enter a class size: ");
                    classSize = inputValidation();
                    break;
                case 2:
                    readClassGrades(sc);
                    break;
                case 3:
                    computeAverage();
                    break;
                case 4:
                    System.out.println("Terminating program...");
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.\n");
            }

        }

    }

}