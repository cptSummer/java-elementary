import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClientsService implements IPhone {
    private Phone[] phoneArray;
    Scanner sc = new Scanner(System.in);

    public void createClients() {
        System.out.println("Enter number of clients");
        int n = sc.nextInt();
        phoneArray = new Phone[n];
        System.out.println("Enter information of clients (through a space)");
        System.out.println("id\tlast name\tfirst name\tpatronymic\tbirthday\taddress\tphone number\tcredit card" +
                "\tdebit\tcredit\ttime urban\ttime intercity\tinternet traffic");
        sc.nextLine();
        String enterStrClients;
        for (int i = 0; i < phoneArray.length; i++) {
            enterStrClients = sc.nextLine();
            String[] words = enterStrClients.split(" ");
            phoneArray[i] = new Phone(Integer.parseInt(words[0]), words[1], words[2],
                    words[3], Integer.parseInt(words[4]),
                    words[5], words[6], words[7], words[8], words[9], Integer.parseInt(words[10]),
                    Integer.parseInt(words[11]), Integer.parseInt(words[12]));
        }
    }

    public void showClientsInfo() {
        for (Phone pho : phoneArray) {
            System.out.println(pho);
        }
    }

    @Override
    public void urbanExceedsSpecified(int time) {
        for (Phone pho : phoneArray) {
            if (pho.getTimeUrban() > time) {
                System.out.println(pho);
            }
        }
    }

    @Override
    public void intercityCommunication() {
        for (Phone pho : phoneArray) {
            if (pho.getTimeIntercity() > 0)
                System.out.println(pho);
        }
    }

    @Override
    public void alphabeticalOrder() {
        System.out.println("Enter number to sorting\n1-first name\t2-last name\t3-Exit");

        while (true){
            System.out.print("Enter number :: ");
            byte i = sc.nextByte();
            if(i==1){
                Arrays.stream(phoneArray).sorted(Comparator.comparing(Phone::getFirstName)).
                        forEach(System.out::println);
            }
            if(i==2){
                Arrays.stream(phoneArray).sorted(Comparator.comparing(Phone::getLastName)).
                        forEach(System.out::println);
            }
            if (i==3){
                System.out.println("Exit");
                break;
            }
        }


    }

    @Override
    public void tenLargestTraffic() {
        Arrays.stream(phoneArray).sorted(Comparator.comparingInt(Phone::getInternetTraffic).reversed())
                .limit(10).forEach(System.out::println);
    }
}
