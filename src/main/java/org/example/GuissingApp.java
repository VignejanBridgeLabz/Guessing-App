package org.example;


import java.util.Scanner;

import static org.example.GuessValidator.validateGuess;
import static org.example.HintService.hintGenerate;

public class GuissingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Number-Guessing Application");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
//        System.out.println("target number "+gameConfig.targetNumber);

        int attempts=0;
        int hint=0;
        do{     attempts++;
                System.out.println("Enter your guess: ");
                int guess = sc.nextInt();
                String result=validateGuess(guess,gameConfig.targetNumber);
                System.out.println(result);
                if(result.equals("Correct")){
                    break;
                }
                else{
                    hint++;

                    System.out.println(hintGenerate(gameConfig.targetNumber,hint));
                }
        } while(attempts<gameConfig.getMaximumAttempts());
        if(attempts==7){
            System.out.println("Thank you for playing!\n" +
                    "You have reached Maximum Number of attempts");
            return;
        }

    }
}
