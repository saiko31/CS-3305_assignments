// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  1
// IDE Name:    IntelliJ IDEA


import java.util.Scanner;

public class TestRectangle{
    

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        double height = 0.00;
        double width = 0.00;

        System.out.println("Please enter a width and height. Use a comma to separate them (,): ");

        do{
            String input = sc.nextLine();
            String[] values = input.split(",\\s*");

            if(values.length == 2){
                try{
                    width = Double.parseDouble(values[0]);
                    height = Double.parseDouble(values[1]);
                    validInput = true;
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid Number format, please try agin:");
                    //sc.nextLine();
                }
            }else
            {
                System.out.println("Invalid Input. Please try again: ");
            }
        }
        while(!validInput);
        
        
        
        Rectangle myrectangle = new Rectangle();
        Rectangle yourRectangle = new Rectangle(width,height);


        //myRectangle

        System.out.println();

        System.out.print("""
                myRectangle
                -----------
                """);
        System.out.println("Width: " + myrectangle.getWidth());
        System.out.println("Height: " + myrectangle.getHeight());
        System.out.println("Area: " + myrectangle.getArea());
        System.out.println("Perimeter: " + myrectangle.getPerimeter());
        myrectangle.printRectangle("myRectangle");

        System.out.println();

        System.out.println("Testing method getWidth() on object myRectangle... " + myrectangle.getWidth());
        System.out.println("Testing method getHeight() on object myRectangle... " + myrectangle.getHeight());
        System.out.println("Testing method getArea() on object myRectangle... " + myrectangle.getArea());
        System.out.println("Testing method getPerimeter() on object myRectangle... " + myrectangle.getPerimeter());
        System.out.println("Testing method printRectangle() on object myRectangle... ");
        myrectangle.printRectangle("myRectangle");

        System.out.println();

        //yourRectangle

        System.out.print("""
                yourRectangle
                -----------
                """);
        System.out.println("Width:" + yourRectangle.getWidth());
        System.out.println("Height: " + yourRectangle.getHeight());
        System.out.println("Area: " + yourRectangle.getArea());
        System.out.println("Perimeter: " + yourRectangle.getPerimeter());
        yourRectangle.printRectangle("yourRectangle");

        System.out.println();

        System.out.println("Testing method getWidth() on object yourRectangle... " + yourRectangle.getWidth());
        System.out.println("Testing method getHeight() on object yourRectangle... " + yourRectangle.getHeight());
        System.out.println("Testing method getArea() on object yourRectangle... " + yourRectangle.getArea());
        System.out.println("Testing method getPerimeter() on object yourRectangle... " + yourRectangle.getPerimeter());
        System.out.println("Testing method printRectangle() on object yourRectangle... ");
        yourRectangle.printRectangle("yourRectangle");
    }



}
