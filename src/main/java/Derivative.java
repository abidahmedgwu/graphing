// Abid Ahmed
// 10-4-17
// Class that derives functions

public class Derivative {

    /* Derives polynomial functions using power rule.
    Functions must be in the format ax^n + bx^n-1 + ... + c.
    Input is an array of the coefficients of the function in order.
    Include 0s */
    public static double[] deriveStandardPolynomial(double[] coeffs) {
        double[] derived = new double[coeffs.length - 1];
        for (int i = 0; i < derived.length; i++) {
            derived[i] = coeffs[i] * (coeffs.length - i - 1);
        }
        return derived;
    }
}
