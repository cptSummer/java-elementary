package RunGame;


import GameServise.process.Engine;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
//This class need to run game
    public static void main(String[] args) throws IOException, URISyntaxException {
        new Engine().runGame();
    }
}
