// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  5
// IDE Name:    IntelliJ IDEA
import java.util.*;
public class RadixSort {

    // =============== UTILITIES ==========================
    private static int inputValidation(Scanner sc) {
        //  Start a loop that will not end on its own.
        while (true) {
            String input = sc.nextLine();

            try {
                int number = Integer.parseInt(input);
                // Verifies that the int is POSITIVE
                if(number >= 0) return number;
                else{
                    System.out.print("Please enter a positive number: "); // If not, prompts the user to try again
                }
            } catch (NumberFormatException e) {
                //  If it fails, print an error and the loop will repeat.
                System.out.print("Invalid input, please try again: ");
            }
        }
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i != array.length - 1){
                System.out.print(", ");
            }
        }
    }

    private static void radixSort(int[] inputs){

        int maxDigits = 0;
        //Finding the biggest number of digits to determine the number of passes
        for(int i: inputs){
           int currDigits = CountDigits(i);
           if(currDigits > maxDigits) maxDigits = currDigits;
        }


        List<MyQueue<Integer>> queues = new ArrayList<>();
        // Initializing 10 queues for digits 0-9
        for(int i = 0; i <= 10; i++){
            queues.add(new MyQueue<>());
        }

        int divisor = 1;
        for(int i = 0; i < maxDigits; i++){
            //Placing numbers into the appropriate queue
            for(int num : inputs){
                //Extracting digit
                int digit = ExtractDigit(num, divisor);
                queues.get(digit).enqueue(num);
            }

            //Extracting numbers back into the array
            int index = 0;
            for(MyQueue<Integer> q : queues){
                while(!q.isEmpty()){
                    inputs[index] = q.dequeue();
                    index++;
                }

                q.printStack(); // for debug
            }
            divisor *= 10;
        }

    }

    private static int ExtractDigit(int n, int div){return (n/div)%10;}

    private static int CountDigits(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }


    // ================ MENU OPTIONS ======================
    private static int[] handleArraySize(Scanner sc){
        System.out.print("Please enter an array size: ");
        // This loop prevents the user from attempting to create an array of size 0
        while (true){
            int size = inputValidation(sc);
            if(size != 0){
                return new int[size];
            }
            else {
                System.out.println("Cannot create an array of size 0.");
                System.out.print("Please enter an array size: ");
            }
        }

    }

    private static void handleArrayVolumes(int[] array, Scanner sc){
        if(array != null){
            int size = array.length;
            for(int i = 0; i < size; i ++){
                System.out.print("Please enter value #" + (i+1) +": ");
                array[i] = inputValidation(sc);
                System.out.println();
            }
        }
        else{
            System.out.println("The array has not been initialized (Option 1).");
        }
    }

    private static void handleRadixSort(int[] inputs){
        if(inputs != null && inputs.length != 0){
            System.out.print("Array values before sorting:\t");
            printArray(inputs);
            System.out.println();
            radixSort(inputs);
            System.out.print("Array values after sorting:\t\t");
            printArray(inputs);
            System.out.println();
        }
        else{
            System.out.println("The array is empty!");
        }

    }
    private static void displayMenu(){
        System.out.println("\n---------MAIN MENU--------");
        System.out.println("""
                 1 - Read array size
                 2 - Read array values
                 3 - Run Radix Sort and print outputs
                 4 - Exit Program""");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int[] inputs = null;
        int menuOption = 0;

        // === Menu Loop ===
        while(menuOption != 4){
            displayMenu();
            menuOption = inputValidation(sc);
            System.out.println();

            switch (menuOption){
                case 1:
                    inputs = handleArraySize(sc);
                    break;
                case 2:
                    handleArrayVolumes(inputs,sc);
                    break;
                case 3:
                    handleRadixSort(inputs);
                    break;
                case 4:
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
