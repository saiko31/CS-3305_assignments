import java.util.Scanner;

public class TestQueue {
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

    private static void enqueueElement(MyQueue<Integer> q, Scanner sc){

        System.out.print("Please enter a value: ");
        int data = inputValidation(sc);

        // Displaying information before adding node
        System.out.println("\nPushing value " + data + " in queue");

        if(q.isEmpty()){
            System.out.println("The queue is empty before pushing the element.");
        }
        else{
            System.out.print("\nQueue content before pushing " + data +" is:\t\t");
            q.printStack(); // printing list before adding node
        }

        q.enqueue(data); // call function

        System.out.print("\nQueue content after pushing " + data +" is:\t\t");
        q.printStack(); // Prints the list after adding the node
        System.out.println();

    }


    private static void dequeueElement(MyQueue<Integer> q){
        if(!handleIsEmpty(q)){
            System.out.print("\nQueue content before popping first element:\t\t");
            q.printStack();
            q.dequeue();
            System.out.println();
            System.out.print("Queue content after popping first element:\t\t");
            q.printStack();
            System.out.println();
        }
    }

    private static void frontElement(MyQueue <Integer> q){
        if(!handleIsEmpty(q)){
            System.out.println("The element at the top of the stack is: " + q.top());
        }
    }

    private static void handleGetSize(MyQueue<Integer> q){
        if(!handleIsEmpty(q)){
            System.out.println("The queue has a total of " + q.size() + " elements.");
        }
    }


    private static boolean handleIsEmpty(MyQueue<Integer> q){
        if(q.isEmpty()){
            System.out.println("The queue is empty");
            return true;
        }
        return false;
    }

    private static void handlePrintQueueRequest(MyQueue<Integer> q){
        if (!handleIsEmpty(q)){
            System.out.print("Queue content: \t");
            q.printStack();
            System.out.println();
        }
        }


    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 1 - Enqueue element
                 2 - Dequeue element
                 3 - Get front element
                 4 - Get queue size
                 5 - Is empty queue
                 6 - Print queue
                 7 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        MyQueue<Integer> myQueue = new MyQueue<>();
        int menuOption = 0;

        // === Menu Loop ===
        while(menuOption != 7){
            displayMenu();
            menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case 1:
                    enqueueElement(myQueue, sc);
                    break;
                case 2:
                    dequeueElement(myQueue);
                    break;
                case 3:
                    frontElement(myQueue);
                    break;
                case 4:
                    handleGetSize(myQueue);
                    break;
                case 5:
                    if(!handleIsEmpty(myQueue)){
                        System.out.println("Queue is not empty");
                    }
                    break;
                case 6:
                    handlePrintQueueRequest(myQueue);
                    break;
                case 7:
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
