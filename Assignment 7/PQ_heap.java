// Generic code for class priority_queue_heap for Assignment 7 

public class PQ_heap
{
	// Constructor method
   PQ_heap() {};

	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {};

	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {};

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public int front() {};

	// return number of elements in the queue
   public int size() {};

	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public int dequeue() {};

	// Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(int value) {};
};
