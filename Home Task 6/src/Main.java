import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClientsService client = new ClientsService();
        Scanner sc = new Scanner(System.in);

        System.out.println("1-Create clients\t2-Show clients Info\t" +
                "3-List of clients whose intracity calls time exceeds the specified\n" +
                "4-List of clients who used long-distance communication\t" +
                "5-List of clients in alphabetical order\n" +
                "6-List of the first 10 clients with the highest Internet traffic\t" +
                "7-End program");
        System.out.println("First, enter client details (enter 1) to unlock features 2 to 6");

        byte k = 0;
        while (true) {
            System.out.print("Enter number :: ");
            byte i = sc.nextByte();
            if (i == 1) {
                k = 1;
                client.createClients();
            }
            if (k == 1) {
                if (i == 2) {
                    client.showClientsInfo();
                } else if (i == 3) {
                    System.out.println("Enter time to check");
                    int time = sc.nextInt();
                    client.urbanExceedsSpecified(time);
                } else if (i == 4) {
                    client.intercityCommunication();
                } else if (i == 5) {
                    client.alphabeticalOrder();
                } else if (i == 6) {
                    client.tenLargestTraffic();
                }
            }
            if (i == 7) {
                System.out.println("Exit");
                break;
            }
        }
    }
}
