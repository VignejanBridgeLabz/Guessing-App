package org.example;

import java.util.Random;

public class GameConfig {
    final int max = 100;
    final int min = 1;
    final int maximumAttempts = 7;
    final int minimumAttempts = 3;
    final  int maximumHints = 4;

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getMaximumAttempts() {
        return maximumAttempts;
    }

    public int getMinimumAttempts() {
        return minimumAttempts;
    }

    int targetNumber;

    public GameConfig() {
        Random rand = new Random();
        this.targetNumber = rand.nextInt(max - min + 1) + 1;
    }

    void showRules(){
        System.out.println("Guss a Number between " + min + " and "+max);
        System.out.println("You Have Maximum  Attempts: " + getMaximumAttempts());
        System.out.println("Hints will be provided after wrong process");
    }
}
