// Abid Ahmed
// 10-2-17
// A class that creates a 2 dimensional circle

public class Circle {

    // Instance variables
    private Point2D center;
    private double radius;

    // Default constructor
    public Circle() {
        this.center = new Point2D(0,0);
        this.radius = 1;
    }

    // Constructor
    public Circle(Point2D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    // Accessor methods
    public Point2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() { return 2*radius; }

    // Area of a circle
    public double area() {
        return Math.PI * (Math.pow(radius,2));
    }

    // Circumference of a circle
    public double circumference() {
        return 2*Math.PI*radius;
    }

    // toString method
    public String toString() {
        if (center.getX() == 0 && center.getY() == 0) {
            return "x" + '\u00B2' + " + y" + '\u00B2' + " = " + Math.pow(radius,2);
        } else {
            return "(x - " + center.getX() + ")" + '\u00B2' + " + (y - " + center.getY() + ")" + '\u00B2' + " = " + radius*radius;
        }
    }
}
