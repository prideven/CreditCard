package card;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AmericanExpressTest {

    @Test
    void checkIfValidCard() {

        String cardNumber1 = "379000000700000";
        String cardNumber2 = "79000000700000";

        CreditCard testcard1 = new AmericanExpress(cardNumber1);
        CreditCard testcard2 = new AmericanExpress(cardNumber2);

        assertEquals(true, testcard1.checkIfValidCard(cardNumber1));
        assertEquals(false, testcard2.checkIfValidCard(cardNumber2));
    }

}