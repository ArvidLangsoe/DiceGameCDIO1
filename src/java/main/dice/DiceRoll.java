package dice;

import java.util.Arrays;

public class DiceRoll {

    private int[] values;

    public DiceRoll(Die[] dice) {
        values = new int[dice.length];

        for(int i=0; i<dice.length; i++){
            values[i]= dice[i].getValue();
        }
    }

    public int[] getValues(){
        return Arrays.copyOf(values, values.length);
    }

    public int getSum(){
        int sum=0;
        for(int val : values)
            sum+=val;
        return sum;
    }


    public boolean isPair(){
        int testVal= values[0];

        for(int diceVal : values){
            if(testVal!=diceVal){
                return false;
            }
        }
        return true;
    }


    public boolean isPairWithValue(int value){
        return isPair()&&(value==values[0]);
    }


}
