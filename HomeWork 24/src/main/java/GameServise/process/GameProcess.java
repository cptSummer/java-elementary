package GameServise.process;


import GameServise.files.LoggerFile;
import GameServise.files.ResultFile;
import GameServise.user.AiService;
import GameServise.user.Player;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class GameProcess {
    Statistic statistic = new Statistic();

    public void startGame(Player player, ResourceBundle resourceBundle) throws IOException, URISyntaxException {
        LoggerFile log = new LoggerFile();
        new LoggerFile().createLoggerFolder();
        log.logDateTime();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        log.info("Player :: " + player.getName() + " started game with " + player.getGameRound() + " rounds");


        while (i != player.getGameRound()) {
            i++;
            int userElement = 0;
            int aiElement = 0;
            byte checkAns = 0;

            System.out.println(resourceBundle.getString("element_1")); //locale
            do {
                System.out.print(resourceBundle.getString("element_2")); //locale
                userElement = sc.nextByte();
                if (!List.of(1, 2, 3).contains(userElement)) {
                    log.warn("an invalid value was entered -> " + userElement);
                }
            } while (!List.of(1, 2, 3).contains(userElement));

            aiElement = new AiService().aiMove();

            System.out.println(resourceBundle.getString(playerElement(userElement - 1)));
            System.out.println(resourceBundle.getString(aiElement(aiElement)));
            System.out.println(resourceBundle.getString(matrixWLT(userElement - 1, aiElement)));     //locale

            log.info("\n" + matrixWLT(userElement - 1, aiElement));
            growNum(userElement - 1, aiElement, player);


            if (i != player.getGameRound()) {
                System.out.println(resourceBundle.getString("continue"));                   //locale
                checkAns = sc.nextByte();
                if (checkAns == 2) {
                    player.setGameRound(i);
                    System.out.println(resourceBundle.getString("end"));                     //locale
                    break;
                }
            }
            log.info("played rounds " + i);
            log.info("remaining rounds " + (player.getGameRound() - i));
        }

        System.out.println("_______________________________________");
        log.info("Player end game with " + player.getGameRound() + " rounds");
        statistic.endGame(player, resourceBundle);                                                  //locale
        log.result(player.toString());
        new ResultFile().fileCOrWResult(player);
    }


    private String matrixWLT(int userElement, int aiElement) {                          //locale
        String[][] matrix = {
                {"tie_round", "player_win", "player_win"},

                {"computer_win", "tie_round", "computer_win"},

                {"computer_win", "player_win", "tie_round"}
        };
        return matrix[userElement][aiElement];
    }

    private String aiElement(int ai) {
        String[] aiArr = {"aiRock", "aiPaper", "aiScissors"};
        return aiArr[ai];
    }

    private String playerElement(int player) {
        String[] playerArr = {"playerRock", "playerPaper", "playerScissors"};
        return playerArr[player];
    }


    private void growNum(int user, int ai, Player player) {
        if (user == ai) player.setTieRounds(player.getTieRounds() + 1);
        if ((user == 0 && ai == 1) || (user == 2 && ai == 0) || (user == 1 && ai == 2)) {
            player.setUserLouse(player.getUserLouse() + 1);
        }
        if ((ai == 0 && user == 1) || (ai == 1 && user == 2) || (user == 0 && ai == 2)) {
            player.setUserWin(player.getUserWin() + 1);
        }
    }


}
