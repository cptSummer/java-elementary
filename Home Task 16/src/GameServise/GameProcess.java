package GameServise;

import java.util.List;
import java.util.Scanner;

public class GameProcess {
    private final String[] elements = {"rock", "paper", "scissors"};
    Statistic statistic = new Statistic();

    public void startGame(Player player) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i != player.getGameRound()) {
            i++;
            int userElement = 0;
            int aiElement = 0;
            byte checkAns = 0;

            System.out.println("Enter your element\nRock-1, paper-2 or scissors-3");
            do {
                System.out.print("Element :: ");
                userElement = sc.nextByte();
            } while (!List.of(1, 2, 3).contains(userElement));

            aiElement = new AiService().aiMove();


            System.out.println(matrixWLT(userElement - 1, aiElement));
            growNum(userElement-1,aiElement,player);


            if (i != player.getGameRound()) {
                System.out.println("Continue?\ncontinue-1 end-2");
                checkAns = sc.nextByte();
                if (checkAns == 2) {
                    player.setGameRound(i);
                    System.out.println("end");
                    break;
                }
            }
        }
        System.out.println("_______________________________________");
        statistic.endGame(player);
    }

    private String matrixWLT(int userElement, int aiElement) {
        String[][] matrix = {
            {" Computer --> rock, \n Player --> rock \n Computer == Player",
                    " Computer --> paper, \n Player --> rock \n Player win!",
                    " Computer --> scissors, \n Player --> rock \n Player win!"},

            {" Computer --> rock, \n Player --> paper \n Computer win!",
                    " Computer --> rock, \n Player --> rock \n Computer == Player",
                    " Computer --> scissors, \n Player --> paper \n Computer win!"},

            {" Computer --> rock, \n Player --> scissors \n Computer win!",
                    " Computer --> paper, \n Player --> scissors \n Player win!",
                    " Computer --> rock, \n Player --> rock \n Computer == Player"}
        };
        return matrix[userElement][aiElement];
    }

    private void growNum(int user, int ai, Player player) {
        if(user == ai) player.setTieRounds(player.getTieRounds()+1);
        if((user==0 && ai == 1) || (user==2 && ai == 0) || (user==1 && ai ==2)){ player.setUserLouse(player.getUserLouse()+1);}
        if((ai==0 && user == 1) || (ai==1 && user ==2)|| (user==0 && ai == 2)){player.setUserWin(player.getUserWin()+1);}
    }

}
