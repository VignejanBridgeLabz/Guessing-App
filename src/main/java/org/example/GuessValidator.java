package org.example;

public class GuessValidator {
    public static String validateGuess(int guess,int target){
        if(guess==target){
            return "Correct";
        }
        else if(guess>target){
            return "High";
        }
        return "Low";
    }
}
