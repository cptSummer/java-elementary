import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        funcOneToNine();
//        System.out.println();
//        funcFactorial();
//        System.out.println("_____While_____");
//        funcWhile();
//        System.out.println("____Do While____");
//        funcDoWhile();
        System.out.println("____Power X____");
        funcPower();
    }

    static void funcOneToNine() {
        for (int i = 1; i < 100; i += 2) {
            System.out.print(i + " ");
        }
    }

    static void funcFactorial() {
        Scanner sc = new Scanner(System.in);
        int result = 1;
        System.out.println("Enter number of factorial ");
        int f = sc.nextInt();
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        System.out.print("Factorial " + f + " = " + result);
    }

    static void funcWhile() {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i < 100) {
            System.out.print(i + " ");
            i += 2;
        }
        System.out.println("\nWhile factorial");
        int result = 1;
        i = 1;
        System.out.println("Enter number of factorial ");
        int f = sc.nextInt();
        while (i <= f) {
            result = result * i;
            i++;
        }
        System.out.print("Factorial " + f + " = " + result);
    }

    static void funcDoWhile() {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        do {
            System.out.print(i + " ");
            i += 2;
        } while (i < 100);
        System.out.println("\nDo While factorial");
        int result = 1;
        i = 1;
        System.out.println("Enter number of factorial ");
        int f = sc.nextInt();
        do {
            result = result * i;
            i++;
        } while (i <= f);
        System.out.print("Factorial " + f + " = " + result);
    }

    static void funcPower() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter X number");
        int result = 1;
        int x = sc.nextInt();
        System.out.println("Enter N power");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        System.out.println(result);
    }
}
