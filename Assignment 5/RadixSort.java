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
        int n = inputs.length;
        //Finding the biggest number of digits to determine the number of passes
        int max = 0;
        for(int i: inputs){
            int current = CountDigits(i);
            if(current > max) max = current;
        }

        List<MyQueue<Integer>> queues = new ArrayList<>();
        // Initializing 10 queues for digits 0-9
        for(int i = 0; i <= 10; i++){
            queues.add(new MyQueue<>());
        }

        while(max > 0){
            for(int i  = 0; i < n; i++){
                //Extracting digit
                int digit = ExtractDigit(inputs[i]);
                //Adding i to respective queue
                queues.get(digit).enqueue(inputs[i]);
                //Updating i
                inputs[i] /= 10;
            }

            //Extracting numbers
            int index = 0;
            for(MyQueue<Integer> q : queues){
                while(!q.isEmpty()){
                    inputs[index] = q.dequeue();
                    index++;
                }

                q.printStack(); // for debug
            }
            max--;
        }

    }

    private static int ExtractDigit(int n){return n%10;}

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
        int size = inputValidation(sc);

        return new int[size];
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
    }

    private static void handleRadixSort(int[] inputs){
        if(inputs.length != 0){
            System.out.print("Array values before sorting:\t\t");
            printArray(inputs);
            System.out.println();
            radixSort(inputs);
            System.out.print("Array values after sorting:\t\t");
            printArray(inputs);
            System.out.println();
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
                case 5:
                    System.out.println(ExtractDigit(7/10)); // for debugging
                    break;
                case 6:
                    ExtractDigit(788961);
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
