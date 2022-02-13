package QuadraticEquation;

public class RootSqrt {

    public double rootPlus(double a, double b) {
        return Math.pow(a, 2) + (2 * a * b) + Math.pow(b, 2);
    }

    public int rootPlus(int a, int b) {
        return (int) (Math.pow(a, 2) + (2 * a * b) + Math.pow(b, 2));

    }

    public double rootMinus(double a, double b) {
        return Math.pow(a, 2) - (2 * a * b) + Math.pow(b, 2);
    }

    public int rootMinus(int a, int b) {
        return (int) (Math.pow(a, 2) - (2 * a * b) + Math.pow(b, 2));
    }

    public void quad(double a, double b, double c) {
        double D = 0;
        D = (b * b) - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Equation roots: x1= " + x1 + ", x2= " + x2);
        } else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("The equation has only one root: x= " + x);
        } else {
            System.out.println("The equation has no real roots!");
        }
    }

}
