import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("___From 1 to 99____");
//        funcOneToNine();
//        System.out.println("____Factorial____");
//        funcFactorial();
//        System.out.println("_____While_____");
//        funcWhile();
//        System.out.println("____Do While____");
//        funcDoWhile();
//        System.out.println("____Power X____");
//        funcPower();
//        System.out.println("____First Ten____");
//        funcFirstTen();
//        System.out.println("____Multiplication Table____");
//        funcMultiTable();
//        System.out.println("____First Ten Odd Numbers in Array____");
//        funcArrOdd();
//        System.out.println("___Max Min in Array");
//        funcMinMax();
//        System.out.println("____Swap Max Min___");
//        funcSwapMinMax();
//        System.out.println("____Average number of array____");
//        funcAverageArr();
        System.out.println("____Chess Board____");
        funcChessBoard();

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
        System.out.println("The number " + x + " in power " + n + " = " + result);
    }

    static void funcFirstTen() {
        int k = 0;
        for (int i = 0; i > -100; i -= 5) {
            if (k == 10) {
                break;
            }
            System.out.println(k + 1 + " :: " + i);
            k++;
        }
    }

    static void funcMultiTable() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter number for multiplication table");
        int num = sc.nextInt();
        int result;
        for (int i = 0; i < 10; i++) {
            result = num * (i + 1);
            System.out.println(num + " * " + (i + 1) + " = " + result);
        }
    }

    static void funcArrOdd() {
        int[] arr = new int[10];
        int j = 0;
        for (int i = 0; i < 100; i++) {
            if (j == 10) {
                break;
            } else if (i % 2 != 0) {
                arr[j] = i;
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    static void funcMinMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of numbers in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30);
        }
        int min_s = arr[0];
        int max_s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min_s > arr[i]) {
                min_s = arr[i];
            }
            if (max_s < arr[i]) {
                max_s = arr[i];
            }
        }
        System.out.println("\nMax elements");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max_s) {
                System.out.print(max_s + " ");
            }
        }
        System.out.println("\nMin elements");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min_s) {
                System.out.print(min_s + " ");
            }
        }
    }

    static void funcSwapMinMax() {
        int[] arr = new int[]{10, 4, 55, 0, 1, 44, -6};
        int min = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = min;
            } else if (arr[i] == min) {
                arr[i] = max;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    static void funcAverageArr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of numbers in array");
        int n = sc.nextInt();
        double result = 0;
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 30);
        }
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println("Average of " + n + " numbers of array = " + result / n);
    }

    static void funcChessBoard() {
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + i) % 2 == 0) {
                    board[i][j] = "W";
                } else {
                    board[i][j] = "B";
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
