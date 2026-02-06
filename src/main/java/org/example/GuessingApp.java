package org.example;


import java.util.Scanner;

import static org.example.GameController.restartGame;
import static org.example.GuessValidator.validateGuess;
import static org.example.HintService.hintGenerate;
import static org.example.StorageService.*;
import static org.example.ValidationService.validateNumber;

public class GuessingApp {
    public static void main(String[] args) throws Exception {



        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Number-Guessing Application");

        System.out.println("Enter your Name: ");
        String name = sc.nextLine();


        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();
//        System.out.println("target number "+gameConfig.targetNumber);
        int attempts=0;
        int hint=0;
        int win=0;

        do{

        do{
                attempts++;
                System.out.println("Enter your guess: ");
                int guess=validateNumber(sc);
                String result=validateGuess(guess,gameConfig.targetNumber);
                System.out.println(result);
                if(result.equals("Correct")){
                    win=1;
                    break;
                }
                else{
                    hint++;
                    if(gameConfig.maximumHints > hint){
                       System.out.println(hintGenerate(gameConfig.targetNumber,hint));
                    }
                }
        } while(attempts<gameConfig.getMaximumAttempts());
        storeDatasTofile(attempts,name,win);
        storeDataT0DataBase(attempts,name,win);
        if(attempts==7){
            System.out.println("Thank you for playing!\n" +
                    "You have reached Maximum Number of attempts");
        }
        System.out.println("If you Want to View DataBase For Result Details...");
        String s=sc.nextLine();
        if(s.equalsIgnoreCase("Yes")){
            viewStoredData();
        }
        else if(s.equalsIgnoreCase("No")){
            System.out.println("Thank you for playing!");
        }
        }while(restartGame(sc));


    }
}
