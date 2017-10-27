// Abid Ahmed
// 10-23-17
// Class that creates a vector. Can be any dimension
public class Vector {

    // Instance variables
    double[] components;

    // Constructors
    public Vector() {
        components[0] = 0;
    }

    public Vector(double[] components) {
        this.components = copyArray(components);
    }

    // Accessor methods
    public double[] getComponents() {
        return components;
    }

    // toString
    public String toString() {
        String output = "<";
        for (int i = 0; i < components.length-1; i++) {
            output += components[i] + ", ";
        }
        output += components[components.length-1] + ">";
        return output;
    }

    // Calculates the length/magnitude of the vector
    public double getMagnitude() {
        double sum = 0;
        for (int i = 0; i < components.length; i++) {
            sum += Math.pow(components[i],2);
        }
        return Math.sqrt(sum);
    }

    // Calculates the unit vector
    public Vector getUnitVector() {
        double magnitude = getMagnitude();
        double[] unitComponents = new double[components.length];
        for (int i = 0; i < unitComponents.length; i++) {
            unitComponents[i] = components[i]/magnitude;
        }
        return new Vector(unitComponents);
    }

    // Calculates the dot product between two vectors
    public static double dotProduct(Vector a, Vector b) {
        double[] aComponents = a.getComponents();
        double[] bComponents = b.getComponents();
        double sum = 0;
        for (int i = 0; i < aComponents.length; i++) {
            sum += (aComponents[i]*bComponents[i]);
        }
        return sum;
    }

    // Calculates the dot product using the magnitude of a and b
    // and angle theta
    public static double dotProduct(double aMagnitude, double bMagnitude, double theta) {
        return aMagnitude*bMagnitude*Math.cos(theta);
    }

    // Adds two given vectors
    public static Vector add(Vector a, Vector b) {
        double[] addComponents = new double[a.getComponents().length];
        for (int i = 0; i < addComponents.length; i++) {
            addComponents[i] = a.getComponents()[i] + b.getComponents()[i];
        }
        return new Vector(addComponents);
    }

    // Subtracts two given vectors
    public static Vector subtract(Vector a, Vector b) {
        double[] subComponents = new double[a.getComponents().length];
        for (int i = 0; i < subComponents.length; i++) {
            subComponents[i] = a.getComponents()[i] - b.getComponents()[i];
        }
        return new Vector(subComponents);
    }

    // Multiplies a vector and a scalar
    public static Vector multiply(Vector a, double t) {
        double[] multComponents = new double[a.getComponents().length];
        for (int i = 0; i < multComponents.length; i++) {
            multComponents[i] = a.getComponents()[i]*t;
        }
        return new Vector(multComponents);
    }

    // Divides a vector and a scalar
    public static Vector divide(Vector a, double t) {
        return multiply(a, 1.0/t);
    }

    // Calculates which vector is larger (by magnitude).
    // Returns -1 if a < b. Returns 0 if a = b, Returns 1 if a > b
    public static int compareTo (Vector a, Vector b) {
        if (a.getMagnitude() < b.getMagnitude()) {
            return -1;
        } else if (a.getMagnitude() > b.getMagnitude()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static double[] copyArray(double[] a) {
        double[] copy = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        return copy;
    }
}
