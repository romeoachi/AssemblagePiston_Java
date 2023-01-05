package ary.assemblagepiston.demo.domain;

import java.util.Random;

public class RandomUtils {
    private static final int MIN_CHANCE = 0;
    private static final int MAX_CHANGE = 3;

    private static final int MIN_TIME_REPARATION = 5;
    private static final int MAX_TIME_REPARATION = 10;

    private static final Random rand = new Random();

    private RandomUtils(){

    }

    public static boolean isMachineDown(){
        return rand.nextInt(MAX_CHANGE - MIN_CHANCE) + MIN_CHANCE < 1;
    }

    public static Double getExtraTimeDurationTrouble(boolean isTrouble){
        if(isTrouble)
            return (double) (rand.nextInt(MAX_TIME_REPARATION - MIN_TIME_REPARATION) + MIN_TIME_REPARATION);
        return (double) 0;
    }
}
