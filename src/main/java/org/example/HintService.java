package org.example;

public class HintService {
    public static String hintGenerate(int target, int hint){
        if(hint==1){
            return (target%2==0)? "Hint: Target Number is Even":
                    "Hint: Target Number is Odd";
        }
        else if(hint==2){
            return (target>50)? "Hint:Target number grater than 50":
                    "Hint: Target number less than 50";
        }
        return "No more Hints are Available";
    }
}
