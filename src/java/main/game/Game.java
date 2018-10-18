package game;

import dice.DiceCup;
import player.Player;

public class Game {

    private final DiceCup diceCup;
    private final GameView gameView;
    private Player[] players;
    protected Player currentPlayer;
    private int turnCounter=0;

    public Game(){
        diceCup = new DiceCup();
        gameView = new GameView();
        players = new Player[2];
        for (int i=0; i<2; i++){
            players[i]=new Player();
        }
    }

    public void playGame() {
        //Refactor: Player should probably be setup in a different class and view and then be passed to the Game class.
        setupPlayers();

        //Refactor: This could be printed when gameView is created instead
        gameView.printRules();

        while(true){
            currentPlayer = players[turnCounter];

            //This could be created by a factory that also produced dicecup? Removes a dependency to dicecup from Game.
            new Turn(diceCup,currentPlayer,gameView).playTurn();
            if(currentPlayer.hasWon()){
                break;
            }
            nextTurn();
        }

        //Refactor?: This could be moved to the turn class. To remove dependency to GameView.
        // Arguable whether this move is useful.
        gameView.printWinner(currentPlayer);

    }

    private void setupPlayers(){
        for (Player player : players) {
            gameView.setupPlayer(player);
        }
    }

    private void nextTurn(){
        if(!currentPlayer.hasExtraTurn()){
            turnCounter= (turnCounter+1)%players.length;
        }
        else{
            currentPlayer.setHasExtraTurn(false);
        }
    }
}
