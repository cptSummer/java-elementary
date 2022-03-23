package GameServise;

import java.util.List;
import java.util.Scanner;

public class GameProcess {
    private final String[] elements = {"rock", "paper", "scissors"};
    Statistic statistic = new Statistic();

    public void startGame(Player player) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println(player.getGameRound());
        while (i != player.getGameRound()) {
            player.setGameRound(i++);
            int userElement = 0;
            int aiElement = 0;
            byte checkAns = 0;

            System.out.println("Enter your element\nRock-1, paper-2 or scissors-3");
            do {
                System.out.print("Element :: ");
                userElement = sc.nextByte();
            } while (!List.of(1, 2, 3).contains(userElement));

            aiElement = (byte) (Math.random() * 3);

            System.out.println("Your element = " + elements[userElement - 1] + "\nAI element = " + elements[aiElement]);

            String condition = matrixWLT(userElement - 1, aiElement);
            System.out.println(condition);
            growNum(condition, player);


            System.out.println("Continue?\ncontinue-1 end-2");
            checkAns = sc.nextByte();
            if (checkAns == 2) {
                player.setGameRound(i);
                System.out.println("end");
                break;
            }
            System.out.println(i);
            System.out.println(player.getGameRound());
        }
        System.out.println("_______________________________________");
        statistic.endGame(player);
    }

    private String matrixWLT(int userElement, int aiElement) {
        String[][] matrix = new String[3][3];
        matrix[0][0] = "Tie";
        matrix[0][1] = "Louse";
        matrix[0][2] = "Win";
        matrix[1][0] = "Win";
        matrix[1][1] = "Tie";
        matrix[1][2] = "Louse";
        matrix[2][0] = "Louse";
        matrix[2][1] = "Win";
        matrix[2][2] = "Tie";

        return matrix[userElement][aiElement];
    }

    private void growNum(String condition, Player player) {
        switch (condition) {
            case "Tie" -> player.setTieRounds(player.getTieRounds() + 1);
            case "Win" -> player.setUserWin(player.getUserWin() + 1);
            case "Louse" -> player.setUserLouse(player.getUserLouse() + 1);
        }
    }

}
