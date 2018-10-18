package player;

import dice.DiceRoll;

public class Player {

    private int points = 0;
    private String name = "";
    private boolean hasWon=false;
    private boolean hasLuckyWin=false;
    private boolean hasExtraTurn=false;
    private DiceRoll lastRoll;

    public void resetPoints(){
        points=0;
    }

    public void addPoints(int addedPoints){
        points+= addedPoints;
        if(points>40){
            points=40;
        }
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean hasExtraTurn() {
        return hasExtraTurn;
    }

    public void setHasExtraTurn(boolean hasExtraTurn) {
        this.hasExtraTurn = hasExtraTurn;
    }

    public DiceRoll getLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(DiceRoll lastRoll) {
        this.lastRoll = lastRoll;
    }

    public boolean hasLuckyWin() {
        return hasLuckyWin;
    }

    public void setHasLuckyWin(boolean hasLuckyWin) {
        this.hasLuckyWin = hasLuckyWin;
    }
}
