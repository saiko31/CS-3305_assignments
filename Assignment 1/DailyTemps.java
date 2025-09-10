// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  1
// IDE Name:    IntelliJ IDEA


import java.util.Arrays;

public class DailyTemps{

    private final String[] WEEKDAYS = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
    int[] weekTemps;


    DailyTemps(int[] weekTemps){
        this.weekTemps = weekTemps;
    }


//    Allows user to re-setting the temperature for one day, takes tp parameters: day(String) and temperature
    public void setTemp(String weekday, int temperature){
        weekTemps[Arrays.stream(WEEKDAYS).toList().indexOf(weekday)] = temperature; // Set new temperature using the index provided by the weekday
        System.out.printf("%-10s %d", weekday, weekTemps[Arrays.stream(WEEKDAYS).toList().indexOf(weekday)] );
        System.out.println();
    }

//    Returns the number of days with temperature below freezing (under 32F)
    public void Freezing(){
        int freezingDays = 0;
        for (int i = 0; i < weekTemps.length - 1; i ++ ){
            if(weekTemps[i] <= 35  ){
                freezingDays++;
            }
        }
        System.out.printf("Number of freezing days is %d days", freezingDays);
        System.out.println();
    }



//    Returns the name of the warmest day in the week
public void Warmest() {
    // Start max at the first element's temperature
    int max = weekTemps[0];
    int indexOfMax = 0;

    for (int i = 1; i < weekTemps.length; i++) {
        if (weekTemps[i] > max) {
            max = weekTemps[i];   // Update the max temperature
            indexOfMax = i;       // Update the index
        }
    }
    System.out.println("The warmest day of the week is " + WEEKDAYS[indexOfMax]);
}

//    Prints the temperatures for the week
    public void printTemps(){
        for(int i = 0; i < weekTemps.length; i++){
            String capitalizedDay = WEEKDAYS[i].substring(0, 1).toUpperCase() + WEEKDAYS[i].substring(1); // Capitalizes weekdays before printing
            System.out.printf("%-10s %d", capitalizedDay, weekTemps[i]);
            System.out.println();
        }
    }
}