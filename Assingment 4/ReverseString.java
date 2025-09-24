// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  4
// IDE Name:    IntelliJ IDEA

import java.util.Scanner;

public class ReverseString {

    // Same validation method than the previous one, but modified to validate Strings
    private static String inputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();

           if(input != null && !input.trim().isEmpty()){
               return input;
           }
           else{
               System.out.println("Invalid input, please try again: ");
           }
        }
    }

    // === Option 1 ===

    private static String readInput (MyStack<String> list, Scanner sc){
        if(!list.isEmpty()){
           list.emptyStack(); // Clears the stack for new string
        }
        System.out.print("Please enter a string: ");
        String originalSentence = inputValidation(sc);

        String[] wordList =originalSentence.split(" ");

        for(String s: wordList){
            list.push(s);
        }
        return originalSentence;
    }


    // === Option 2 ===

    private static void handleReverseString(MyStack<String> list, String originalSentence){
        if(!list.isEmpty()){
            System.out.print("Entered string: \t" + originalSentence);
            System.out.print("\nReversed string: \t");

            // Takes the element at the top and prints it, I could just use
            // printStack method, but I guess that would be easier, I have to justify previous work
            // Create a temporary stack to store what is pop when printing
            MyStack<String> tempStack = new MyStack<>();
            while(!list.isEmpty()){
                String word = list.pop();
                System.out.print(word + " ");
                tempStack.push(word);
            }

            //restoring original stack
            while (!tempStack.isEmpty()){
                list.push(tempStack.pop());
            }
            System.out.println();
        }
        else{
            System.out.println("The stack is empty. Please enter a string first (Option 1)");
        }
    }

    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 1 - Read input string of words
                 2 - Reverse string and display outputs
                 3 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyStack<String> myList = new MyStack<>();
        String menuOption = "";
        String userInput = null;

        // === Menu Loop ===
        while(!menuOption.equals("3")){
            displayMenu();
            menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case "1":
                    userInput = readInput(myList, sc);
                    break;
                case "2":
                    handleReverseString(myList, userInput);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }

        }
        // Prompts the user that the program is ending
        System.out.println("Exiting Program...");
    }






}
