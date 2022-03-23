package GameServise;

import java.util.Scanner;

public class Engine {



    public void runGame() {
        Player player = new CreateUser().createNewPlayer();

       new GameProcess().startGame(player);
//        statistic.endGame();

    }


}
