package com.company;

import java.lang.Object;


public class CreditCard {

    public void validateCreditCard(String creditCardNumber){

        int luhnNum1 = 0, luhnNum2 = 0; // luhnNum1 is used to hold the odd digits, luhnNUm2 is used to hold the even digits
        int checkDigit;

        String reverse = new StringBuffer(creditCardNumber).reverse().toString(); // StringBuffer is used since it has the .reverse() function and in order to calculate the luhn we start from the right

        // The calculation can now be solved right since it's reversed
        for (int num = 0; num < reverse.length(); num++) {

            int digit = Character.digit(reverse.charAt(num), 10); // Checks character by character. The digit() method checks if the character is less than 10 (For mod10)

            if (num % 2 == 0) { //this is for odd placed digits, they are 1-indexed in the algorithm

                luhnNum1 += digit; // Holds the value of even digits and adds up

            } else { // Holds the value of the even-placed/doubled digits and adds up

                luhnNum2 += 2 * digit; // Adds 2 multiplied by digit for numbers 0 to 4

                if (digit >= 5) { // Adds 2 multiplied by digit minus 9 for numbers 5-9

                    luhnNum2 -= 9;
                    /*
		             Minus 9 leads to digit + digit's sum and digit - 9 to be equal.
                     For example: 9 + 9 = 18
                     1 + 8 = 9
                     18 - 9 = 9
                     9 == 9
                    */
                }
            }
        }
        checkDigit = ((luhnNum1 + luhnNum2)*9);

        checkIfValid(luhnNum1, luhnNum2, checkDigit, creditCardNumber);

    }

    public void checkIfValid(int luhnNum1, int luhnNum2, int checkDigit, String creditCardNumber){
        String cardStatus;
        if ((luhnNum1 + luhnNum2) % 10 == 0) {
            cardStatus = "Valid";
            System.out.print("Checksum: " + cardStatus + " ");
            checkIfCreditCard(creditCardNumber);
            System.out.println("Expected number: " + checkDigit%10);

        } else {
            cardStatus = "Invalid";
            System.out.print("Checksum: " + cardStatus + " ");
            checkIfCreditCard(creditCardNumber);
            System.out.println("Expected number: " + checkDigit%10);
        }
    }

    public void checkIfCreditCard(String creditCardNumber){
        if (creditCardNumber.length() == 16){
            System.out.println("(credit card)");
        } else {
            System.out.println("Not a credit card");
        }
    }

    public void checkProvided(String creditCardNumber){
        int providedNumber = Character.getNumericValue(creditCardNumber.charAt(creditCardNumber.length()-1));
        System.out.println("Provided number: " + providedNumber);
    }

}
