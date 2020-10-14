package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    CreditCard creditCard = new CreditCard();

    @Test
    public void checkIfCreditCardIsTrue(){
        String properCreditCardLength = "5542564575935209";
        creditCard.checkIfCreditCard(properCreditCardLength);
        assertFalse(false);
        String falseCreditCardLength = "53412345";
        creditCard.checkIfCreditCard(falseCreditCardLength);
    }

    @Test
    public void checkIfItContainsNotOnlyNumbers(){
        String fakeCreditCard = "A9927398716";
            creditCard.checkIfCreditCard(fakeCreditCard);
            assertFalse(false);
        String realCreditCard = "5153747228334579";
            creditCard.checkIfCreditCard(realCreditCard);
            assertFalse(false);
    }

    @Test
    public void checkIfNull(){
        assertThrows(NullPointerException.class, () ->{
            creditCard.validateCreditCard(null);
            creditCard.checkProvided(null);
        });
    }

    @Test
    public void checkIfNotNull(){
        String creditCardNumber = "4242424242424242";
        creditCard.validateCreditCard(creditCardNumber);
        assertNotNull(creditCardNumber);
    }

    @Test
    public void checkIfOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () ->{
            creditCard.validateCreditCard("");
            creditCard.checkProvided("");
        });
    }
}
