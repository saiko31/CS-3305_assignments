// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  4
// IDE Name:    IntelliJ IDEA

public class MyStack <E>{

    private Node ListName;
    int size;

    public MyStack(){
        size = 0;
    }

    public void push(E data)
    {
      Node firstNode = new Node(data);
      firstNode.next = ListName;
      ListName = firstNode;
      size++;
    }

    public void pop(){
        ListName = ListName.next;
        size--;
    } // Removes element at the top

    public E top(){return ListName.data;} // Returns the element at the top

    public int size(){return this.size;} // Returns size

    public boolean isEmpty(){return ListName == null;}

    public void printStack()
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

    private class Node
    {
        private E data;  //data field
        private Node next; //link field

        public Node(E item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}




