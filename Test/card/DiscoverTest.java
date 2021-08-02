package card;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscoverTest {

    @Test
    void checkIfValidCard() {
        String cardNumber1 = "6111000000000000";
        String cardNumber2 = "6011000000000000";
        CreditCard card1 = new Discover(cardNumber1);
        Assert.assertEquals(false, card1.checkIfValidCard(cardNumber1));
        CreditCard card2 = new Discover(cardNumber2);
        Assert.assertEquals(true, card2.checkIfValidCard(cardNumber2));
    }
}