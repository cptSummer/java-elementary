package main;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Scanner sc = new Scanner(System.in);
        String path = "";
        String answer;
        System.out.println("Enter path to file or not");
        System.out.println("Enter: y or n");
        do{
            System.out.print(":: ");
            answer = sc.next();
        }while (!answer.equals("y") && !answer.equals("n"));
        sc.nextLine();
        if (answer.equals("y")){
            System.out.println("Enter path");
            path = sc.nextLine();
        }else{
           path = checkDirectory();
        }
        System.out.println(path);
    }

    private static String checkDirectory() throws URISyntaxException {
        return new File((Main.class
                .getProtectionDomain()
                .getCodeSource().getLocation()
                .toURI()).getPath()).getParent();

    }
}
