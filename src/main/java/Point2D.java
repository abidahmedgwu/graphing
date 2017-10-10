// Abid Ahmed
// 10-2-17
// A class that creates a 2 dimensional point

public class Point2D {

    // Instance variables
    private double x;
    private double y;

    // Default constructor
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Accessor methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // toString method
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Calculates the distance between two Point2Ds
    public static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY()-b.getY(),2));
    }

    // Moves a Point2D by assigning x and y to new values
    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
