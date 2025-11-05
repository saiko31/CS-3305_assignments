
// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  7
// IDE Name:    IntelliJ IDEA


import java.util.Scanner;

public class TestPQH {


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

    private static String strInputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();
            if(input != null && !input.trim().isEmpty()){
                return input;
            }
            else{
                System.out.print("Invalid input, please try again: ");
            }
        }
    }




    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 0 - Enter Queue Data Type (integer or string)
                 1 - Enqueue Element
                 2 - Dequeue Element
                 3 - Check is Full
                 4 - Check is Empty
                 5 - Print PQueue Size
                 6 - Display Front Element
                 7 - Print PQueue Element
                 8 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }



    // Functions that checks that the queue has been initialized before any other option. It used queueType variable
    private static boolean noQueue(int queueType){
        if(queueType == 0){
            System.out.println("Please select option 0 to set the tree type first.");
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Tree declaration
        int queueType = 0; // 0- Unset ; 1- Integer; 2- String
        PQ_heap<Integer> intPQ = null;
        PQ_heap<String> strPQ = null;
        boolean running = true;


        // === Menu Loop ===
        while(running){
            displayMenu();
            int menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case 0:
                    System.out.print("""
                            Please select a Data Type\
                            
                            [1] Integer \t[2] String\
                            
                            Enter an option:\s""");
                    int usrOption = inputValidation(sc);

                    // INTEGER QUEUE
                    if(usrOption == 1){
                        intPQ = new PQ_heap<>();
                        queueType = 1;
                        System.out.println("Integer Queue Selected");
                    }
                    // STRING QUEUE
                    else if(usrOption == 2){
                        strPQ = new PQ_heap<>();
                        queueType = 2;
                        System.out.println("String Queue Selected");
                    }
                    else{
                        System.out.println("Invalid Input");
                    }
                    break;
                case 1:
                    System.out.println("Testing method Enqueue Element (Option 1)");
                    if(!noQueue(queueType)){
                        System.out.print("Please insert a Data Element: ");
                        if(queueType == 1 ){
                            if(!intPQ.is_full()){
                                int input = inputValidation(sc);
                                intPQ.enqueue(input);
                                System.out.println("PQueue Enqueued " + input);
                            } else {
                                System.out.println("Error: PQueue is full.");
                            }
                        }
                        else{
                            if(!strPQ.is_full()){
                                String input = strInputValidation(sc);
                                strPQ.enqueue(input);
                                System.out.println("PQueue Enqueued " + input);
                            } else {
                                System.out.println("Error: PQueue is full.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Testing Method Dequeue Element (Option 2)");
                    if(!noQueue(queueType)){
                        if(queueType == 1 ){
                            if(!intPQ.is_empty()){
                                System.out.print("PQueue Dequeue:\t" + intPQ.dequeue());
                                System.out.println();
                            } else {
                                System.out.println("Error: PQueue is empty.");
                            }
                        }
                        else{
                            if(!strPQ.is_empty()){
                                System.out.print("PQueue Dequeue:\t" + strPQ.dequeue());
                                System.out.println();
                            } else {
                                System.out.println("Error: PQueue is empty.");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Testing Method Check is Full (Option 3)");
                    if(!noQueue(queueType)){
                        System.out.print("Is queue full: ");

                        if(queueType == 1 ){
                            System.out.print(intPQ.is_full());
                            System.out.println();
                        }
                        else{
                            System.out.print(strPQ.is_full());
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Testing Method Check is Empty (Option 4)");
                    if(!noQueue(queueType)){
                        System.out.print("Is queue empty: ");

                        if(queueType == 1 ){
                            System.out.print(intPQ.is_empty());
                            System.out.println();
                        }
                        else{
                            System.out.print(strPQ.is_empty());
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Testing method Print PQueue Size (Option 5)");
                    if(!noQueue(queueType)){
                        System.out.print("PQueue Size: ");
                        if(queueType == 1){
                            System.out.print(intPQ.size());
                            System.out.println();
                        }
                        if(queueType == 2){
                            System.out.print(strPQ.size());
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Testing method Display Front Element (Option 6)");
                    if(!noQueue(queueType)){
                        System.out.print("Front Element: ");
                        if(queueType == 1){
                            if(!intPQ.is_empty()){
                                System.out.print(intPQ.front());
                            } else {
                                System.out.print("PQueue is empty.");
                            }
                            System.out.println();
                        }
                        if(queueType == 2){
                            if(!strPQ.is_empty()){
                                System.out.print(strPQ.front());
                            } else {
                                System.out.print("PQueue is empty.");
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    System.out.println("Testing method Print PQueue Elements (Option 7)");
                    if (!noQueue(queueType)) {
                        // --- INTEGER QUEUE ---
                        if (queueType == 1) {
                            if (intPQ.is_empty()) {
                                System.out.println("PQueue is empty.");
                            } else {
                                java.util.ArrayList<Integer> list = intPQ.getHeapList();
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    System.out.print("Index " + i + ":  " + list.get(i));
                                    int leftChildIndex = 2 * i + 1;
                                    int rightChildIndex = 2 * i + 2;
                                    if (leftChildIndex < size) System.out.print("   " + list.get(leftChildIndex));
                                    if (rightChildIndex < size) System.out.print("   " + list.get(rightChildIndex));
                                    System.out.println();
                                }
                            }
                        }
                        // --- STRINGS QUEUE ---
                        else if (queueType == 2) {
                            if (strPQ.is_empty()) {
                                System.out.println("PQueue is empty.");
                            } else {
                                java.util.ArrayList<String> list = strPQ.getHeapList();
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    System.out.print("Index " + i + ":  " + list.get(i));
                                    int leftChildIndex = 2 * i + 1;
                                    int rightChildIndex = 2 * i + 2;
                                    if (leftChildIndex < size) System.out.print("   " + list.get(leftChildIndex));
                                    if (rightChildIndex < size) System.out.print("   " + list.get(rightChildIndex));
                                    System.out.println();
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    running = false;
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
