package org.example;

import java.util.Scanner;

public class ValidationService {

    public static int validateNumber( Scanner scanner) throws Exception{
            try{
            int n = Integer.parseInt(scanner.nextLine());
            if (n < 0 || n > 100) {
                   throw new InvalidInputException("Number Should be between 0 and 100");
            }
            return n;
            }catch(NumberFormatException e){
                throw new InvalidInputException("This is invalid input.Please Enter Integers Only");
            }
    }

}
