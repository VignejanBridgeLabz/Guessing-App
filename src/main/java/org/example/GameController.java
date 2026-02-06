package org.example;

import java.util.Scanner;

public class GameController {
    public static boolean restartGame(Scanner sc){
        boolean gameOver = false;
        System.out.println("Do you want to restart the game?");
        String restart = sc.nextLine();
        if(restart.equalsIgnoreCase("yes")){
            gameOver = true;
        }
        else{
            System.out.println("Exit the Game");
        }
     return gameOver;
    }
}
