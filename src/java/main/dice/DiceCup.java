package dice;

public class DiceCup {

    private Die[] dice = new Die[2];

    public DiceCup(){
        for(int i = 0; i<dice.length;i++){
            dice[i]= new Die();
        }
    }

    public DiceRoll roll(){
        for(Die d : dice){
            d.roll();
        }
        return new DiceRoll(dice);
    }

}
