import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter number");
        System.out.println("1 - start program || 2 - end program");
        while (true) {
            System.out.print(":: ");
            byte i = new Scanner(System.in).nextByte();
            if (i == 1) {
                new Numbers().captcha();
            } else if (i == 2) {
                System.out.println("Exit...");
                break;
            }
        }
    }
}
