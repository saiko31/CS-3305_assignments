// Name:    Alexander San Agustin-Melendez
// Class:   CS3305/04
// Term:    Fall 2025
// Instructor:  Maxwell Bradley
// Assignment:  1
// IDE Name:    VS Code



public class Rectangle{


    private double width = 1.00;
    private double height = 1.00;


    public Rectangle(){ //Default  Constructor
    }


     public Rectangle(double width, double height){ // Constructor with parameters (width, height)
        this.width = width;
        this.height = height;
     }

    //GETTERS

    public Double getWidth(){return this.width;}
    public Double getHeight(){return this.height;}

//Returns calculated area using width and height
    public double getArea(){return width*height;}
// Returns perimeter
    public double getPerimeter(){return 2*(width+height);}


    // ///////////////////////////////////

//    Prints information about rectangle

    public void printRectangle(String objectName){
        System.out.println("Rectangle " + objectName + " is " + width + " units wide and " + height + " units high.");
        if(width==height){
            System.out.println("That's a square!");
        }
    }



    
}