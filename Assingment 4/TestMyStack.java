// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  4
// IDE Name:    IntelliJ IDEA

import java.util.Scanner;

public class TestMyStack {
    private static int inputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();

            try {
                //  Try to convert input to a number, if successful, return the number. This is the ONLY way to exit the loop.
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                //  If it fails, print an error and the loop will repeat.
                System.out.print("Invalid input, please try again: ");
            }
        }
    }

    // ==== Option 1 =====
    private static void handlePushRequest(MyStack<Integer> list, Scanner sc){
        System.out.print("Please enter a value: ");
        int data = inputValidation(sc);

        // Displaying information before adding node
        System.out.println("\nPushing value " + data + " in stack");

        if(handleIsEmpty(list)){
            System.out.println("The stack is empty before pushing the element.");
        }
        else{
            System.out.print("Stack content before pushing " + data +" is:\t\t");
            list.printStack(); // printing list before adding node
        }
        list.push(data); // call function

        System.out.print("\nStack content after pushing " + data +" is:\t\t");
        list.printStack(); // Prints the list after adding the node
        System.out.println();
    }

    // === Option 2 ===
    private static void handlePopRequest(MyStack<Integer> list) {
        if(!handleIsEmpty(list)){ // Checks first that stack is not empty, for every function
            System.out.print("\nStack content before popping first element:\t\t");
            list.printStack();
            list.pop();
            System.out.println();
            System.out.print("Stack content after popping first element:\t\t");
            list.printStack();
            System.out.println();
        }
    }


    // === Option 3 ===
    private static void handleGetTop(MyStack<Integer> list){
        if(!handleIsEmpty(list)){
           System.out.println("The element at the top of the stack is " + list.top());
        }
    }

    // === Option 4 ===

    private static void handleGetSize(MyStack<Integer> list){
        if(!handleIsEmpty(list)){
            System.out.println("The stack has a total of " + list.size() + " elements.");
        }
    }

    // === Option 5 ===
    private static boolean handleIsEmpty(MyStack<Integer> list){
        if(list.isEmpty()){
            // If empty it prints this message. This is because other functions verifies if the stack is empty using this one before performing operations,
            // and I don't want to repeat the same line in every single one of them, just like I did in Assignment 3
            System.out.println("The stack is empty");
            return true;
        }
        return false;
    }

    // === Option 6 ===
    private static void handlePrintStackRequest(MyStack<Integer> list){
        if (!handleIsEmpty(list)){
            System.out.print("Stack content: \t");
            list.printStack();
            System.out.println();
        }
    }


    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 1 - Push Element
                 2 - Pop Element
                 3 - Get top element
                 4 - Get stack size
                 5 - Is empty stack
                 6 - Print Stack
                 7 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        MyStack<Integer> myList = new MyStack<>();
        int menuOption = 0;

        // === Menu Loop ===
        while(menuOption != 7){
            displayMenu();
            menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case 1:
                    handlePushRequest(myList, sc);
                    break;
                case 2:
                    handlePopRequest(myList);
                    break;
                case 3:
                    handleGetTop(myList);
                    break;
                case 4:
                    handleGetSize(myList);
                    break;
                case 5:
                    if(!handleIsEmpty(myList)){
                        // I decided to put it here because other functions used this one and I don't want it to print this every time the function is called
                        System.out.println("Stack is not empty");
                    }
                    break;
                case 6:
                    handlePrintStackRequest(myList);
                    break;
                case 7:
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

