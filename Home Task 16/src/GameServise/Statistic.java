package GameServise;

public class Statistic {
    Player player = new Player();

    public void endGame(Player player) {
        System.out.println("===============================================");
        System.out.println("S T A T I S T I C S");
        System.out.println("Player name :: " + player.getName());
        System.out.println("Game rounds :: " + player.getGameRound());
        System.out.println("User win :: " + player.getUserWin());
        System.out.println("User louse :: " + player.getUserLouse());
        System.out.println("Tie rounds :: " + player.getTieRounds());
        System.out.println("===============================================");
    }

//    @Override
//    public String toString() {
//        return "===============================================\n" +
//                "S T A T I S T I C \n"
//                + "\nPlayer name :: " + player.getName()
//                + "\nGame rounds :: " + player.getGameRound()
//                + "\nUser win :: " + player.getUserWin()
//                + "\nUser louse :: " + player.getUserLouse()
//                + "\nTie rounds :: " + player.getTieRounds()
//                + "\n===============================================";
//    }
}
