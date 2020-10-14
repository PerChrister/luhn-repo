package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CreditCard cc = new CreditCard();
        Scanner scan = new Scanner(System.in);

        String creditCardNumber;

        System.out.println("Input: ");
        creditCardNumber = scan.next();

        cc.validateCreditCard(creditCardNumber);
        cc.checkProvided(creditCardNumber);

        scan.close();
    }
}