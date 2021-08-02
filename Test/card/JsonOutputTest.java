package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonOutputTest {
    @Test
    void out() {
        CreditCard card1 = new CreditCard("5410000000000000", "4/20/2030", "Alice", "VISA","");
        ArrayList<CreditCard> testlist = new ArrayList();
        testlist.add(card1);
        String out = "{\"creditCardNumber\":\"5410000000000000\",\"date\":\"4/20/2030\",\"name\":\"Alice\",\"issuer\":\"Visa\",\"error\":\"\"}";
        JsonOutput jasonOut = new JsonOutput(testlist);
        jasonOut.out();
        assert out.equals(jasonOut.JUnitTestString);
    }
}