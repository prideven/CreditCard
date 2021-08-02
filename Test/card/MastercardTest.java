package card;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MastercardTest {

    @Test
    void checkIfValidCard() {
        String number1 = "5410000000000000";
        String number2 = "74100000000000";
        CreditCard card1 = new Mastercard(number1);
        CreditCard card2 = new Mastercard(number2);
        Assert.assertEquals(true, card1.checkIfValidCard(number1));
        Assert.assertEquals(false, card2.checkIfValidCard(number2));
    }
}