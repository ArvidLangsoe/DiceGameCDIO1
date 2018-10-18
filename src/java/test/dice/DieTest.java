package dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    Die testDie;

    @BeforeEach
    void setup(){
        testDie=new Die();
    }

    @Test
    void givenNewDie_ThenValueIsValid() {
        assertTrue(isValidValue(testDie.getValue()));
    }


    @Test
    void givenDie1000Rolls_ThenNoInvalidValues() {
        for(int i = 0; i<1000;i++){
            assertTrue(isValidValue(testDie.roll()));
        }
    }

    @Test
    void givenDie_WhenRolling60000Times_ThenValuesAreFair(){
        int numTests = 60000;
        int[] values = rollDieStatistics(numTests);

        //Expect die to be fair if roles are rougly 5% of the norm. This is not statisticly correct.
        int expectedNumPerVal=numTests/6;
        double lowerInterval = expectedNumPerVal-expectedNumPerVal*0.05;
        double higherInterval = expectedNumPerVal+expectedNumPerVal*0.05;

        for(int val : values){
            assertTrue(lowerInterval<val && val<higherInterval,"Value "+ val + " was not in interval: [ "+lowerInterval+", "+higherInterval+"]");
        }

    }


    private boolean isValidValue(int value){
        return value>0 && value<7;
    }

    private int[] rollDieStatistics(int numRolls){
        int[] values = new int[6];

        for(int i =0; i <numRolls; i++){
            values[testDie.roll()-1]++;
        }
        return values;
    }




}