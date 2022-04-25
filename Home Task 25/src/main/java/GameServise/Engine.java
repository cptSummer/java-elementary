package GameServise;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Engine {



    public void runGame() throws IOException, URISyntaxException {
        Player player = new CreateUser().createNewPlayer();

       new GameProcess().startGame(player);
//        statistic.endGame();

    }


}
