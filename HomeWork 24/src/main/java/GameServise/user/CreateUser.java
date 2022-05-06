package GameServise.user;

import java.util.ResourceBundle;
import java.util.Scanner;

public class CreateUser {

    public Player createNewPlayer(ResourceBundle resourceBundle) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        System.out.println(resourceBundle.getString("greetings") + "\n🏔🏔🏔 📜📜📜 ✂✂✂");
        System.out.println(resourceBundle.getString("name_1"));
        System.out.print(resourceBundle.getString("name_2"));
        player.setName(sc.nextLine());
        System.out.println(resourceBundle.getString("rounds_1"));
        System.out.print(resourceBundle.getString("rounds_2"));
        player.setGameRound(sc.nextInt());
        return player;
    }
}
