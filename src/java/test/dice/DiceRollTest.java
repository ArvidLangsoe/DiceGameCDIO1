package dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceRollTest {



    @Test
    void givenPair_ThenIsPairTrue() {
        Die[] dice = createDice(new int[]{2,2});
        assertTrue(new DiceRoll(dice).isPair());
    }

    @Test
    void givenNonPair_ThenIsPairFalse() {
        Die[] dice = createDice(new int[]{3,2});
        assertFalse(new DiceRoll(dice).isPair());
    }

    @Test
    void givenPair_WhenValuesAre5_ThenIsPairWithValue5IsTrue() {
        Die[] dice = createDice(new int[]{5,5});
        assertTrue(new DiceRoll(dice).isPairWithValue(5));
    }

    @Test
    void givenPair_WhenValuesAre4_ThenIsPairWithValue5IsFalse() {
        Die[] dice = createDice(new int[]{4,4});
        assertFalse(new DiceRoll(dice).isPairWithValue(5));
    }


    private Die[] createDice(int[] values){
        Die[] dice = new Die[values.length];

        for(int i = 0; i <values.length; i++){
            dice[i]= new Die(values[i]);
        }
        return dice;
    }
}