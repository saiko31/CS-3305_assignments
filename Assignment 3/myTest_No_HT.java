
// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  3
// IDE Name:    IntelliJ IDEA


import java.util.List;
import java.util.Scanner;


public class myTest_No_HT
{
   private static final Scanner sc = new Scanner(System.in);

   // Method used to validated that the user inputs an int, other validations are made in their respective functions
   private static int inputValidation() {
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

   private static boolean isEmpty(LinkedList_No_HT list){
       return list.ListName == null;
   }

   private static void displayMenu(){
      System.out.println("\n---------MAIN MENU--------");
      System.out.println("""
                 1 - Add First Node
                 2 - Add Last Node
                 3 - Add At Index
                 4 - Remove First Node
                 5 - Remove Last Node
                 6 - Remove At Index
                 7 - Print List Size
                 8 - Print List Forward
                 9 - Print List In Reverse
                 10. Exit Program""");

      System.out.print("\nEnter option number: ");
   }


// ==== Option 1 =====
   private static void handleAddFirstNodeRequest(LinkedList_No_HT list){
      System.out.print("Please enter a value: ");
      int data = inputValidation();

      // Displaying information before adding node
      System.out.println("\nAdding value " + data + " as first node");

      if(isEmpty(list)){
          System.out.println("The list is empty before adding the node.");
      }
      else{
          System.out.print("List content before adding " + data +" is: \t");
          list.printList(); // printing list before adding node
      }
      list.addFirstNode(data); // call function

      System.out.print("\nList content after adding " + data +" is: \t");
      list.printList(); // Prints the list after adding the node
       System.out.println();
   }


//   ==== Option 2 ====
    private static void handleAddLastNodeRequest(LinkedList_No_HT list){
        System.out.print("Please enter a value: ");
        int data = inputValidation();

        // Displaying information before adding node
        System.out.println("\nsAdding value " + data + " as last node");
        System.out.print("List content before adding " + data +" is: \t");
        list.printList(); // printing list before adding node
        System.out.println();

        list.addLastNode(data); // call function

        System.out.print("List content after adding " + data +" is: \t");
        list.printList(); // Prints the list after adding the node
        System.out.println();
    }

//    === Option 3 ===
    private static void handleAddAtIndexRequest(LinkedList_No_HT list){
       System.out.print("Please enter a value: ");
       int data = inputValidation();
       System.out.print("Please enter an index: ");
       int index = inputValidation();
        if(index < 0 || index > list.countNodes()){
            System.out.println("\nInvalid index. Please try again"); // If index is not within the range, it aborts the operation and take the user back to the menu
            return;
        }
        if(isEmpty(list)){
            System.out.println("The list is empty before adding the node.");
        }
        else{

            System.out.println("\nAdding value " + data + " at index " + index);
            System.out.print("List content before adding " + data +" is: \t");
            list.printList(); // printing list before adding node

        }
       list.addAtIndex(index,data);
       System.out.print("\nList content after adding " + data + " is : \t");
       list.printList();
       System.out.println();

    }


    // === Option 4 ===
    private static void handleRemoveFirstNode(LinkedList_No_HT list) {
      if(!isEmpty(list)){
          System.out.print("\nList content before removing first node: \t");
          list.printList();
          list.removeFirstNode();
          System.out.println();
          System.out.print("List content after removing first node: \t");
          list.printList();
          System.out.println();
          return;
      }
        System.out.println("List is empty");

    }


    // === Option 5 ===
    private static void handleRemoveLastNode(LinkedList_No_HT list){
        if(!isEmpty(list)){
            System.out.print("\nList content before removing last node: \t");
            list.printList();
            list.removeLastNode();
            System.out.println();
            System.out.print("\nList content after removing last node: \t");
            list.printList();
            System.out.println();
            return;
        }

        System.out.println("List is empty");
    }

    // === Option 6 ===

    private static void handleRemoveAtIndex(LinkedList_No_HT list){

       if(list.ListName == null) {
           System.out.println("List is empty"); // Cancels operation if list is empty
           return;
       }

        System.out.print("Please enter an index: ");
        int index = inputValidation();
        if(index < 0 || index > list.countNodes()){
            System.out.println("\nInvalid index. Please try again"); // If index is not within the range, it aborts the operation and take the user back to the menu
        }
        else{
            System.out.print("\nList content before removing node at index " + index + ": \t");
            list.printList();
            System.out.println();
            list.removeAtIndex(index);
            System.out.print("List content after removing node at index " + index + ": \t");
            list.printList();
            System.out.println();
        }
    }


    // === Option 7 ===
    private static void handleCountNodes(LinkedList_No_HT list){
       if(!isEmpty(list)){
           System.out.println("The list has a total of " + list.countNodes() + " nodes.");
           return;
       }
       System.out.println("List is empty");
    }
    // === Option 8 ===
    private static void handlePrintListRequest(LinkedList_No_HT list){
        if (!isEmpty(list)){
            System.out.print("List content: \t");
            list.printList();
            System.out.println();
            return;
        }
        System.out.println("List is empty");
    }

    // Option 9
    private static void handlePrintReverseListRequest(LinkedList_No_HT list){
        if(!isEmpty(list)){
            System.out.print("Reverse List content: \t");
            list.printInReverse();
            System.out.println();
            return;
        }
        System.out.println("List is empty");
    }









    public static void main (String[] args)
   {
       LinkedList_No_HT myList = new LinkedList_No_HT();
       int menuOption = 0;


//       for(int i = 1; i <= 5; i ++){
//           myList.addLastNode(i*10);
//       }
//


       // === Menu Loop ===
       while(menuOption != 10){
           displayMenu();
           menuOption = inputValidation();
           System.out.println();

           switch (menuOption){
               case 1:
                   handleAddFirstNodeRequest(myList);
                   break;
               case 2:
                   handleAddLastNodeRequest(myList);
                   break;
               case 3:
                   handleAddAtIndexRequest(myList);
                   break;
               case 4:
                   handleRemoveFirstNode(myList);
                   break;
               case 5:
                   handleRemoveLastNode(myList);
                   break;
               case 6:
                   handleRemoveAtIndex(myList);
                   break;
               case 7:
                   handleCountNodes(myList);
                   break;
               case 8:
                   handlePrintListRequest(myList);
                   break;
               case 9:
                   handlePrintReverseListRequest(myList);
               case 10:
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
    
