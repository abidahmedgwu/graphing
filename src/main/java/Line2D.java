// Abid Ahmed
// 10-2-17
// A class that creates a 2 dimensional line
// Cannot create a line of x = a

public class Line2D {

    // Instance variables
    private double slope;
    private double yIntercept;

    // Default constructor
    public Line2D() {
        this.slope = 1;
        this.yIntercept = 0;
    }

    // Constructor
    public Line2D(double slope, double yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }
    // Accessor methods
    public double getSlope() {
        return slope;
    }

    public double getYIntercept() {
        return yIntercept;
    }

    // toString method
    public String toString() {
        return "y = " + slope + "x + " + yIntercept;
    }

    /* Find the intersection of two 2D lines.
    Returns (infinity, infinity) if the lines are the same.
    Returns NaN if the lines do not intersect at all.
    Returns (x,y) if the lines intersect. (x,y) is the point of intersection. */
    public static Point2D getIntersection(Line2D a, Line2D b) {
        if (a.getSlope() == b.getSlope() && a.getYIntercept() == b.getYIntercept()) {
            return new Point2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        } else if (a.getSlope() == b.getSlope()) {
            return new Point2D(Double.NaN, Double.NaN);
        } else {
            // Gets the x-value of the intersection
            double x = ((b.getYIntercept() - a.getYIntercept()) / (a.getSlope() - b.getSlope()));
            double y = a.getSlope() * x + a.getYIntercept();
            return new Point2D(x, y);
        }
    }
}
