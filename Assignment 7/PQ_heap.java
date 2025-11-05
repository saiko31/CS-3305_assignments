// Generic code for class priority_queue_heap for Assignment 7 

// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  7
// IDE Name:    IntelliJ IDEA

import java.util.ArrayList;

public class PQ_heap<E extends Comparable<E>>
{
    private Heap<E> heap;
	// Constructor method

   PQ_heap() {
       heap = new Heap<E>();
   };

	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {return heap.getSize() == 0;};

	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {return heap.getSize() >= heap.CAPACITY;};

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() {
       if(!is_empty()){
           return heap.getFront();
       }
       return null;
   };

	// return number of elements in the queue
   public int size() {return heap.getSize();};

	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public E dequeue() {return heap.remove();};

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(E value) {
       heap.add(value);
   };

   public ArrayList<E> getHeapList(){
       return heap.getList();
   }
};
