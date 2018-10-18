package dice;

import java.util.Random;

class Die {

    private int value;

    Die(){
        roll();
    }

    Die(int value){
        this.value=value;
    }

    int roll(){
        Random r = new Random();
        value=r.nextInt(6)+1;
        return value;
    }

    int getValue() {
        return value;
    }
}
