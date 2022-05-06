package GameServise.process;

import GameServise.user.Player;

import java.util.ResourceBundle;

public class Statistic {
    Player player = new Player();

    public void endGame(Player player, ResourceBundle resourceBundle) {
        System.out.println("===============================================");
        System.out.println(resourceBundle.getString("statistic"));
        System.out.println(resourceBundle.getString("player") + player.getName());
        System.out.println(resourceBundle.getString("rounds")+ player.getGameRound());
        System.out.println(resourceBundle.getString("win") + player.getUserWin());
        System.out.println(resourceBundle.getString("louse") + player.getUserLouse());
        System.out.println(resourceBundle.getString("tie") + player.getTieRounds());
        System.out.println("===============================================");
    }

}
