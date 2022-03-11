import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    private String num;
    Scanner sc = new Scanner(System.in);

    public void captcha() {
        System.out.println("Please enter number from 0 to 9");
        num = sc.nextLine();
        String[] arrNum = new StringBuffer(num).reverse().toString().replace(" ", "").split("");
        String[] stringNumArr = {"", "", "", "", ""};
        String[] tempArr;
        try {
            for (String s : arrNum) {
                tempArr = getGraphical(s);
                for (int i = 0; i < stringNumArr.length; i++) {
                    stringNumArr[i] = tempArr[i] + " " + stringNumArr[i];
                }
            }
            Arrays.stream(stringNumArr).forEach(System.out::println);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong number! Enter number from 0 to 9");
        }

    }

    private String[] getGraphical(String number) {

        switch (number) {
            case "1" -> {
                return new String[]{
                        "  @@  ",
                        " @@@  ",
                        "@ @@  ",
                        "  @@  ",
                        "@@@@@@"};

            }
            case "2" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        "  @@  ",
                        "@@@@@@"};
            }
            case "3" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "   @@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "4" -> {
                return new String[]{
                        "   @@ ",
                        "  @ @ ",
                        " @  @ ",
                        "@@@@@@",
                        "    @ "};
            }
            case "5" -> {
                return new String[]{
                        "@@@@@@",
                        "@@    ",
                        "@@@@@ ",
                        "    @@",
                        "@@@@@ "};
            }
            case "6" -> {
                return new String[]{
                        " @@@@ ",
                        "@@    ",
                        "@@@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "7" -> {
                return new String[]{
                        "@@@@@@",
                        "   @@ ",
                        "  @@  ",
                        " @@   ",
                        "@@    "};
            }
            case "8" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ ",
                        "@@  @@",
                        " @@@@ "};
            }
            case "9" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        " @@@@@",
                        "    @@",
                        " @@@@ "};
            }
            case "0" -> {
                return new String[]{
                        " @@@@ ",
                        "@@  @@",
                        "@@  @@",
                        "@@  @@",
                        " @@@@ "};
            }
            default -> {
                return new String[]{"ERROR"};
            }
        }
    }
}
