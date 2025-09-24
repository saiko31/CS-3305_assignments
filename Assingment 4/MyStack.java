// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  4
// IDE Name:    IntelliJ IDEA

public class MyStack <E>{

    private Node ListName;
    private int size;

    public MyStack(){
        ListName = null;
        size = 0;
    }

    public void push(E data)
    {
      Node firstNode = new Node(data);
      firstNode.next = ListName;
      ListName = firstNode;
      size++;
    }

    public E pop(){
        if(isEmpty()){
            throw new IllegalStateException("Empty stack");
        }

        E data = ListName.data;
        ListName = ListName.next;
        size--;
        return data;
    } // Removes element at the top

    public E top(){
        if(isEmpty()){
            throw new IllegalStateException("Empty Stack");
        }
        return ListName.data;
    } // Returns the element at the top

    public int size(){return this.size;} // Returns size

    public boolean isEmpty(){return ListName == null;}

    public void printStack()
    {
        Node temp;
        temp = ListName;
        while (temp != null)
        {
            System.out.print(temp.data + "   "); // This spacing is for printing list of numbers, when other types, the printing format logic will be handled by
            temp = temp.next;
        }
//      System.out.println();
    }


    // Method used to clear the stack in ReverseString, when the user wants to enter a new string
    public void emptyStack(){
        ListName = null;
        size = 0;
    }

    private class Node
    {
        private final E data;  //data field
        private Node next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}




