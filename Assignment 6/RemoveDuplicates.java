// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  6
// IDE Name:    IntelliJ IDEA


import java.util.Scanner;
public class RemoveDuplicates {

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
                 1 - Read input string
                 2 - Remove duplicates and display outputs
                 3 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    // OPTION 2

    private static void handleDuplicates (String usrInput, BST<String> stringBST){
        System.out.println("Original Text:");
        System.out.println(usrInput);
        System.out.println();
        System.out.println("Processed Text:");
        // inorder() method already verifies if an element is in the tree to avoid duplicates
        stringBST.inorder();
        System.out.println();

    }



    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        String menuOption = null;
        String inputString = ""; //User input
        boolean running = true;
        BST<String> strTree = null;
        // === Menu Loop ===
        while(running){
            displayMenu();
            menuOption = strInputValidation(sc);
            System.out.println();

            switch (menuOption){
                case "1":
                    System.out.println("Please enter text:");
                    inputString = strInputValidation(sc);

                    strTree = new BST<>();

                    for(String s: inputString.split(" ")){
                        //System.out.println(s); // test-only
                        strTree.insert(s);
                    }

                    break;
                case "2":
                    if(strTree == null){
                        System.out.println("Please enter an input string first (Option 1).");
                    }
                    else{
                        handleDuplicates(inputString, strTree);
                    }
                    break;
                case "3":
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
