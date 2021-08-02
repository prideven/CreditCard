package card;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaCardTest {

    @Test
    void checkIfValidCard() {
        String number1 = "912000000000000";
        String number2 = "4120000000000";
        CreditCard card1 = new VisaCard(number1);
        CreditCard card2 = new VisaCard(number1);
        Assert.assertEquals(false, card1.checkIfValidCard(number1));
        Assert.assertEquals(true, card2.checkIfValidCard(number2));
    }
}