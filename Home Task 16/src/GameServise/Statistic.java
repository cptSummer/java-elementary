package GameServise;

public class Statistic {

    public void endGame(Player player) {
        System.out.println("S T A T I S T I C S");
        System.out.println("Player name :: " + player.getName());
        System.out.println("Game rounds :: " + player.getGameRound());
        System.out.println("User win :: " + player.getUserWin());
        System.out.println("User louse :: " + player.getUserLouse());
        System.out.println("Tie rounds :: " + player.getTieRounds());
    }
}
