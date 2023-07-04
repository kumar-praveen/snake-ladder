package org.example;

import java.util.Random;

public class Dice {
    private final Integer maxVal;
    private final Random random = new Random();

    public Dice(Integer maxVal){
        this.maxVal = maxVal;
    }

    public Integer getNumber(){
        return random.nextInt(maxVal) + 1;
    }
}
