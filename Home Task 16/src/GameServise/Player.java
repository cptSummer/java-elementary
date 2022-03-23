package GameServise;

import java.util.Scanner;

public class Player {
    private String name;
    private int gameRound;
    private int userWin;
    private int userLouse;
    private int tieRounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameRound() {
        return gameRound;
    }

    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public int getUserWin() {
        return userWin;
    }

    public void setUserWin(int userWin) {
        this.userWin = userWin;
    }

    public int getUserLouse() {
        return userLouse;
    }

    public void setUserLouse(int userLouse) {
        this.userLouse = userLouse;
    }

    public int getTieRounds() {
        return tieRounds;
    }

    public void setTieRounds(int tieRounds) {
        this.tieRounds = tieRounds;
    }
}
