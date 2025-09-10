
// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  3
// IDE Name:    IntelliJ IDEA

/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null)
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node . DONE
   public void addFirstNode(int data)
   {

      Node firstNode = new Node(data); // Creating the node to be added

//      // Displaying information before adding node
//       System.out.println("Adding value " + data + " as first node");
//       System.out.print("List content before adding " + data +" is: \t");
//       printList(); // printing list before adding node
//      System.out.println();

      // Adding node
      firstNode.next = ListName; // Links firstNode.next to the first node of ListName, making it the first in line
      ListName = firstNode; // Moves head to firstNode

//      System.out.print("List content after adding " + data +" is: \t");
//      printList(); // Prints the list after adding the node

   }
     
      
   //method #2: add node at index . DONE
   public void addAtIndex(int index, int data)
   {
//      if(index < 0 || index > countNodes()){
//         System.out.println("\nInvalid index. Please try again");
//         return;
//      }

      if(index == 0){
         addFirstNode(data);// If index is 0, it adds the node as the first using addFirstNode function
         return;
      }

      Node current = ListName;
      Node previous = null;
      Node newNode = new Node(data);
      while (index >= 1){
         previous = current;
         current = current.next;
         index--;

      }

      newNode.next = current;
      previous.next = newNode;


   }
      
      
   //method #3: remove first node. DONE
   public void removeFirstNode()
   {
      ListName = ListName.next; // Changes ListName to be the next node
   }
      
      
   //method #4: remove last node. DONE
   public void removeLastNode()
   {
      // Case 1 : List is empty
      if(ListName == null){
         System.out.println("List is empty");
         return;
      }
      // Case 2: only one item in list
      else if(ListName.next == null){
         ListName = null; //
         return;
      }

      Node current = ListName;
      Node previous = null;

      while(current.next != null){
         previous = current;
         current = current.next;
      }
      previous.next = null;
   }
    
    
   //method #5: remove node at index. Done
   public void removeAtIndex(int index)
   {
      if(index == 0){
         // if index == 0, removes first node using removeFirstNode function
         removeFirstNode();
         return;
      }

         Node prev = ListName;

         for(int i = 0; i < index -1 ; i++){
            prev = prev.next;
         }

         //Node to be removed is prev.next
         // Points to prev.next.next
         Node removed = prev.next;
         prev.next = removed.next;
   }
          
   //method #6: countNodes. Done
   public int countNodes()
   {
      int listSize= 0;
      Node curr = ListName;

      while (curr != null){
         listSize++;
         curr = curr.next;
      }
      return listSize; 
   }

   
   //method #7: pritnInReverse (must be a Recursive method)
   //Wrapper method. PUBLIC
   public void printInReverse(){
      printInReverseRecursive(ListName);
   }
   // Helper method. Converted in private
   private void printInReverseRecursive(Node L)
   {
      // Base Case L(current node) is null. End of recursion
      if(L == null){
         return;
      }

      printInReverseRecursive(L.next);

      System.out.print(L.data + "   ");
   }

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
//      System.out.println();
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

