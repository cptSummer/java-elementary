import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Average of two numbers");
        averageTwo();
        System.out.println();
        System.out.println("Average of numbers");
        averageNum();
        System.out.println();
        bank();
    }

    static void averageTwo() {
        Scanner s = new Scanner(System.in);
        System.out.println("Input first number");
        double a = s.nextDouble();
        System.out.println("Input second number");
        double b = s.nextDouble();
        double average = (a + b) / 2;
        System.out.print("Average of two numbers :: " + average);
    }

    static void averageNum() {
        Scanner s = new Scanner(System.in);
        System.out.print("Input number of numbers :: ");
        int k = s.nextInt();
        double a;
        double b = 0;
        for (int i = 0; i < k; i++) {
            System.out.print("Input " + (i + 1) + " number :: ");
            a = s.nextDouble();
            b += a;
        }
        double average = b / k;
        System.out.print("Average of numbers :: " + average);
    }

    static void bank() {
        Scanner s = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.print("Enter the amount of money :: ");
        double money = s.nextDouble();
        System.out.print("Percentage per annum :: ");
        double percentage = s.nextDouble();
        System.out.print("Duration of deposit (years) :: ");
        double duration = s.nextDouble();


        double resultMoney = (money * percentage * duration) / 100;
        double resultPer = Math.pow((1 + (percentage / 100) / 12), duration);
        String result = decimalFormat.format(resultPer);
        System.out.println("The client will receive " + resultMoney + " at accrued interest " + result);

    }
}
