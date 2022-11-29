package org.hw_15.q5;

public class Q5 {
    public static int stringToInt(String input){
        try{
            int temp = Integer.parseInt(input);
            if (-32767 <= temp && temp <= 32767)
                return temp;
            else
                throw new RuntimeException("Your input must be between -32767 _ 32767 .");

        } catch (NumberFormatException ne){
            throw new NumberFormatException("Your input is not valid.");
        }
    }
}