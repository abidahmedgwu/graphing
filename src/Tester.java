
public class Tester {

    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 1, 1);
        Vector3D b = new Vector3D(0, 3, 4);

        System.out.println(Vector3D.dotProduct(a, b));
        System.out.println(Vector3D.crossProduct(a, b));
        System.out.println(b.getUnitVector());

        double[] nums = {2, 5, 1, 3, 2};
        printArray(Derivative.deriveStandardPolynomial(nums));
        System.out.println(Point3D.distance(new Point3D(2, 2, Math.pow(8, .5)), new Point3D(0, 0, 0)));

        Line2D line1 = new Line2D(2, 2);
        Line2D line2 = new Line2D(0, 2);
        System.out.println(Line2D.getIntersection(line1, line2));

        Point2D test = new Point2D(0, 0);
        System.out.println(test);
        test.move(1, 1);
        System.out.println(test);

        Point3D test1 = new Point3D(0,0,0);
        Point3D test2 = new Point3D(5,2,6);
        System.out.println(Vector3D.getVector3D(test1, test2));

        Line3D line = new Line3D(new Point3D(1,2,3), new Vector3D(2,3,4));
        System.out.println(line.parametricEquation());
    }

    public static void printArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
