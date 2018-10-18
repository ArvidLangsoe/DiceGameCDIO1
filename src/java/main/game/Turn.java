package game;

import dice.DiceCup;
import dice.DiceRoll;
import player.Player;

class Turn {

    private DiceCup cup;
    private Player player;
    private GameView view;
    protected DiceRoll diceRoll;

    Turn(DiceCup cup, Player player, GameView view){
        this.cup = cup;
        this.player = player;
        this.view = view;
    }

    void playTurn(){
        view.informTurn(player);
        turnRoll();

        checkPlayerHasLuckyWin();
        checkPlayerLostAllPoints();

        checkForWinAndExtraTurn();

        updatePlayerData();
        view.printTurn(diceRoll,player);

    }

    private void turnRoll(){
        diceRoll= cup.roll();
    }

    private void checkPlayerHasLuckyWin(){
        if(player.getLastRoll()==null){
            return;
        }
        if(player.getLastRoll().isPairWithValue(6)&&diceRoll.isPairWithValue(6)){
            player.setHasWon(true);
            player.setHasLuckyWin(true);
        }
    }

    private void checkPlayerLostAllPoints(){
        if(diceRoll.isPairWithValue(1)){
            player.resetPoints();
        }
    }

    private void checkForWinAndExtraTurn(){
        if(diceRoll.isPair()){
            player.setHasExtraTurn(true);
            if(player.getPoints()>=40){
                player.setHasWon(true);
            }
        }

    }


    private void updatePlayerData(){
        if(!diceRoll.isPairWithValue(1)) {
            player.addPoints(diceRoll.getSum());
        }
        player.setLastRoll(diceRoll);
    }


}
