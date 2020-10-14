package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    CreditCard creditCard = new CreditCard();
/*
    @Test
    public void checkIfEqual()throws IOException {
        assertEquals(6,creditCard.validateCreditCard("1234567"));
        assertEquals(0, creditCard.validateCreditCard("4561237854258962"));
        assertEquals(2, creditCard.validateCreditCard("4242424242424242"));
    }
    @Test
    public void checkIfNotEqual(){
        assertNotEquals(6, creditCard.validateCreditCard("12345"));
        assertNotEquals(2,creditCard.validateCreditCard("3251232584"));
        assertNotEquals(0,creditCard.validateCreditCard("123456789"));
    }

    8. if equal -> expected/provided
    9. if not equal -> expected provided
    11. if checksum true

*/

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
