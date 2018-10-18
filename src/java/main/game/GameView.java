package game;

import dice.DiceRoll;
import player.Player;

import java.util.Scanner;

public class GameView {

    private Scanner sc = new Scanner(System.in);
    private int playerCount = 0;

    public void informTurn(Player player) {
        System.out.println("______________________________________________________");
        System.out.println("Its your turn " + player.getName());
        sc.nextLine();
    }

    public void printTurn(DiceRoll roll, Player player){
        int[] values= roll.getValues();
        System.out.println("You rolled: " + values[0]+", "+values[1]);
        if(!player.hasWon()) {


            if(roll.isPair())
                System.out.println("Its a pair! You get an extra turn");
            if(roll.isPairWithValue(6) && !player.hasLuckyWin())
                System.out.println("You rolled a pair of sixes! Do it again next turn and you win!");

            if(roll.isPairWithValue(1))
                System.out.println("You rolled a pair of ones! You lost all your points.");
            else if(player.getPoints()>=40){
                System.out.println("You have reached 40 points. Roll a pair to win!");
            }
            else {
                System.out.println(player.getName() + "'s score is now: " + player.getPoints());
            }
        }
        System.out.println();
    }

    public void printWinner(Player player){
        if(player.hasLuckyWin()){
            System.out.println("You rolled double sixes twice in a row! You win!");
        }
        else {
            System.out.println(player.getName() + ", you won!");
        }
    }


    public void setupPlayer(Player player){
        System.out.println("Player "+ ++playerCount+", please enter your name:");
        player.setName(sc.nextLine());
    }

    public void printRules(){
        System.out.println("Roll the dice by pressing enter. First player to 40 points who then rolls a pair wins.");
        System.out.println("There are e few special rules! See if you can discover them when playing.");
        System.out.println("Press enter to start.");
        sc.nextLine();
    }
}
