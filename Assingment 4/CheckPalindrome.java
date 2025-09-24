// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  4
// IDE Name:    IntelliJ IDEA


import java.util.Scanner;

public class CheckPalindrome {
    // Same validation method as ReverseString
    private static String inputValidation(Scanner sc) {
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


    // === Option 1 ===

    private static String readInput (MyStack<Character> list, Scanner sc){
        if(!list.isEmpty()){
            list.emptyStack(); // Clears the stack for new string
        }
        System.out.print("Please enter a string: ");
        String word = inputValidation(sc);
//        String wordNoSpaces = word.replace(" ", "");
//        System.out.println(wordNoSpaces);

        for(char c: word.replace(" ", "").toCharArray()){ // Removing spaces for proper palindrome phrase verification
//            System.out.println(c);
            // fills stack object with the input string chars
            list.push(c);
        }
        return word; // return input string
    }

    private static void checkPalindrome(MyStack<Character> list, String originalString){
        if(!list.isEmpty()){
            // Displaying input string
            System.out.println("Entered String:\t\t" + originalString);

            MyStack<Character> listBackup = new MyStack<>(); // Backup for later restoration
            boolean isPalindrome = true;

            //Comparing (originalString - spaces) characters with stack popped characters
            for(char c: originalString.replace(" ", "").toCharArray()){
                char c1 = list.pop();
                listBackup.push(c1); // backup
                if(Character.toLowerCase(c) != Character.toLowerCase(c1)){
                    isPalindrome = false;
                }
            }

            // restoring original stack
            while (!listBackup.isEmpty()) {
                list.push(listBackup.pop());
            }

            //Displaying judgement
            System.out.print("Judgement: \t\t\t" + (isPalindrome ? "Palindrome" : "Not Palindrome"));
        }
        else{
            System.out.println("Empty Stack");
        }


    }

    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 1 - Read input string of words
                 2 - Check palindrome and display output.
                 3 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyStack<Character> myList = new MyStack<>();
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
                    checkPalindrome(myList, userInput);
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
