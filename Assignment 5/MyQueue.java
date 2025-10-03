// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  5
// IDE Name:    IntelliJ IDEA

public class MyQueue <E>{

    private Node head;
    private int size;

    public MyQueue(){
        head = null;
        size = 0;
    }

    public void enqueue(E e){
        if(head == null){
            head = new Node(e);
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = new Node(e);
        }
        size++;
    }

   public E dequeue(){
       if(isEmpty()){
           throw new IllegalStateException("EmptyStack");
       }

       E data = head.data;
       head = head.next;
       size--;
       return data;
   } // Removes the first element

   public E top(){
        if(isEmpty()){
            throw  new IllegalStateException("Empty Stack");
        }
        return head.data;
   }

   public int size(){
        return size;
   }

 public boolean isEmpty(){return head == null;}

    public void printStack()
    {
        Node temp;
        temp = head;
        while (temp != null)
        {
            System.out.print(temp.data); // This spacing is for printing list of numbers, when other types, the printing format logic will be handled by
            temp = temp.next;
            if(temp != null){
                System.out.print(", ");
            }
        }
    }

    private class Node{
        private final E data;
        private Node next;

        public Node(E item){
            data = item;
            next = null;
        }
    }



}
