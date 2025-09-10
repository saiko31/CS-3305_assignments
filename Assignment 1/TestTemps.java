// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  1
// IDE Name:    IntelliJ IDEA


import java.util.Scanner;
import java.util.Arrays;



public class TestTemps{



    private void validatingInput(String input){

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] weekdays = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
        int[] dailyTemps = new int[7];
        boolean validInput = false;



// User prompter loop. It asks the user for a temperature for each day of the week.
        System.out.println("Please enter a temperature for each weekday.");

        for(int i = 0; i < weekdays.length ; i++){
            validInput = false;

            //User input validation
            do{
                try {
                    String capitalizedDay = weekdays[i].substring(0, 1).toUpperCase() + weekdays[i].substring(1);
                    System.out.print(capitalizedDay + ": ");
                    dailyTemps[i] = sc.nextInt();
                    validInput = true;
                }catch (Exception e){
                    System.out.println("Error!. Please enter a valid number.");
                    sc.next();
                }
            }
            while(!validInput);

        }
        System.out.println();

// ///////////////// Creating DailyTemps object //////////////

        DailyTemps userTemps = new DailyTemps(dailyTemps);

        System.out.println("Object DailyTemps userTemps Created! \nPrinting Temperatures\n");


        userTemps.printTemps();



// ///////////// Testing setTemp() /////////////////
        sc.nextLine();
        System.out.println("\nTesting setTemp(): Please enter a day and temperature. Use a comma to separate them (,).");

        //  Validating user input, the input is taken in the form (day,temperature)
        String day = "";
        int temp = 0;
        validInput = false;

        do{
            String input = sc.nextLine();
            String[] parts = input.split(",\\s*");

            if (parts.length == 2) {
                try {
                    if (Arrays.asList(weekdays).contains(parts[0].toLowerCase())) {
                        day = parts[0];
                        temp = Integer.parseInt(parts[1]);
                        validInput = true;
                    } else {
                        System.out.println("Please input a valid day. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter a valid temperature.");
                }
            } else {
                System.out.println("Invalid input format. Please use 'day,temp'.");
            }
        }while(!validInput);

        userTemps.setTemp(day,temp);


        System.out.println("Printing Temperatures: ");
        userTemps.printTemps();



// //////////////// Testing Freezing() ///////////////////

        System.out.println("Testing Freezing()...");
        userTemps.Freezing();

// /////////////// Testing Warmest() /////////////////////

        System.out.println("Testing Warmest()...");
        userTemps.Warmest();







    }

}